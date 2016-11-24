package cn.sirbox.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import cn.sirbox.model.Notice;
import cn.sirbox.model.page;
import cn.sirbox.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//查询所有
	@RequestMapping("/findAll")
	public String findAll(Model model,@RequestParam(required=false,value="thispage", defaultValue="1" )String thispage) throws Exception{
		
		List<Notice> nlist = noticeService.findAll(thispage);
		PageInfo<Notice> pageInfo = new PageInfo<Notice>(nlist);
		Long count = pageInfo.getTotal();
		page page = new page(Integer.parseInt(thispage),Integer.valueOf(count.toString()));
		model.addAttribute("nlist", nlist);
		model.addAttribute("page", page);
		return "/notice/noticelist";
	}
	
	//跳转新增公告页面
	@RequestMapping("/toAdd")
	public String toAdd(){
		
		return "/notice/addnotice";	
	}
	
	//新增公告
	@RequestMapping("/add")
	public String addNotice(Notice notice,HttpServletRequest request) throws Exception{
		
		noticeService.add(notice,request);
		return "redirect:findAll.do";	
	}
	
	//根据id删除公告
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		
		noticeService.delete(id);
		return "redirect:findAll.do";
	}
	
	//跳转跟新公告页面
	@RequestMapping("/toupdate")
	public String toUpte(Integer id,Model model) throws Exception{
		
		Notice notice = noticeService.findById(id);
		Notice notices = noticeService.findMaxOrderNum();
		model.addAttribute(notice);
		model.addAttribute("orderNumMax",notices.getOrderNum());
		return "/notice/updatenotice";
	}
	
	//更新公告
	@RequestMapping("/update")
	public String update(Notice notice) throws Exception{
		
		noticeService.update(notice);
		return "redirect:findAll.do";
	}
	
	//根据条件查询公告
	@RequestMapping("/select")
	public String findByCondition(Model model,Notice notice,@RequestParam(required=false,value="thispage",defaultValue="1")String thispage) throws Exception{
		
		List<Notice> nlist = noticeService.findByCondition(notice,thispage);
		PageInfo<Notice> pageInfo = new PageInfo<Notice>(nlist);
		Long count = pageInfo.getTotal();
		page page = new page(Integer.parseInt(thispage),Integer.valueOf(count.toString()));
		model.addAttribute("nlist", nlist);
		model.addAttribute("page", page);
		return "/notice/noticelist";
	}
	
	//根据id查询
	@RequestMapping("/check")
	public String findByid(Integer id){
		
		return "/notice/checknotice";
	}
	
}
