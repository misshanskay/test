package cn.sirbox.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import cn.sirbox.model.Province;
import cn.sirbox.model.Releaseinfo;
import cn.sirbox.model.UserU;
import cn.sirbox.model.page;
import cn.sirbox.service.ReleaseinfoService;

@Controller
@RequestMapping("/releaseinfo")
public class ReleaseinfoController {

	@Autowired
	private ReleaseinfoService releaseinfoService;

	// 查询所有发布信息
	@RequestMapping("/findAll")
	public String editAllReleaseinfo(Model model,@RequestParam(required=false,value="thispage",defaultValue="1")String thispage,@RequestParam(required=false)String projectBusiness) throws Exception {

		List<Releaseinfo> riList = releaseinfoService.findAll(thispage);
		PageInfo<Releaseinfo> pageInfo = new PageInfo<Releaseinfo>(riList);
		Long count = pageInfo.getTotal();
		page page = new page(Integer.parseInt(thispage),Integer.valueOf(count.toString()));
		model.addAttribute("page",page);
		model.addAttribute("riList", riList);
		 Map<String,List<String>> map1=getType();
		 model.addAttribute("map1", map1);
		return "releaseinfo/releaseinfolist";
	}

	// 跳转添加页面
	@RequestMapping("/toAdd")
	public String toAddReleaseinfo(Model model) {
		model.addAttribute(new Releaseinfo());
		List<Province> plist = releaseinfoService.getProvince();
		model.addAttribute("plist",plist);
		return "releaseinfo/addreleaseinfo";
	}

	// 添加信息
	@RequestMapping("/add")
	public String addReleaseinfo(Releaseinfo releaseinfo,HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		UserU userU = (UserU)session.getAttribute("userU");
		releaseinfo.setIssuer(userU.getUname());
		releaseinfoService.add(releaseinfo);
		return "redirect:findAll.do";
	}

	
	// 跳转更新页面
	@RequestMapping("/toUpdate")
	public String updateReleaseinfo(Integer id, Model model) throws Exception {

		Releaseinfo releaseinfo = releaseinfoService.findById(id);
		List<Province> plist = releaseinfoService.getProvince();
		model.addAttribute("plist",plist);
		model.addAttribute(releaseinfo);
		return "releaseinfo/updatereleaseinfo";
	}

	// 更新信息
	@RequestMapping("/update")
	public String updateReleaseinfo(Releaseinfo releaseinfo) throws Exception {

		releaseinfoService.update(releaseinfo);
		return "redirect:findAll.do";
	}
	
	// 删除信息
	@RequestMapping("/delete")
	public String deleteReleaseinfo(Integer id) throws Exception {

		releaseinfoService.delete(id);
		return "redirect:findAll.do";
	}

	// 查看单个发布信息
	@RequestMapping("/check")
	public String findById(Integer id, Model model) throws Exception {

		Releaseinfo releaseinfo = releaseinfoService.findById(id);
		model.addAttribute(releaseinfo);
		return "releaseinfo/checkreleaseinfo";
	}

	// 批量审批通过
	@RequestMapping("/edits")
	public String updateReleaseinfos(Integer[] id,String str) throws Exception {

		releaseinfoService.update(id,str);
		return "redirect:findAll.do";
	}

	//跳转审批页面
	@RequestMapping("/shenhe")
	public String toUpdate(Integer id, Model model) throws Exception {

		Releaseinfo releaseinfo = releaseinfoService.findById(id);
		model.addAttribute(releaseinfo);
		return "releaseinfo/shenpireleaseinfo";

	}
/*
	// 根据审核状态查询发布信息
	@RequestMapping("/edit")
	public String editReleaseinfo(Integer state,Model model) throws Exception {
		
		List<Releaseinfo> riList = releaseinfoService.findByState(state);
		model.addAttribute("riList", riList);
		return "releaseinfo/releaseinfolist";
	}
	
	//根据行业查询发布信息
	@RequestMapping("/findByIB")
	public String editReleaseinfo(String itemBusiness , Model model) throws Exception{
		
		List<Releaseinfo> riList = releaseinfoService.findByName(itemBusiness);
		model.addAttribute("riList", riList);
		return "releaseinfo/releaseinfolist";
		
	}*/
	
	//根据行业、发布者查询、按照时间、按照、项目类型、状态排序
	@RequestMapping("/selectByCondition")
	public ModelAndView selectByCondition(
			@RequestParam(defaultValue="1",value="thispage")String thispage,
			@RequestParam(required=false,value="projectBusiness") String projectBusiness,
			@RequestParam(required=false,value="issuer") String issuer,
			@RequestParam(required=false, value="createTime")String createTime, 
			@RequestParam(required=false ,value="projectType") String projectType,
			@RequestParam(required=false, value="state") String state
			){
		ModelAndView modelAndView = new ModelAndView();
		List<Releaseinfo> riList = 
				releaseinfoService.selectByCondition(thispage,projectBusiness,issuer,createTime,projectType,state);
		PageInfo<Releaseinfo> pageInfo = new PageInfo<Releaseinfo>(riList);
		Long count = pageInfo.getTotal();
		page page = new page(Integer.parseInt(thispage),Integer.valueOf(count.toString()));
		modelAndView.addObject("page",page);
		modelAndView.addObject("riList", riList);
		Map<String,List<String>> map1=getType();
		modelAndView.addObject("map1", map1);
		modelAndView.setViewName("releaseinfo/releaseinfolist");
		return modelAndView;
		
		
	}
	//下载招商信息
    @RequestMapping("/export")
    public void exportFile(String ids, HttpServletResponse response) throws Exception {
    	
    	releaseinfoService.exportFile(ids, response);
    	
    	//return "redirect:editAll.do";
    }
	
    //付款
	@RequestMapping("/pay")
	public void pay(HttpServletRequest request, HttpServletResponse response){
		
		try {
			response.getWriter().print(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
/*	@RequestMapping("/querycity")
	public void queryCity(String provincecode,HttpServletResponse response) throws IOException{
		
		List<City> clist = releaseinfoService.getCity(provincecode);
		response.getWriter().print(JSONArray.fromObject(clist).toString());
	}
	*/
	//查询验证码
	@RequestMapping("/code")
	public void verification(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		Integer code = releaseinfoService.verification(request);
		response.getWriter().print(code);
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
