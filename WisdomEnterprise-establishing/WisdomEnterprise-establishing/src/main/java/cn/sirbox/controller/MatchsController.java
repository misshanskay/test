package cn.sirbox.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import cn.sirbox.model.Account;
import cn.sirbox.model.Matchs;
import cn.sirbox.model.Province;
import cn.sirbox.model.page;
import cn.sirbox.service.BookedService;
import cn.sirbox.service.DeductMoneyservice;
import cn.sirbox.service.GetProvinceCityAreaService;
import cn.sirbox.service.MatchsService;
import cn.sirbox.service.impl.LoggerService;
import cn.sirbox.service.impl.UorderService;
import net.sf.json.JSONArray;

@RequestMapping("/matchs")
@Controller
public class MatchsController {

	@Autowired
	private MatchsService matchsService;
	
	@Autowired
	private DeductMoneyservice deductMoneyservice;
	
	@Autowired
	private UorderService uorderService;
	
	@Autowired
	private BookedService bookedService;
	
	@Autowired
	private GetProvinceCityAreaService getProvinceCityAreaService;
	
	@Autowired
	private LoggerService loggerService;
	
	@RequestMapping("/findAll")
	public String findAll(
			Model model,
			@RequestParam(required = false, value = "thispage", defaultValue = "1") String thispage) {

		List<Matchs> mlist = matchsService.findAll(thispage);
		PageInfo<Matchs> pageInfo = new PageInfo<Matchs>(mlist);
		Long count = pageInfo.getTotal();
		page page = new page(Integer.parseInt(thispage), Integer.valueOf(count
				.toString()));
		model.addAttribute("mlist", mlist);
		model.addAttribute("page", page);
		return "/matchs/matchslist";
	}

	@RequestMapping("/toQuery")
	public String toQuery(Model model) {
		List<Province> plist = getProvinceCityAreaService.getProvince();
		model.addAttribute("plist", plist);
		return "/matchs/query";
	}

	@RequestMapping("/query")
	public String query(
			Model model,
			Matchs matchs,
			@RequestParam(required = false, value = "thispage", defaultValue = "1") String thispage) {

		List<Matchs> mlist = matchsService.query(matchs, thispage);
		PageInfo<Matchs> pageInfo = new PageInfo<Matchs>(mlist);
		Long count = pageInfo.getTotal();
		page page = new page(Integer.parseInt(thispage), Integer.valueOf(count
				.toString()));
		model.addAttribute("mlist", mlist);
		model.addAttribute("page", page);
		model.addAttribute(matchs);
		return "/matchs/matchslist";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) {

		matchsService.delete(id);
		return "redirect:findAll.do";
	}

	/*@RequestMapping("/check")
	public String check(Integer id, Model model) {
		
		
		Matchs matchs = matchsService.check(id);
		model.addAttribute(matchs);
		return "/matchs/check";
	}*/
	//查看页面
	@RequestMapping("/checks")
	public ModelAndView check(Integer id, Integer status,HttpServletRequest request) {
		
		Matchs matchs = matchsService.check(id);
		ModelAndView modelAndView = new ModelAndView();
		//未购买 显示余额
		if(status==2){
			Account account = deductMoneyservice.getAccount(request);
			float balance = account.getBalance();
			modelAndView.addObject("balance",balance);
		}
		modelAndView.addObject("matchs",matchs);
		modelAndView.addObject("status", status);
		modelAndView.setViewName("/matchs/check");
		return modelAndView;
	}
	
	//购买支付
	@RequestMapping("/watch")
	public void watch(Integer id, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		Matchs matchs = matchsService.check(id);
		Account account = deductMoneyservice.getAccount(request);
		float balance = account.getBalance();
		if(balance-50>0){
			balance= balance-50;
			//购买成功,同时生成一个支付订单和一个消费记录、更新状态值state为1 (1为已购买 2为未购买)
			deductMoneyservice.deductMoney(balance, account.getId());
			//生成一个支付订单
			uorderService.insertOrder(id, 50, "项目信息", request);
			//一个消费记录
			bookedService.add(matchs.getProjectName(),account.getId(), 2, 50f, balance);
			//更新状态值为 1
			matchsService.edit(matchs);
			JSONArray jsonArray = new JSONArray();
			jsonArray.add(matchs.getProjectUnit());
			jsonArray.add(matchs.getAddress());
			jsonArray.add(matchs.getLinkman());
			jsonArray.add(matchs.getPhone());
			jsonArray.add(matchs.getEmail());
			jsonArray.add(matchs.getFaxNumber());
			response.getWriter().write((jsonArray.toString()));
		}else{
			response.getWriter().write(1);
		}

	}
	
	//跳转编辑页面
	@RequestMapping("toedit")
	public String toEdit(Integer id, Model model) {

		Matchs matchs = matchsService.check(id);
		List<Province> plist = getProvinceCityAreaService.getProvince();
		model.addAttribute("plist", plist);//省份
		Map<String,List<String>> map = getType();
		model.addAttribute("map", map);
		model.addAttribute("matchs",matchs);
		return "/matchs/toedit";
	}

	@RequestMapping("/edit")
	public String edit(Matchs matchs,String issuetime) throws ParseException {
		Calendar time = Calendar.getInstance();
		time.get(Calendar.HOUR_OF_DAY);//获取小时
		time.get(Calendar.MINUTE);//获取分钟
		time.get(Calendar.SECOND);//获取秒
		System.out.println(time.get(Calendar.HOUR_OF_DAY)+":"+time.get(Calendar.MINUTE)+":"+time.get(Calendar.SECOND));
		issuetime = issuetime+" "+time.get(Calendar.HOUR_OF_DAY)+":"+time.get(Calendar.MINUTE)+":"+time.get(Calendar.SECOND);
		System.out.println(issuetime);
		matchs.setIssueTime(Timestamp.valueOf(issuetime));
		matchsService.update(matchs);
		return "redirect:findAll.do";
	}

	@RequestMapping("/export")
	public void exportFile(String ids, HttpServletResponse response) {

		matchsService.exportFile(ids, response);

	}
	
	public Map<String,List<String>> getType(){
		List<String> list=new ArrayList<String>();
		list.add("休闲娱乐");list.add("其他行业");list.add("产业园区");list.add("园林园艺");list.add("PPP项目");list.add("工艺收藏");
		list.add("加工制造");list.add("基础设施");list.add("装备制造");list.add("仓储物流");list.add("现代服务");list.add("供水供气");
		list.add("公路桥梁");list.add("印刷包装");list.add("电子器件");list.add("生物制药");list.add("船舶制造");list.add("钢铁行业");
		list.add("家具装饰");list.add("机械机电");list.add("电器家电");list.add("通信传媒");list.add("能源电力");list.add("水泥行业");
		list.add("物资外贸");list.add("纺织服装");list.add("商业百货");list.add("农药化肥");list.add("医疗器械");list.add("食品行业");
		list.add("轻工化纤");list.add("交通运输");list.add("汽车汽配");list.add("农林牧渔");list.add("建筑建材");list.add("石油化工");
		list.add("环保绿化");list.add("文化教育");list.add("IT互联网");list.add("矿产冶金");list.add("旅游酒店");list.add("房地产业");
		list.add("高新科技");list.add("金融投资");
		Map<String,List<String>> map=new HashMap<>();
		map.put("type", list);
		return map;
	}
}
