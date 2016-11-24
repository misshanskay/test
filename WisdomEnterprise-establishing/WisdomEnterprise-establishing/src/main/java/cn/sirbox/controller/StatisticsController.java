package cn.sirbox.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sirbox.model.Result;
import cn.sirbox.service.BookedService;
import cn.sirbox.service.impl.EnterpriseService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("statistics")
public class StatisticsController {
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private BookedService bookedService;
    
    @RequestMapping("user")
    public String user(Model model,String time1,String time2){
        Integer year=0;
        Integer month=0;
        Integer month1=0;
       
        Date date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        List<String> list=new ArrayList<>();
        if(time1==null||"".equals(time1)){
            year=gc.get(gc.YEAR);
            month=gc.get(gc.MONTH)+1;
            list.add(year+"年");
        }else{
            String[] str1 = time1.split("-");
            
            if(time2==null||"".equals(time2)){
                year=Integer.parseInt(str1[0]);
                month1=Integer.parseInt(str1[1])-1;
                month=gc.get(gc.MONTH)+1+(gc.get(gc.YEAR)-year)*12-month1;
                if(year==gc.get(gc.YEAR)){
                    
                    list.add(year+"年");
                }else{
                    
                    list.add(year+"年到"+gc.get(gc.YEAR)+"年");
                }
            }else{
                String[] str2 = time2.split("-");
                year=Integer.parseInt(str1[0]);
                month1=Integer.parseInt(str1[1])-1;
                month=Integer.parseInt(str2[1])+(Integer.parseInt(str2[0])-year)*12-month1;
                if(year==Integer.parseInt(str2[0])){
                    
                    list.add(year+"年");
                }else{
                    
                    list.add(year+"年到"+Integer.parseInt(str2[0])+"年");
                }
            }
            
        }
        
        
        
        
        StringBuffer s=new StringBuffer();
        s.append("[");
        for(int i=month1;i<month+month1;i++){
            list.add((i%12+1)+"月");
            s.append("\'"+(i%12+1)+"月\',");
        }
        s.deleteCharAt(s.length()-1);
        s.append("]");
        model.addAttribute("list", list);
        List<String> list1=new ArrayList<>();
        list1=enterpriseService.getCountInsert1(year,month,month1);
        StringBuffer s1=listtostring(list1);
        model.addAttribute("s1", s1);
        model.addAttribute("list1", list1);
        
        List<String> list2=new ArrayList<>();
        list2=enterpriseService.getCountInsert2(year,month,month1);
        StringBuffer s2=listtostring(list2);
        model.addAttribute("s2", s2);
        model.addAttribute("list2", list2);
        
        List<String> list3=new ArrayList<>();
        list3=enterpriseService.getCountInsert3(year,month,month1);
        StringBuffer s3=listtostring(list3);
        model.addAttribute("s3", s3);
        model.addAttribute("list3", list3);
        List<String> list4=new ArrayList<>();
        list4=enterpriseService.getCountInsert4(year,month,month1);
        StringBuffer s4=listtostring(list4);
        model.addAttribute("s4", s4);
        model.addAttribute("list4", list4);
        
        List<String> list5=new ArrayList<>();
        list5=enterpriseService.getCountInsert5(year,month,month1);
        StringBuffer s5=listtostring(list5);
        model.addAttribute("s5", s5);
        model.addAttribute("list5", list5);
        
        List<String> list6=new ArrayList<>();
        list6=enterpriseService.getCountInsert6(year,month,month1);
        StringBuffer s6=listtostring(list6);
        model.addAttribute("s6", s6);
        model.addAttribute("list6", list6);
          
        
       
        
        model.addAttribute("s", s);
       model.addAttribute("time1", time1);
       model.addAttribute("time2", time2);
        return "statisticsuser2";
    }
    
    public StringBuffer listtostring(List list){
        StringBuffer ss=new StringBuffer();
        ss.append("{");
        ss.append("name:\'"+list.get(0)+"\',data:[");
        for(int i=1;i<list.size();i++){
            ss.append(list.get(i)+",");
        }
        ss.deleteCharAt(ss.length()-1);
        ss.append("]}");
        return ss;
    }
    
    @RequestMapping("/money")
    public String money(Model model,String time1,String time2){
        Integer year=0;
        Integer month=0;
        Integer month1=0;
       
        Date date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        List<String> list=new ArrayList<>();
        if(time1==null||"".equals(time1)){
            year=gc.get(gc.YEAR);
            month=gc.get(gc.MONTH)+1;
            list.add(year+"年");
        }else{
            String[] str1 = time1.split("-");
            
            if(time2==null||"".equals(time2)){
                year=Integer.parseInt(str1[0]);
                month1=Integer.parseInt(str1[1])-1;
                month=gc.get(gc.MONTH)+1+(gc.get(gc.YEAR)-year)*12-month1;
                if(year==gc.get(gc.YEAR)){
                    
                    list.add(year+"年");
                }else{
                    
                    list.add(year+"年到"+gc.get(gc.YEAR)+"年");
                }
            }else{
                String[] str2 = time2.split("-");
                year=Integer.parseInt(str1[0]);
                month1=Integer.parseInt(str1[1])-1;
                month=Integer.parseInt(str2[1])+(Integer.parseInt(str2[0])-year)*12-month1;
                if(year==Integer.parseInt(str2[0])){
                    
                    list.add(year+"年");
                }else{
                    
                    list.add(year+"年到"+Integer.parseInt(str2[0])+"年");
                }
            }
            
        }
        StringBuffer s=new StringBuffer();
        s.append("[");
        for(int i=month1;i<month+month1;i++){
            list.add((i%12+1)+"月");
            s.append("\'"+(i%12+1)+"月\',");
        }
        s.deleteCharAt(s.length()-1);
        s.append("]");
        model.addAttribute("s", s);
        model.addAttribute("list", list);
        List<String> list1=new ArrayList<>();
        list1=bookedService.getCount(year,month,month1);
        StringBuffer s1=listtostring(list1);
        model.addAttribute("s1", s1);
        model.addAttribute("list1", list1);
        
        List<String> list2=new ArrayList<>();
        list2=bookedService.getCount1(year,month,month1);
        StringBuffer s2=listtostring(list2);
        model.addAttribute("s2", s2);
        model.addAttribute("list2", list2);
        
        List<String> list3=new ArrayList<>();
        list3.add("余额");
        int n;
        for(int i=1;i<list2.size();i++){
            n=Integer.parseInt(list1.get(i))-Integer.parseInt(list2.get(i));
            list3.add(n+"");
        }
        StringBuffer s3=listtostring(list3);
        model.addAttribute("s3", s3);
        model.addAttribute("list3", list3);
        model.addAttribute("time1", time1);
        model.addAttribute("time2", time2);
        return "statisticsmoney";
    }
    
    @RequestMapping("data")
    @ResponseBody
    public Result data(){
        Result result=new Result();
        
        
       
        
      // result.setData(list);
        return result;
    }
}
