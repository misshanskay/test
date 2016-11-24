package cn.sirbox.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.sirbox.model.Enterprise;
import cn.sirbox.model.Logger;
import cn.sirbox.model.UserU;
import cn.sirbox.service.impl.LoggerService;
import cn.sirbox.service.impl.UserUService;
import cn.sirbox.utils.ExcelUtil;
import cn.sirbox.utils.config;
import cn.sirbox.utils.utils;

@Controller
@RequestMapping("logger")
public class LoggerController {
    @Autowired
    private LoggerService loggerService;
    
    @Autowired
    private UserUService userUService;
    
    @RequestMapping("list")
    public String list(Integer thispage,HttpServletRequest request,Model model){
        
        if(thispage==null||"".equals(thispage)){
            thispage=1;
        }
        Integer pagenumber=Integer.parseInt(config.getKeyValue("pagenumber"));
        List<Logger> list=loggerService.selectAllLogger(thispage,pagenumber);
        for(int i=0;i<list.size();i++){
            list.get(i).setUname(userUService.getUserUById1(list.get(i).getUid()).getUname());
        }
        PageInfo<Logger> page=new PageInfo<>(list);
        
        model.addAttribute("page", page);
        model.addAttribute("list", list);
        model.addAttribute("sta", 24);
        return "loggerlist";
    }
    
    @RequestMapping("alllist")
    public String alllist(Integer thispage,HttpServletRequest request,Model model){
        if(thispage==null&&"".equals(thispage)){
            thispage=1;
        }
        Integer pagenumber=Integer.parseInt(config.getKeyValue( "pagenumber"));
        List<Logger> list=loggerService.selectAllLogger1(thispage,pagenumber);
        for(int i=0;i<list.size();i++){
            list.get(i).setUname(userUService.getUserUById1(list.get(i).getUid()).getUname());
        }
        PageInfo<Logger> page=new PageInfo<>(list);
        model.addAttribute("page", page);
        model.addAttribute("list", list);
        model.addAttribute("sta", 0);
        return "loggerlist";
    }
    
    @RequestMapping("alllist1")
    public String alllist1(Integer thispage,HttpServletRequest request,Model model){
        if(thispage==null&&"".equals(thispage)){
            thispage=1;
        }
        Integer pagenumber=Integer.parseInt(config.getKeyValue( "pagenumber"));
        List<Logger> list=loggerService.selectAllLogger2(thispage,pagenumber);
        for(int i=0;i<list.size();i++){
            list.get(i).setUname(userUService.getUserUById1(list.get(i).getUid()).getUname());
        }
        PageInfo<Logger> page=new PageInfo<>(list);
        model.addAttribute("page", page);
        model.addAttribute("list", list);
        model.addAttribute("sta", 7);
        return "loggerlist";
    }
    
    @RequestMapping("alllist2")
    public String alllist2(Integer thispage,HttpServletRequest request,Model model){
        if(thispage==null&&"".equals(thispage)){
            thispage=1;
        }
        Integer pagenumber=Integer.parseInt(config.getKeyValue( "pagenumber"));
        List<Logger> list=loggerService.selectAllLogger3(thispage,pagenumber);
        for(int i=0;i<list.size();i++){
            list.get(i).setUname(userUService.getUserUById1(list.get(i).getUid()).getUname());
        }
        PageInfo<Logger> page=new PageInfo<>(list);
        model.addAttribute("page", page);
        model.addAttribute("list", list);
        model.addAttribute("sta", 30);
        return "loggerlist";
    }
    
    @RequestMapping("seach")
    public String seach(HttpServletRequest request,Model model,Logger logger,String operator,
            String time1,String time2,Integer thispage) throws ParseException{
        model.addAttribute("logger", logger);
        model.addAttribute("operator", operator);
        model.addAttribute("time1", time1);
        model.addAttribute("time2", time2);
        Integer pagenumber=Integer.parseInt(config.getKeyValue( "pagenumber"));
        List<UserU> list=new ArrayList<>();
        UserU user=new UserU();
        user.setUname(logger.getUname());
        if("所有".equals(operator)){
            if(logger.getUname()!=null&&!"".equals(logger.getUname())){
                user.setUname(logger.getUname());
            }
            list=userUService.getAllUserUname(user);
        }else if("政府端".equals(operator)){
            user.setStatus("government");
            if(logger.getUname()!=null&&!"".equals(logger.getUname())){
                user.setUname(logger.getUname());
            }
            list=userUService.getAllUserUname(user);
        }else if("企业端".equals(operator)){
            user.setStatus("enterprise");
            list=userUService.getAllUserUname(user);
        }
        List<Integer> list1= new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list1.add(list.get(i).getUid());
        }
        PageHelper.startPage(thispage,pagenumber);
        List<Logger> list2=loggerService.seachLogger(logger,time1,time2,list1);
        for(int i=0;i<list2.size();i++){
            list2.get(i).setUname(userUService.getUserUById1(list2.get(i).getUid()).getUname());
        }
        
        PageInfo<Logger> page=new PageInfo<Logger>(list2);
        model.addAttribute("page", page);
        model.addAttribute("list", list2);
        model.addAttribute("sta", 100);
        return "loggerlist";
        
    }
    
    
    @RequestMapping("download")
    @ResponseBody
    public String download(Integer status,HttpServletRequest request,Model model,HttpServletResponse response) throws IOException{
        List<Logger> list1=new ArrayList<>();
        if(status==0){
           list1=loggerService.selectAllLogger1(0,0);
        }else if(status==24){
           list1=loggerService.selectAllLogger(0,0);
            
        }else if(status==7){
            list1=loggerService.selectAllLogger2(0,0);
            
        }else{
            list1=loggerService.selectAllLogger3(0,0);
            
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            List<Map<String,String>> list=getLogger(list1);
            ExcelUtil.createWorkBook(request,list).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(("日志" + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }

    private List<Map<String, String>> getLogger(List<Logger> list1) {
        // TODO Auto-generated method stub
        List<Map<String,String>> list=new ArrayList<>();
       
        for(int i=0;i<list1.size();i++){
            Map<String,String> map=new LinkedHashMap<String, String>();
            map.put("会员名", userUService.getUserUById1(list1.get(i).getUid()).getUname());
            map.put("操作类型", list1.get(i).getType());
            map.put("时间", list1.get(i).getTime()+"");
            map.put("IP地址", list1.get(i).getIp());
            if(list1.get(i).getResult()==0){
                
                map.put("结果", "失败");
            }else{
                map.put("结果", "成功");
                
            }
            map.put("备注", list1.get(i).getRemark());
            list.add(map);
        }
        return list;
    }
    
}
