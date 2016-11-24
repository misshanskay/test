package cn.sirbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sirbox.model.Part;
import cn.sirbox.service.impl.PartService;

@Controller
@RequestMapping("/part")
public class PartController {
	@Autowired
	private PartService partService;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Part> list=partService.getAllPart();
		model.addAttribute("list", list);
		return "partlist";
		
	}
	@RequestMapping("/addpart")
	public String addpart(){
		return "addpart";
	}
	
	/*@RequestMapping("/updata")
	public String updata(Integer pid,Model model){
		Part part=partService.getPartById(pid);
		List<String> list=partService.getRole(part.getPname());
		model.addAttribute("part", part);
		model.addAttribute("list", list);
		return "updatapart";
	}*/
	
	/*@RequestMapping("/updatap")
	public String updatap(Part part ,String[] power,Model model){
		partService.updataPart(part);
		partService.deleteRole(part.getPname());
		for(int i=0;i<power.length;i++){
			partService.addPartRole(part.getPname(),power[i]);
		}
		
		
		List<Part> list=partService.getAllPart();
		model.addAttribute("list", list);
		return "partlist";
	}*/
	
	/*@RequestMapping("/addp")
	public String addp(Part part ,String[] power,Model model){
		partService.addPart(part);
		
		for(int i=0;i<power.length;i++){
			partService.addPartRole(part.getPname(),power[i]);
		}
		
		
		List<Part> list=partService.getAllPart();
		model.addAttribute("list", list);
		return "partlist";
	}*/
	
	/*@RequestMapping("/aj")
	@ResponseBody
	public String aj(String pname){
		Part part=partService.getPartByName(pname);
		if(part==null){
			return "success";
		}
		return "角色已存在";
	}*/
	
	/*@RequestMapping("/aj1")
	@ResponseBody
	public String aj1(Integer pid){
		Part part=partService.getPartById(pid);
		if(part==null){
			return "success";
		}
		return "编号已存在";
	}*/
	
	
	/*@RequestMapping("/rack")
	public String rack(Model model){
		List<Part> list=partService.getAllPart();
		model.addAttribute("list", list);
		return "partlist";
	}*/
}
