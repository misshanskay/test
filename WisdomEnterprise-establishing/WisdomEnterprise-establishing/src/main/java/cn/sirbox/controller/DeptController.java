package cn.sirbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sirbox.model.Dept;
import cn.sirbox.model.Result;
import cn.sirbox.service.impl.DeptService;
import cn.sirbox.service.impl.UserUService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	    @Autowired
	    private UserUService userUService;

	    @Autowired
	    private DeptService deptService;
	    
	    
	    @RequestMapping("/movedept")
		@ResponseBody
		public String movedept(Integer did,Integer pid) {
			deptService.updateDeptById(did,pid);
			return "success";
		}
	    
	    @RequestMapping("/removedept")
		@ResponseBody
		public String removedept(Integer did) {
			deptService.deleteDeptById(did);
			return "success";
		}
	    
	    @RequestMapping("/adddept")
		@ResponseBody
		public Result adddept(Integer pid) {
			Result result=new Result();
			Dept dept=new Dept();
			dept.setPid(pid);
			dept.setDname("新建部门");
			int i=deptService.addDeptGov(dept);
			result.setStatus(200);
			result.setData(i);
			return result;
		}
	    
	    
	    @RequestMapping("/updatedept")
		@ResponseBody
		public String updatedept(Dept dept) {
			
			deptService.updateDept(dept);
			return "success";
		}
}
