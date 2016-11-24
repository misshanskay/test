package cn.sirbox.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sirbox.model.Dept;
import cn.sirbox.model.UserU;
import cn.sirbox.service.impl.DeptService;
import cn.sirbox.service.impl.UserUService;



@Controller
@RequestMapping("/index")
public class IndexController {
	
	private static Logger logger = LogManager.getLogger(IndexController.class.getName());
	@Autowired  
	private HttpSession session;
	@Autowired  
	private HttpServletRequest request; 

	@Autowired
	private UserUService userUService;
	@Autowired
	private DeptService deptService;
	/*@RequestMapping("/login")
	public String login(Model model) {
		
		//List<UserU> useru=userUService.getAllUserU();
		List<Dept> dept=deptService.getAllDept();
		StringBuffer sn=new StringBuffer();
		sn.append("[");
		//sn=hhh(sn,useru,dept,0);
		sn.deleteCharAt(sn.length()-1);
		sn.append("]");
		String ss=sn.toString();
		model.addAttribute("ztreeno",ss);
		System.out.println(ss);
		return "ztree";
	}*/
	@RequestMapping("/main")
	public String main() {
		return "register";
	}
	/*@RequestMapping("/aj")
	@ResponseBody
	public String aj(Integer uid,Integer did) {
		int uu=-uid;
		userUService.updateDeptById(uu,did);
		return "success";
	}
	@RequestMapping("/dept")
	@ResponseBody
	public String dept(Integer did,Integer pid) {
		deptService.updateDeptById(did,pid);
		return "success";
	}*/
	
	public StringBuffer hhh(StringBuffer sn,List<UserU> useru,List<Dept> dept,Integer i){
		/*for(Dept d:dept){
			if(d.getPid()==i){
				sn.append("{");
				sn.append("id:"+d.getDid());
				sn.append(",pId:"+d.getPid());
				sn.append(",name:'"+d.getDname());
				
				sn.append("'},");
				sn=hhh(sn,useru,dept,d.getDid());
				
			
		}
		
		}
		for(UserU u:useru){
			if(u.getDid()==i){
				sn.append("{");
				sn.append("id:-"+u.getUid());
				sn.append(",pId:"+i);
				sn.append(",name:'"+u.getUname());
				sn.append("'},");
			}
	}*/
		return sn;
	}

}
