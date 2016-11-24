package cn.sirbox.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sirbox.model.Uorder;
import cn.sirbox.model.UserU;
import cn.sirbox.service.impl.MatchsServiceImpl;
import cn.sirbox.service.impl.UorderService;
import cn.sirbox.service.impl.UserUService;
import cn.sirbox.utils.config;

@Controller
@RequestMapping("order")
public class UorderController {
    @Autowired
    private UorderService uorderService;
    
    
    @Autowired
    private UserUService userUService;
    
    
    
    
   
  //查询所有订单
    @RequestMapping("list")
    public String list(Integer thispage,HttpServletRequest request,Model model){
        if(thispage==null){
            thispage=1;
        }
        Integer pagenumber=Integer.parseInt(config.getKeyValue("pagenumber"));
        List<Uorder> list=uorderService.selectAllOrder(thispage,pagenumber);
        for(int i=0;i<list.size();i++){
            list.get(i).setUname(userUService.getUserUById1(list.get(i).getUid()).getUname());
        }
        PageInfo<Uorder> page=new PageInfo<Uorder>(list);
       
        model.addAttribute("sta", 0);
        model.addAttribute("page", page);
        
        return "orderlist";
    }
  //查询未付款订单
    @RequestMapping("list1")
    public String list1(Integer thispage,HttpServletRequest request,Model model){
        if(thispage==null){
            thispage=1;
        }
        Integer pagenumber=Integer.parseInt(config.getKeyValue( "pagenumber"));
        List<Uorder> list=uorderService.selectAllOrder1(thispage,pagenumber);
        for(int i=0;i<list.size();i++){
            list.get(i).setUname(userUService.getUserUById1(list.get(i).getUid()).getUname());
        }
        PageInfo<Uorder> page=new PageInfo<Uorder>(list);
       
        model.addAttribute("sta", 1);
        model.addAttribute("page", page);
        
        return "orderlist";
    }
  //查询今日订单
    @RequestMapping("list2")
    public String list2(Integer thispage,HttpServletRequest request,Model model){
        if(thispage==null){
            thispage=1;
        }
        Integer pagenumber=Integer.parseInt(config.getKeyValue("pagenumber"));
        List<Uorder> list=uorderService.selectAllOrder2(thispage,pagenumber);
        for(int i=0;i<list.size();i++){
            list.get(i).setUname(userUService.getUserUById1(list.get(i).getUid()).getUname());
        }
        PageInfo<Uorder> page=new PageInfo<Uorder>(list);
       
        model.addAttribute("sta", 2);
        model.addAttribute("page", page);
        
        return "orderlist";
    }
    @RequestMapping("seach")
    public String seach(Integer thispage,HttpServletRequest request,Model model,Uorder uorder,Integer money1,Integer money2){
        
        return "orderseach";
    }
    
    @RequestMapping("seachorder")
    public String seachorder(Integer thispage,HttpServletRequest request,Model model,Uorder uorder,Integer money1,Integer money2){
        
        if(thispage==null){
            thispage=1;
        }
        List<Integer> list1=new ArrayList<Integer>();
        if(uorder.getUname()!=null&&!"".equals(uorder.getUname())){
            UserU user=new UserU();
            user.setUname(uorder.getUname());
            List<UserU> list=userUService.getAllUserUname1(user);
             list1= new ArrayList<>();
            for(int i=0;i<list.size();i++){
                list1.add(list.get(i).getUid());
            }
        }
       
        PageHelper.startPage(thispage,Integer.parseInt(config.getKeyValue("pagenumber")));
        List<Uorder> list3=uorderService.seachorder(uorder,money1,money2,list1);
        for(int i=0;i<list3.size();i++){
            list3.get(i).setUname(userUService.getUserUById1(list3.get(i).getUid()).getUname());
        }
        PageInfo<Uorder> page=new PageInfo<Uorder>(list3);
        model.addAttribute("uorder", uorder);
        model.addAttribute("money1", money1);
        model.addAttribute("money2", money2);
        model.addAttribute("page", page);
        model.addAttribute("sta", 3);
        return "orderlist";
    }
    
}
