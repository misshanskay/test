package cn.sirbox.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.sun.org.glassfish.external.probe.provider.annotations.ProbeParam;

import cn.sirbox.model.Area;
import cn.sirbox.model.City;
import cn.sirbox.model.Enterprise;
import cn.sirbox.model.Province;
import cn.sirbox.model.Result;
import cn.sirbox.model.UserEnterpriseKey;
import cn.sirbox.model.UserU;
import cn.sirbox.model.UserUExample;
import cn.sirbox.model.page;
import cn.sirbox.service.DeductMoneyservice;
import cn.sirbox.service.impl.EnterpriseService;
import cn.sirbox.service.impl.LoggerService;
import cn.sirbox.service.impl.UserUService;
import cn.sirbox.utils.ExcelUtil;
import cn.sirbox.utils.config;
import cn.sirbox.utils.fileupload;
import cn.sirbox.utils.utils;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {
	@Autowired
	private EnterpriseService enterpriseService;
	
	@Autowired
    private UserUService userUservice;
	
	
	@Autowired
    private LoggerService loggerService;
	
	@Autowired
    private DeductMoneyservice deductMoneyservice;
	//进入企业列表
	@RequestMapping("/list")
	public String list(Model model,Integer thispage,HttpServletRequest request){
			if(thispage==null){
				thispage=1;
			}
            String s=config.getKeyValue("pagenumber");
            int pagenumber=Integer.parseInt(s);
            List<Enterprise> list=new ArrayList<Enterprise>();
            
                
            list = enterpriseService.selectAllEnterprise(thispage,pagenumber);
            for(int i=0;i<list.size();i++){
                list.get(i).setBalance(deductMoneyservice.getBalanceByName(list.get(i).getEname()).getBalance());
            }
            model.addAttribute("list", list);
            	 
            PageInfo<Enterprise> page=new PageInfo<>(list);
            model.addAttribute("page", page);
           
            
       
		
		return "enterpriselist";
	}
	
	//进入企业添加页面
	@RequestMapping("/addenterprise")
	public String addenterprise(Model model){
		List<Province> provice=enterpriseService.getProvince();
		model.addAttribute("map",provice);
		Map<String,List<String>> map1=getType();
		model.addAttribute("map1",map1);
            
		return "addenterprise";
	}
	//企业添加
	@RequestMapping("/addenter")
	public String addenter(String time,UserU userU,Enterprise enterprise,HttpServletRequest request,
	        Model model,String address1,String address2,String address3,String address4) throws ParseException{
	 String eaddress=address1+"-"+address2+"-"+address3+"-"+address4;
	 
   	
   	if(time!=null){enterprise.setEtime(utils.stringtodate(time));}
   	
   	
   	enterprise.setEstatus(1);
   	enterprise.setEaddress(eaddress);
   	enterpriseService.insertSelective(userU,enterprise);
   	deductMoneyservice.addAccount(enterprise.getEname());
   	loggerService.logger(request, "LOG_ADDENTERPRISE", "LEVEL_INFO", 1, "企业注册");
   	
		
        
        
        
        List<Enterprise> list = enterpriseService.selectAllEnterprise(1,Integer.parseInt(config.getKeyValue("pagenumber")));
        for(int i=0;i<list.size();i++){
           list.get(i).setBalance(deductMoneyservice.getBalanceByName(list.get(i).getEname()).getBalance());
        }
        PageInfo<Enterprise> page=new PageInfo<Enterprise>(list);
        model.addAttribute("page", page);
    	model.addAttribute("list", list);
		return "enterpriselist";
	}
	
	@RequestMapping("/enterpriseuserlist")
	public String enterpriseuserlist(Integer eid,Model model){
	    List<Province> provice=enterpriseService.getProvince();
        model.addAttribute("map",provice);
		Map<String,List<String>> map1=getType();
		model.addAttribute("map1",map1);
		Enterprise enterprise=enterpriseService.getEnterpriseById(eid);
		List<UserU> user=new ArrayList<UserU>();
		UserU u;
		List<UserEnterpriseKey> usere=enterpriseService.getUserEnterprise(eid);
		for(int i=0;i<usere.size();i++){
		    u=userUservice.getUserUById1(usere.get(i).getUid());
		    u.setUserExtend(userUservice.getUserExtend(usere.get(i).getUid()));
		    user.add(u);
		    
		}
		enterprise.setUserU(user);
        model.addAttribute("enterprise", enterprise);
		return "enterpriseuserlist";
	}
	
	@RequestMapping("/upenterprise")
    public String upenterprise(Integer eid,Model model){
        Map<String,List<String>> map1=getType();
        model.addAttribute("map1",map1);
        Enterprise enterprise=enterpriseService.getEnterpriseById(eid);
        String[] addr=enterprise.getEaddress().split("-");
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String s1 = sdf.format(enterprise.getEtime());
        model.addAttribute("time", s1);
        
        List<Province> provice=enterpriseService.getProvince();
        model.addAttribute("map",provice);
        model.addAttribute("address1", addr[0]);
        List<City> city=new ArrayList<>();
        if(!"0".equals(addr[0])){
           
            city=enterpriseService.getCity(addr[0]);
        }
        model.addAttribute("city",city);
        model.addAttribute("address2", addr[1]);
        List<Area> area=new ArrayList<>();
        if(!"0".equals(addr[1])){
            
            area=enterpriseService.getArea(addr[1]);
        }
        model.addAttribute("area",area);
        model.addAttribute("address3", addr[2]);
        if(addr.length<4){
            
            model.addAttribute("address4","");
        }else{
            
            model.addAttribute("address4", addr[3]);
        }
        model.addAttribute("enterprise", enterprise);
        return "upenterprise";
    }
	
	@RequestMapping("/upenterprise1")
	public String upenterprise1(Enterprise enterprise,HttpServletRequest request,Model model,
	        String address1,String address2,String address3,String address4,String time) throws ParseException{
		
	    Date d=new SimpleDateFormat("yyyy-MM-dd").parse(time);
        enterprise.setEtime(d);
	    
	    String eaddress=address1+"-"+address2+"-"+address3+"-"+address4;
	    enterprise.setEaddress(eaddress);
	   	enterpriseService.updateByPrimaryKeySelective(enterprise);
        List<Enterprise> list = enterpriseService.selectAllEnterprise(1,Integer.parseInt(config.getKeyValue("pagenumber")));
        for(int i=0;i<list.size();i++){
           // list.get(i).setBalance(deductMoneyservice.getBalanceByid(list.get(i).getEid()).getBalance());
        }
        PageInfo<Enterprise> page=new PageInfo<Enterprise>(list);
        model.addAttribute("page", page);
        model.addAttribute("list", list);
        return "enterpriselist";
		
	}
	
	@RequestMapping("/reviewed")
	public String reviewed(Integer eid,Model model){
		Enterprise enterprise=enterpriseService.getEnterpriseById(eid);
		List<UserU> user=new ArrayList<UserU>();
        UserU u;
        List<UserEnterpriseKey> usere=enterpriseService.getUserEnterprise(eid);
        for(int i=0;i<usere.size();i++){
            u=userUservice.getUserUById1(usere.get(i).getUid());
            u.setUserExtend(userUservice.getUserExtend(usere.get(i).getUid()));
            user.add(u);
            
        }
        enterprise.setUserU(user);
        model.addAttribute("enterprise", enterprise);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = sdf.format(enterprise.getEtime());
        model.addAttribute("time", s1);
		return "reviewed";
	}
	@RequestMapping("/reviewed1")
	public String reviewed1(Integer eid,Model model,Integer status,HttpServletRequest request){
		Enterprise enterprise=enterpriseService.getEnterpriseById(eid);
		enterprise.setEstatus(status);
		enterpriseService.updateStatus(enterprise);
		if(status==2){
		    loggerService.logger(request, "LOG_ENTERPRISEREVIEWED", "LEVEL_INFO", 1, "审核通过!");
			
			//email.toemail(enterprise.getEemail(), "审核结果","审核以通过，可以登陆了！");//这是发送邮件的代码，因为现在邮箱不正确，先注释。
		}
		if(status==3){
		    loggerService.logger(request, "LOG_ENTERPRISEREVIEWED", "LEVEL_INFO", 1, "审核未通过!");
			//email.toemail(enterprise.getEemail(), "审核结果","审核未通过，请您把信息输入详细！");//这是发送邮件的代码，因为现在邮箱不正确，先注释。
			
		}
		
		List<Enterprise> list = enterpriseService.selectAllEnterprise(1,Integer.parseInt(config.getKeyValue("pagenumber")));
		for(int i=0;i<list.size();i++){
          //  list.get(i).setBalance(deductMoneyservice.getBalanceByid(list.get(i).getEid()).getBalance());
        }
        PageInfo<Enterprise> page=new PageInfo<Enterprise>(list);
        model.addAttribute("page", page);
        model.addAttribute("list", list);
        return "enterpriselist";
	}
	
	@RequestMapping("/reviewed2")
	public String reviewed2(String estatuss,Model model,HttpServletRequest request){
		
		String[] es=jsontostring(estatuss);
		for(int i=0;i<es.length;i++){
			Enterprise enterprise=enterpriseService.getEnterpriseById(Integer.parseInt(es[i]));
			enterpriseService.updateStatusById(Integer.parseInt(es[i]),2);
			//email.toemail(enterprise.getEemail(), "审核结果","审核以通过，可以登陆了！");//这是发送邮件的代码，因为现在邮箱不正确，先注释。
		}
		loggerService.logger(request, "LOG_ENTERPRISEREVIEWED", "LEVEL_INFO", 1, "批量审核!");
		List<Enterprise> list = enterpriseService.selectAllEnterprise(1,Integer.parseInt(config.getKeyValue("pagenumber")));
		for(int i=0;i<list.size();i++){
          //  list.get(i).setBalance(deductMoneyservice.getBalanceByid(list.get(i).getEid()).getBalance());
        }
        PageInfo<Enterprise> page=new PageInfo<Enterprise>(list);
        model.addAttribute("page", page);
        model.addAttribute("list", list);
        return "enterpriselist";
	}
	
        @RequestMapping("download")
        public String download(@ProbeParam("message")String message,String chk ,HttpServletRequest request,HttpServletResponse response) throws IOException{
            //填充projects数据
            
            Enterprise enterprise=enterpriseService.getEnterpriseById(Integer.parseInt(chk));
            String fileName=enterprise.getEname();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                List<Map<String,String>> list=getExcelEnterprise(enterprise);
                ExcelUtil.createWorkBook(request,list).write(os);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
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
                loggerService.logger(request, "LOG_ENTERPRISEDOWN", "LEVEL_INFO", 1, "企业信息下载成功!");
            } catch (final IOException e) {
                loggerService.logger(request, "LOG_ENTERPRISEDOWN", "LEVEL_WARN", 0, "企业信息下载失败!");
                throw e;
            } finally {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            }
            return null;
        }
        
        @RequestMapping("download1")
        public String download1(HttpServletRequest request,HttpServletResponse response) throws IOException{
            //填充projects数据
            
            List<Enterprise> enterprise=enterpriseService.getAllEnterprise();
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                List<Map<String,String>> list=getExcelEnterprise1(enterprise);
                ExcelUtil.createWorkBook(request,list).write(os);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String(("全部企业" + ".xls").getBytes(), "iso-8859-1"));
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
                loggerService.logger(request, "LOG_ENTERPRISEDOWN", "LEVEL_INFO", 1, "企业信息下载成功!");
            } catch (final IOException e) {
                loggerService.logger(request, "LOG_ENTERPRISEDOWN", "LEVEL_WARN", 0, "企业信息下载失败!");
                throw e;
            } finally {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            }
            return null;
        }
	
    private List<Map<String, String>> getExcelEnterprise1(List<Enterprise> list1) {
            // TODO Auto-generated method stub
        List<Map<String,String>> list=new ArrayList<>();
       
        for(int i=0;i<list1.size();i++){
            Map<String,String> map1=new LinkedHashMap<String, String>();
            
            map1.put("企业名：",list1.get(i).getEname());
            map1.put("营业执照号：", list1.get(i).getEbusines());
            map1.put("税务登记号：", list1.get(i).getEte());
            map1.put("地址：", list1.get(i).getEaddress());
            map1.put("金额：", list1.get(i).getEamount()+"");
            map1.put("法人：", list1.get(i).getElegal());
            map1.put("注册时间：", list1.get(i).getEtime()+"");
            map1.put("经营范围：", list1.get(i).getErange());
            map1.put("联系人：", list1.get(i).getEcontacts());
            map1.put("联系人电话：", list1.get(i).getEphone());
            map1.put("联系人邮箱：", list1.get(i).getEemail());
            map1.put("招商意向：", list1.get(i).getEintention());
            map1.put("行业类别：", list1.get(i).getEtype());
            map1.put("融资金额：", list1.get(i).getEfinancingbegin()+"-"+list1.get(i).getEfinancingout());
            list.add(map1);
        }
            return list;
        }

    private List<Map<String,String>> getExcelEnterprise(Enterprise enterprise) {
            // TODO Auto-generated method stub
        List<Map<String,String>> list=new ArrayList<>();
        Map<String,String> map=new LinkedHashMap<String, String>();
        map.put("企业名：",enterprise.getEname());
        map.put("营业执照号：", enterprise.getEbusines());
        map.put("税务登记号：", enterprise.getEte());
        map.put("地址：", enterprise.getEaddress());
        map.put("金额：", enterprise.getEamount()+"");
        map.put("法人：", enterprise.getElegal());
        map.put("注册时间：", enterprise.getEtime()+"");
        map.put("经营范围：", enterprise.getErange());
        map.put("联系人：", enterprise.getEcontacts());
        map.put("联系人电话：", enterprise.getEphone());
        map.put("联系人邮箱：", enterprise.getEemail());
        map.put("招商意向：", enterprise.getEintention());
        map.put("行业类别：", enterprise.getEtype());
        map.put("融资金额：", enterprise.getEfinancingbegin()+"万元  到"+enterprise.getEfinancingout()+"万元");
        list.add(map);
        
            return list;
        }

    @RequestMapping("downpassword")
    @ResponseBody
    public Result downpassword(@ProbeParam("message")String message,HttpServletRequest request){
        Result result=new Result();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()  
                .getAuthentication()  
                .getPrincipal();  
        
        UserU user=userUservice.getUserUByName(userDetails.getUsername());
       
       
        if(message.equals(user.getDownpassword())){
        	result.setStatus(200);
        }else{
        	result.setStatus(100);
        	result.setMsg("下载密码不正确！");
        }
        return result;
    } 
    
    @RequestMapping("dele")
    @ResponseBody
    public Result dele(Integer eid,HttpServletRequest request){
        Result result=new Result();
        Enterprise enterprise=enterpriseService.getEnterpriseById(eid);
        enterpriseService.dele(enterprise);
        result.setStatus(200);
        return result;
    }  
	 
	@RequestMapping("city")
	@ResponseBody
	public Result city(String name){
	    Result result=new Result();
	    List<City> city=enterpriseService.getCity(name);
	    result.setData(city);
	    return result;
	}
	
	@RequestMapping("area")
    @ResponseBody
    public Result area(String name){
        Result result=new Result();
        List<Area> area=enterpriseService.getArea(name);
        result.setData(area);
        return result;
    }
	
	@RequestMapping("search")
    public String search(String name,Model model){
	    List<Province> provice=enterpriseService.getProvince();
        model.addAttribute("map",provice);
        Map<String,List<String>> map1=getType();
        model.addAttribute("map1",map1);
        return "searchenterprise";
    }
	
	@RequestMapping("searchenterprise")
    public String searchenterprisse(Model model,Integer thispage,Enterprise enterprise,String address1,String address2,String address3,String address4,
            String amount1,String amount2,HttpServletRequest request){
	    if(thispage==null){
	        thispage=1;
	    }
	    Integer pagenumber=Integer.parseInt(config.getKeyValue("pagenumber"));
	    String eaddress=address1+"-"+address2+"-"+address3+"-"+address4;
	    enterprise.setEaddress(eaddress);
	    
	   
	    
	    List<Enterprise> list=enterpriseService.searchenterprise(thispage,enterprise,amount1,amount2,pagenumber);
        PageInfo<Enterprise> pagee=new PageInfo<>(list);
        model.addAttribute("enterrpise", enterprise);
        model.addAttribute("address1", address1);
        model.addAttribute("address2", address2);
        model.addAttribute("address3", address3);
        model.addAttribute("address4", address4);
        model.addAttribute("amount1", amount1);
        model.addAttribute("amount2", amount2);
        model.addAttribute("page", pagee);
        
        return "searchenter";
    }
	
	
    
	@RequestMapping("/fileupload")
    @ResponseBody
    public Result fileupload(@RequestParam(value = "img1", required = false) MultipartFile file,
            HttpServletRequest request,Integer id){
        
        Result result=new Result();
        
        String str=request.getRealPath("/");
        String name=new Date().getTime()+".png";
         String fileName ="images"+System.getProperty("file.separator")+"enterprise"+System.getProperty("file.separator")+ name;
         String fileName1 ="images/enterprise/"+ name;
         String m=str+fileName;
         String msg=fileupload.fileupload(file, m);
         if(!"success".equals(msg)){
             result.setStatus(100);
             result.setMsg(msg);
             return result;
         }
       result.setData(fileName1);
       result.setStatus(200);
       if(id!=null && !"".equals(id)){
       Enterprise enterprise=new Enterprise();
       enterprise.setEbusiness(fileName1);
       enterprise.setEid(id);
        enterpriseService.updateImg(enterprise);
       }
         return result;
    }
	
	
	@RequestMapping("/fileupload1")
    @ResponseBody
    public Result fileupload1(@RequestParam(value = "img2", required = false) MultipartFile file,
            HttpServletRequest request,Integer id){
        
        Result result=new Result();
        
        String str=request.getRealPath("/");
        String name=new Date().getTime()+".png";
        String fileName ="images"+System.getProperty("file.separator")+"enterprise"+System.getProperty("file.separator")+"tex"+System.getProperty("file.separator")+ name;
        String fileName1 ="images/enterprise/tex/"+ name;
         String m=str+fileName;
         String msg=cn.sirbox.utils.fileupload.fileupload(file, m);
         if(!"success".equals(msg)){
             result.setStatus(100);
             result.setMsg(msg);
             return result;
         }
       result.setData(fileName1);
       result.setStatus(200);
       if(id!=null && !"".equals(id)){
       Enterprise enterprise=new Enterprise();
       enterprise.setEtex(fileName1);
       enterprise.setEid(id);
        enterpriseService.updateImg(enterprise);
       }
         return result;
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
	
	public String[] jsontostring(String s){
		String m=s.substring(1,s.length()-1);
		String[] en=m.split(",");
		for(int i=0;i<en.length;i++){
			en[i]=en[i].substring(1, en[i].length()-1);
		}
		return en;
	}
}
