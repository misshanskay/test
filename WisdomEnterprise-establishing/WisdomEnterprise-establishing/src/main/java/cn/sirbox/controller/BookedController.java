package cn.sirbox.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;








import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import cn.sirbox.model.Booked;
import cn.sirbox.model.BookedQueryVo;
import cn.sirbox.model.Enterprise;
import cn.sirbox.model.UserU;
import cn.sirbox.model.page;
import cn.sirbox.service.BookedService;
import cn.sirbox.service.impl.EnterpriseService;
import cn.sirbox.service.impl.UserUService;
@RequestMapping("/booked")
@Controller
public class BookedController {
	
	@Autowired
	private BookedService bookedService;
	
	@Autowired
	private UserUService userUService;
	
	@Autowired
	private EnterpriseService enterpriseService;
	
	//入账列表
	@RequestMapping("/findAll")
	public String findAll(Model model,@RequestParam(required=false, value="thispage",defaultValue="1")String thispage){
				
		List<Booked> blist = bookedService.findAll(thispage);
		PageInfo<Booked> pageInfo = new PageInfo<Booked>(blist);
		Long count = pageInfo.getTotal();
		model.addAttribute("blist",blist);
		page page =  new page(Integer.parseInt(thispage),Integer.valueOf(count.toString()));
		model.addAttribute("page",page);
		return "/booked/bookedlist";
	}
	
	//消费列表
	@RequestMapping("/expense")
	public String findExpense(Model model,@RequestParam(required=false, value="thispage",defaultValue="1")String thispage){
				
		List<Booked> blist = bookedService.findAll(thispage);
		PageInfo<Booked> pageInfo = new PageInfo<Booked>(blist);
		Long count = pageInfo.getTotal();
		model.addAttribute("blist",blist);
		page page =  new page(Integer.parseInt(thispage),Integer.valueOf(count.toString()));
		model.addAttribute("page",page);
		return "/booked/expenselist";
	}
	
	@RequestMapping("/export")
	public String exportFile(String ids,HttpServletResponse response){
		
		bookedService.exportFile(ids,response);
		return "Redirect:findall.do";
	}
	
	//入账扣款
	@RequestMapping("/reduce")
	public void reduce(String userName ,Booked booked,HttpServletResponse response) throws UnsupportedEncodingException{
		// 1：入账成功   2：扣款成功   0:入款失败或扣款失败
		int num = 0;
		UserU userU = userUService.getUserUByName(userName);
		if(userU!=null){
			num = bookedService.addOrReduce(userU.getUname(),booked);
		}else{
			Enterprise enterprise = enterpriseService.getEnterpriseByUname(userName);
			num = bookedService.addOrReduce(enterprise.getEname(),booked);
		}
			try {			
				response.getWriter().print(num);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	//跳转入账扣款页面
	@RequestMapping("/toreduce")
	public String toReduce(){
		
		return "/booked/reduce";
	}
	
	//跳转会员查询页面
	@RequestMapping("/toquery")
	public String toQuery(){
		
		return "/booked/query";
	}
	
	//会员查询结果
	@RequestMapping("/query")
	public String expense(Model model,BookedQueryVo bookedQueryVo,@RequestParam(defaultValue = "1", value="thispage",required=false) String thispage){
		
		List<Booked> blist = bookedService.expense(thispage,bookedQueryVo);
		PageInfo<Booked> pageInfo = new PageInfo<Booked>(blist);
		Long count = pageInfo.getTotal();
		page page = new page(Integer.parseInt(thispage),Integer.valueOf(count.toString()));
		model.addAttribute("page",page);
		model.addAttribute("blist",blist);
		return "/booked/expenselist";
	}
	
	@RequestMapping("/find")
	public String find(
			@RequestParam(required=false,value="username")String username,
			@RequestParam(required=false,value="createtimeone")String startTime,
			@RequestParam(required=false,value="createtimetwo")String endTime,
			@RequestParam(required=false,value="way")String way){
		Map<String, Object> map = bookedService.find(username,startTime,endTime,way);
		return "";
	}
	
	//查询订单号是否存在 存在返回 1 不存在 返回 0 
	@RequestMapping(value="/checknum",method=RequestMethod.POST)
	public void checkNumber(String number,HttpServletResponse response){
		
		int num = bookedService.checkNumber(number);
		try {
			response.getWriter().write(num);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//跳转充值订单管理页面
	@RequestMapping("/topm")
	public ModelAndView payManage(
			@RequestParam(required=false,value="thispage",defaultValue="1")String thispage){
		
		ModelAndView modelAndView = new ModelAndView();
		List<Booked> plist = bookedService.getPayManage(thispage);
		PageInfo<Booked> pageInfo  = new PageInfo<Booked>(plist);
		Long count = pageInfo.getTotal();
		modelAndView.addObject("plist", plist);
		page page =  new page(Integer.parseInt(thispage),Integer.valueOf(count.toString()));
		modelAndView.addObject("page", page);
		modelAndView.addObject("flag", 1);
		modelAndView.setViewName("/booked/paymanagelist");
		return modelAndView;
	}
	
	//手工处理
	@RequestMapping("/update")
	public ModelAndView update(Booked booked,String userName){
		
		ModelAndView mAndView = new ModelAndView();
		UserU userU = userUService.getUserUByName(userName);
		if(userU!=null){
			bookedService.update(booked,userU.getUname());
		}else{
			Enterprise enterprise = enterpriseService.getEnterpriseByUname(userName);
			bookedService.update(booked,enterprise.getEname());
		}
		mAndView.setViewName("redirect:topm.do");
		return mAndView;
	}
	
	//财务查询
	@RequestMapping("/fquery")
	public ModelAndView financeQuery(
			@RequestParam(required=false,value="thispage",defaultValue="1")String thispage,
			@RequestParam(required=false,value="username")String username,
			@RequestParam(required=false,value="startTime")String startTime,
			@RequestParam(required=false,value="endTime")String endTime,
			@RequestParam(required=false,value="supplier")String supplier,
			@RequestParam(required=false,value="orderNumber")String orderNumber){
		Map<String, Object> map = new HashMap<String, Object>(); 
		map.put("username", username);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		map.put("supplier", supplier);
		map.put("orderNumber", orderNumber);
		ModelAndView modelAndView = new ModelAndView();
		UserU userU = userUService.getUserUByName(username);
		List<Booked> plist = null;
		if(userU!=null){
			plist = bookedService.financeQuery(thispage, username,startTime,endTime,supplier,orderNumber);
		}else{
			Enterprise enterprise = enterpriseService.getEnterpriseByUname(username);
			username = enterprise.getEname();
			 plist = bookedService.financeQuery(thispage, username,startTime,endTime,supplier,orderNumber);
		}
		PageInfo<Booked> pageInfo  = new PageInfo<Booked>(plist);
		Long count = pageInfo.getTotal();
		modelAndView.addObject("plist", plist);
		modelAndView.addObject("map", map);
		page page =  new page(Integer.parseInt(thispage),Integer.valueOf(count.toString()));
		modelAndView.addObject("page", page);
		modelAndView.setViewName("/booked/paymanagelist");
		return modelAndView;
	}
}
