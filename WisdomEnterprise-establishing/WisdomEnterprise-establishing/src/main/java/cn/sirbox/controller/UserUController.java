package cn.sirbox.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.ConfigurationException;
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

import cn.sirbox.model.Area;
import cn.sirbox.model.City;
import cn.sirbox.model.Dept;
import cn.sirbox.model.Part;
import cn.sirbox.model.Province;
import cn.sirbox.model.Result;
import cn.sirbox.model.UserDeptKey;
import cn.sirbox.model.UserExtend;
import cn.sirbox.model.UserPartKey;
import cn.sirbox.model.UserU;
import cn.sirbox.model.page;
import cn.sirbox.service.impl.DeptService;
import cn.sirbox.service.impl.EnterpriseService;
import cn.sirbox.service.impl.LoggerService;
import cn.sirbox.service.impl.PartService;
import cn.sirbox.service.impl.UserUService;
import cn.sirbox.utils.config;
import cn.sirbox.utils.email;
import cn.sirbox.utils.fileupload;

/**
 * Created by X201 on 2016/8/26 0026.
 */
@Controller
@RequestMapping("/user")
public class UserUController {


    @Autowired
    private UserUService userUService;

    @Autowired
    private DeptService deptService;
    
    @Autowired
    private PartService partService;
    
    @Autowired
    private EnterpriseService enterpriseService;
    
    @Autowired
    private LoggerService loggerService;
    
    //进入主页面
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()  
                .getAuthentication()  
                .getPrincipal();  
        UserU userU=userUService.getUserUByName(userDetails.getUsername());
        if("government".equals(userU.getStatus())){
            
            return "index";
        }
        return "enterpriseindex";
    }
  @RequestMapping("/top")
    public String top(HttpServletRequest request,HttpServletResponse response) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()  
                .getAuthentication()  
                .getPrincipal();  
              
    	HttpSession session=request.getSession();
    	
    	UserU userU=userUService.getUserUByName(userDetails.getUsername());
    	
    	session.setAttribute("userU", userU);
    	/*Cookie cook=new Cookie("uname", userU.get(0).getUname());
    	Cookie cook1=new Cookie("upassword", userU.get(0).getUpassword());
    	cook.setMaxAge(60*60*24*3);
    	cook1.setMaxAge(60*60*24*3);
    	cook.setPath("/");
    	cook1.setPath("/");
    	response.addCookie(cook);
    	response.addCookie(cook1);*/
    	
        return "_top";
    }
    @RequestMapping("/right")
    public String right() {
        
        return "_left";
    }
    @RequestMapping("/left")
    public String left() {
       
        return "_right";
    }
    //进入注册页面
    @RequestMapping("/register")
    public String register(Model model) {
		List<Dept> dept=deptService.getAllDept();
		StringBuffer sn1=new StringBuffer();
		sn1.append("[");
		sn1=hh(sn1,dept,0);
		sn1.deleteCharAt(sn1.length()-1);
		sn1.append("]");
		String ss=sn1.toString();
		List<Part> list=partService.getAllPart();
		List<Province> provice=enterpriseService.getProvince();
        model.addAttribute("map",provice);
		model.addAttribute("list", list);
		model.addAttribute("ztreeno",ss);
        return "register";
    }
//进入登录页面
    @RequestMapping("/login")
    public String login(HttpServletRequest request,Model model) {
    		
        String s=config.getKeyValue("base");
    		String m=config.getKeyValue("imgsrc");
    		
    		
    		model.addAttribute("imgsrc", m);
    		model.addAttribute("base", s);
            return "login";

    }
 //密码找回，可以发送邮件到用户邮箱  
    @RequestMapping("/find")
    @ResponseBody
    public Result find(String uname) {
    		Result result=new Result();
    		
    	
    		UserU user=userUService.getUserUByName(uname);
    		UserExtend ue=userUService.getUserExtend(user.getUid());
    		if(user!=null){
    			result.setStatus(200);
    		}else{
    			result.setStatus(100);
    			return result;
    		}
    		String password=email.toemail(ue.getUemail(), "密码找回！");
            user.setUpassword(password);
            userUService.updateByPrimaryKeySelective(user);
    		
            return result;

    }
//判断用户是否已存在
    @RequestMapping("/aj")
    @ResponseBody
    public String aj(String uname) {

        UserU u=userUService.getUserUByName(uname);
        if(u==null){
            return "success";
        }

        return "";
        
    }
    //用户添加
   @RequestMapping("/addu")
    public String register(UserU userU, Model model,HttpServletRequest request,String udept,String part,
            String birthday,String address1,String address2,String address3,String address4) throws ParseException, NumberFormatException, ConfigurationException{
    	String uaddress=address1+"-"+address2+"-"+address3+"-"+address4;
    	 
        
        if(birthday!=null&&!"".equals(birthday)){
            
            Date d=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            userU.getUserExtend().setUbirthday(d);
        }
    	userU.getUserExtend().setUaddress(uaddress);
    	if(!regex("[a-z0-9A-Z]{6,16}", userU.getUname())){
    	    return null;
    	}
    	userU.getUserExtend().setUage(15);
    	UserU userU1=userUService.insertSelective(userU);
    	if(udept!=null&&!"".equals(udept)){
    	    
    	    int did=deptService.getDeptByName(udept).getDid();
    	    userU1.setUserDeptKey(new UserDeptKey());
    	    userU1.getUserDeptKey().setDid(did);
    	    userUService.insertDept(userU1);
    	}
    	
    	if(part!=null&&!"".equals(part)){
    	    
    	    partService.insertUserUPart(userU1.getUid(),partService.getPartByName(part).getPid());
    	}
        loggerService.logger(request, "LOG_ADDUSER", "LEVEL_INFO", 1, "用户添加成功!");
        
        Integer count=userUService.countByExample();
        Integer page1=count%(Integer.parseInt(config.getKeyValue( "pagenumber")))==0?count/(Integer.parseInt(config.getKeyValue( "pagenumber"))):count/(Integer.parseInt(config.getKeyValue( "pagenumber")))+1;
        List<UserU> list = userUService.selectAllUserU(1,Integer.parseInt(config.getKeyValue( "pagenumber")));
        
        for(int i=0;i<list.size();i++){
            list.get(i).setUserExtend(userUService.getUserExtend(list.get(i).getUid()));
        }
        List<UserU> useru=userUService.getAllUserUGovernment();
        for(int i=0;i<useru.size();i++){
            useru.get(i).setUserDeptKey(userUService.getUserUserDeptKey(useru.get(i).getUid()));
        }
        List<Dept> dept=deptService.getAllDept();
        StringBuffer sn=new StringBuffer();
        sn.append("[");
        sn=hhh(sn,useru,dept,0);
        sn.deleteCharAt(sn.length()-1);
        sn.append("]");
        String ss=sn.toString();
        
        model.addAttribute("ztreeno",ss);
        model.addAttribute("page1",page1);
        model.addAttribute("thispage",1);
        model.addAttribute("list",list);
        return "userulist";
    }
   
   public boolean regex(String regex,String data){
       
       Pattern p = Pattern.compile(regex);
       Matcher m = p.matcher(data);
       if (m.find()){
          return true;
       }
       return false;
   }
   
   
    //进入用户列表页面
    @RequestMapping("/list")
    public String list(Model model,HttpServletRequest request) throws NumberFormatException, ConfigurationException{
        Integer pagenumber=Integer.parseInt(config.getKeyValue("pagenumber"));
        List<UserU> list = userUService.selectAllUserU(1,pagenumber);
        PageInfo<UserU> pagee=new PageInfo<>(list);
        
        for(int i=0;i<list.size();i++){
            list.get(i).setUserExtend(userUService.getUserExtend(list.get(i).getUid()));
        }
        List<UserU> useru=userUService.getAllUserUGovernment();
        for(int i=0;i<useru.size();i++){
            useru.get(i).setUserDeptKey(userUService.getUserUserDeptKey(useru.get(i).getUid()));
        }
		List<Dept> dept=deptService.getAllDept();
		StringBuffer sn=new StringBuffer();
		sn.append("[");
		sn=hhh(sn,useru,dept,0);
		sn.deleteCharAt(sn.length()-1);
		sn.append("]");
		String ss=sn.toString();
		
		model.addAttribute("ztreeno",ss);
        model.addAttribute("page1",pagee.getPages());
        model.addAttribute("thispage",1);
        model.addAttribute("list",list);
        return "userulist";
    }
    //进入用户树页面
   /* @RequestMapping("/list1")
	public String login(Model model) {
		
		List<UserU> useru=userUService.getAllUserUDept();
		List<Dept> dept=deptService.getAllDept();
		StringBuffer sn=new StringBuffer();
		sn.append("[");
		sn=hhh(sn,useru,dept,0);
		sn.deleteCharAt(sn.length()-1);
		sn.append("]");
		String ss=sn.toString();
		model.addAttribute("ztreeno",ss);
		return "ztree";
	}*/
    //用户列表分页显示
    @RequestMapping("/all")
    @ResponseBody
    public page selectalluser(page page1,HttpServletRequest request) throws NumberFormatException, ConfigurationException {
        Integer pagenumber=Integer.parseInt(config.getKeyValue("pagenumber"));
        try{
            page1.setStatus(0);
            List<UserU> list = userUService.selectAllUserU(page1.getThispage(),pagenumber);
            PageInfo<UserU> pagee=new PageInfo<>(list);
            page1.setCount((int)pagee.getTotal());
            
            
            page1.setPage(pagee.getPages());
            for(int i=0;i<list.size();i++){
                list.get(i).setUserExtend(userUService.getUserExtend(list.get(i).getUid()));
            }
            page1.setData(list);
            
        }catch (Exception e){
            page1.setStatus(1);
            page1.setMsg("请求失败");
        }

        return page1;
    }
    //根据id删除用户
    @RequestMapping("/dele")
    @ResponseBody
    public void dele(Integer uid){
        userUService.deleteUserUById(uid);
    }
    
    @RequestMapping("/start")
    @ResponseBody
    public void start(Integer uid){
        userUService.startUserUById(uid);
    }
    
    //进入修改用户页面
    @RequestMapping("/updata")
    public String updata(Integer uid,Model model){
        
        List<Dept> dept=deptService.getAllDept();
        StringBuffer sn1=new StringBuffer();
        sn1.append("[");
        sn1=hh(sn1,dept,0);
        sn1.deleteCharAt(sn1.length()-1);
        sn1.append("]");
        String ss=sn1.toString();
        
        model.addAttribute("ztreeno",ss);
        UserU userU=userUService.getUserUById(uid);
        userU.setUserExtend(userUService.getUserExtend(uid));
        if(userU.getStatus()!=null&&userU.getStatus().equals("government")){
            String dname=deptService.getDeptById(userUService.getUserUserDeptKey(uid).getDid()).getDname();
            model.addAttribute("dname", dname);
        }
        model.addAttribute("userU",userU);
        List<UserPartKey> upk=userUService.getUserPartKey(uid);
        String pname;
        if(upk.size()==0){
            pname="";
        }else{
            
            pname=(partService.getPartById(upk.get(0).getPid()).getPname());
        }
        List<Part> list1=partService.getAllPart();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(userU.getUserExtend().getUbirthday()!=null){
            
            String s1 = sdf.format(userU.getUserExtend().getUbirthday());
            model.addAttribute("birthday", s1);
        }
        if(userU.getUserExtend().getUaddress()!=null){
            String[] addr=userU.getUserExtend().getUaddress().split("-");
            
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
        }
        
        
		model.addAttribute("pname", pname);
		model.addAttribute("list1", list1);
        return "updata";
    }
//修改用户
    @RequestMapping("/upu")
    public String upu(UserU userU,HttpServletRequest request,Model model,String udept,String part,
            String birthday,String address1,String address2,String address3,String address4) throws ParseException, NumberFormatException, ConfigurationException, UnsupportedEncodingException{
        
        String uaddress=new String(address1.getBytes("ISO-8859-1"),"UTF-8")+"-"+new String(address2.getBytes("ISO-8859-1"),"UTF-8")+"-"+new String(address3.getBytes("ISO-8859-1"),"UTF-8")+"-"+new String(address4.getBytes("ISO-8859-1"),"UTF-8");
        Integer pagenumber=Integer.parseInt(config.getKeyValue("pagenumber"));
        Date d=new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        userU.getUserExtend().setUbirthday(d);
        String udept1= new String(udept.getBytes("ISO-8859-1"),"UTF-8");
        int did=deptService.getDeptByName(udept1).getDid();
        userU.setUserDeptKey(new UserDeptKey());
        userU.getUserDeptKey().setDid(did);
        userU.getUserExtend().setUaddress(uaddress);
        userU.getUserExtend().setUsex(new String(userU.getUserExtend().getUsex().getBytes("ISO-8859-1"),"UTF-8"));
        userU.getUserExtend().setUpost(new String(userU.getUserExtend().getUpost().getBytes("ISO-8859-1"),"UTF-8"));
        userU.getUserExtend().setUunit(new String(userU.getUserExtend().getUunit().getBytes("ISO-8859-1"),"UTF-8"));
        userU.getUserExtend().setUpolitical(new String(userU.getUserExtend().getUpolitical().getBytes("ISO-8859-1"),"UTF-8"));
        userU.getUserExtend().setUgraduation(new String(userU.getUserExtend().getUgraduation().getBytes("ISO-8859-1"),"UTF-8"));
        userU.getUserExtend().setUintroduction(new String(userU.getUserExtend().getUintroduction().getBytes("ISO-8859-1"),"UTF-8"));
        userU.getUserExtend().setUmajor(new String(userU.getUserExtend().getUmajor().getBytes("ISO-8859-1"),"UTF-8"));
        userU.getUserExtend().setUrealname(new String(userU.getUserExtend().getUrealname().getBytes("ISO-8859-1"),"UTF-8"));
        userU.getUserExtend().setUunit(new String(userU.getUserExtend().getUunit().getBytes("ISO-8859-1"),"UTF-8"));
        
        userUService.updateSelective(userU);
        String part1= new String(part.getBytes("ISO-8859-1"),"UTF-8");
        partService.updateUserUPart(userU.getUid(),partService.getPartByName(part1).getPid());
        loggerService.logger(request, "LOG_UPDATEUSER", "LEVEL_INFO", 1, "用户修改成功!");
        
        List<UserU> list = userUService.selectAllUserU(1,pagenumber);
        PageInfo<UserU> pagee=new PageInfo<>(list);
        for(int i=0;i<list.size();i++){
            list.get(i).setUserExtend(userUService.getUserExtend(list.get(i).getUid()));
        }
        List<UserU> useru=userUService.getAllUserUGovernment();
        for(int i=0;i<useru.size();i++){
            useru.get(i).setUserDeptKey(userUService.getUserUserDeptKey(useru.get(i).getUid()));
        }
        List<Dept> dept=deptService.getAllDept();
        StringBuffer sn=new StringBuffer();
        sn.append("[");
        sn=hhh(sn,useru,dept,0);
        sn.deleteCharAt(sn.length()-1);
        sn.append("]");
        String ss=sn.toString();
        
        model.addAttribute("ztreeno",ss);
        model.addAttribute("page1",pagee.getPages());
        model.addAttribute("thispage",1);
        model.addAttribute("list",list);
        return "userulist";
    }
    //ztree中用户在部门上的移动
    @RequestMapping("/moveuser")
	@ResponseBody
	public String moveuser(Integer uid,Integer did) {
		Integer uu=-uid;
		userUService.updateDeptById(uu,did);
		return "success";
	}
    //删除用户，把用户状态设为0
    @RequestMapping("/removeuser")
	@ResponseBody
	public String removedept(Integer uid) {
		userUService.deleteUserUById(-uid);
		return "success";
	}
    //根据用户名称查询用户
    @RequestMapping("/searchu")
   	@ResponseBody
   	public Result seleteuser(String uname) {
    	
   		UserU userU=userUService.getUserUByName(uname);
   		Result result=new Result();
   		if(userU==null){
   			result.setStatus(100);
   			result.setMsg("没有这个用户！");
   		}else{
   			result.setStatus(200);
   			userU.setUserExtend(userUService.getUserExtend(userU.getUid()));
   			result.setData(userU);
   			
   		}
   		return result;
   	}
   /* @RequestMapping("/seletepart")
    @ResponseBody
    public Result seletepart(String pname){
    	List<String> list=partService.getRole(pname);
    	Result result=new Result();
    	result.setData(list);
    	return result;
    }*/
    //进入系统设置页面
    @RequestMapping("/setup")
    public String setup(HttpServletRequest request,Model model) throws ConfigurationException{
    	model.addAttribute("base", config.getKeyValue("base"));
    	model.addAttribute("imgsrc", config.getKeyValue("imgsrc"));
    	model.addAttribute("pagenumber", config.getKeyValue("pagenumber"));
    	return "setup";
    }
    
    //系统设置中修改备案号信息
    @RequestMapping("/upbase")
    @ResponseBody
    public Result upbase(HttpServletRequest request,String base) throws ConfigurationException{
    	Result result=new Result();
    	String b=config.writeProperties("base", base);
    	
    	result.setData(b);
    	return result;
    }
    
    @RequestMapping("/uppagenumber")
    @ResponseBody
    public Result uppagenumber(HttpServletRequest request,String pagenumber) throws ConfigurationException{
        Result result=new Result();
        String b=config.writeProperties("pagenumber", pagenumber);
        result.setData(b);
        return result;
    }
    
    
    @RequestMapping("/selectuser")
    @ResponseBody
    public Result selectuser(HttpServletRequest request,String uname,String status){
        Result result=new Result();
        UserU user=new UserU();
       
        user.setUname(uname);
        List<UserU> list=new ArrayList<>();
        if("所有".equals(status)){
            
            list=userUService.getAllUserUname1(user);
        }else if("政府端".equals(status)){
            user.setStatus("government");
            list=userUService.getAllUserUname1(user);
        }else{
            user.setStatus("enterprise");
            list=userUService.getAllUserUname1(user);
        }
        List<String> list1= new ArrayList<>();
        for(int i=0;i<list.size();i++){
            list1.add(list.get(i).getUname());
        }
        result.setData(list1);
        result.setStatus(200);
        return result;
    }
    
    
    //系统设置中修改logo
    @RequestMapping("/upfile")
    @ResponseBody
    public Result upfile(@RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletRequest request){
    	
    	Result result=new Result();
    	
    	String str=request.getRealPath("/");
    	System.out.println(123);
    	 String fileName ="images"+System.getProperty("file.separator")+ new Date().getTime()+".png";
    	 String fileName1 ="images/"+ new Date().getTime()+".png";
    	 config.writeProperties("imgsrc", fileName1);
    	 String m=str+fileName;
    	String msg=fileupload.fileupload(file, m);
    	if(!"success".equals(msg)){
    	    result.setStatus(100);
    	    result.setMsg(msg);
    	    return result;
    	}
    	result.setData(fileName1);
        result.setStatus(200);
         return result;
    }
    
   //异步上传头像
    @RequestMapping("/fileupload")
    @ResponseBody
    public Result fileupload(@RequestParam(value = "img", required = false) MultipartFile file,
            HttpServletRequest request,Integer id){
        
        Result result=new Result();
        
        String str=request.getRealPath("/");
       
         String fileName = "images"+System.getProperty("file.separator")+"userimg"+System.getProperty("file.separator")+new Date().getTime()+".png";
         String fileName1 = "images/userimg/"+new Date().getTime()+".png";
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
           
           UserExtend userU=new UserExtend();
           userU.setImgsrc(fileName1);
           userU.setUid(id);
           userUService.updateUserUImg(userU);
       }
         return result;
    }
    
    
    @RequestMapping("/information")
    public String information(HttpServletRequest request,Model model,Integer id){
        
        
        UserU user=userUService.getUserUById(id);
        user.setUserExtend(userUService.getUserExtend(id));
        model.addAttribute("user", user);
        
         return "information";
    }
    
    @RequestMapping("/deptinformation")
    public String deptinformation(HttpServletRequest request,Model model,Integer id,Integer thispage){
        List<Integer> d=new ArrayList<>();
        d=getDeptByDid(id,d);
        int pages=userUService.getCount(d);
        int ps=pages%Integer.parseInt(config.getKeyValue("pagenumber"))==0?pages/Integer.parseInt(config.getKeyValue("pagenumber")):pages/Integer.parseInt(config.getKeyValue("pagenumber"))+1;
        if(thispage==null){
            thispage=1;
        }else{
            if(thispage==0){
                thispage=thispage+1;
                
            }
            if(thispage>ps){
                thispage=thispage-1;
                
            }
        }
        
        List<UserU> user=userUService.getUserByList(d,thispage,Integer.parseInt(config.getKeyValue("pagenumber")));
        for(int i=0;i<user.size();i++){
            user.get(i).setUserExtend(userUService.getUserExtend(user.get(i).getUid()));
        }
        PageInfo<UserU> page=new PageInfo<>(user);
        model.addAttribute("page", page);
        model.addAttribute("id", id);
         
         return "deptinformation";
    }

    @RequestMapping("/information1")
    @ResponseBody
    public Result information1(HttpServletRequest request,Model model,Integer id,Integer thispage){
        Result result=new Result();
        List<Integer> d=new ArrayList<>();
        d=getDeptByDid(id,d);
        int pages=userUService.getCount(d);
        int ps=pages%Integer.parseInt(config.getKeyValue("pagenumber"))==0?pages/Integer.parseInt(config.getKeyValue("pagenumber")):pages/Integer.parseInt(config.getKeyValue("pagenumber"))+1;
        result.setStatus(200);
        if(thispage==0){
            result.setStatus(100);
                
        }
        if(thispage>ps){
            result.setStatus(100);
             
        }
       
        
         
         return result;
    }
    
    
    private List<Integer> getDeptByDid(Integer id, List<Integer> d) {
        // TODO Auto-generated method stub
        List<UserDeptKey> udk=deptService.getUidByDid(id);
        for(int i=0;i<udk.size();i++){
            d.add(udk.get(i).getUid());
        }
        List<Dept> dept=deptService.getDeptByPid(id);
        for(int i=0;i<dept.size();i++){
            d=getDeptByDid(dept.get(i).getDid(),d);
        }
        return d;
    }
    //拼接字符串，用户和部门的
    public StringBuffer hhh(StringBuffer sn,List<UserU> useru,List<Dept> dept,Integer i){
		for(Dept d:dept){
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
			if(u.getUserDeptKey().getDid()==i){
				sn.append("{");
				sn.append("id:-"+u.getUid());
				sn.append(",pId:"+i);
				sn.append(",name:'"+userUService.getUserUById(u.getUid()).getUname());
				sn.append("'},");
			}
	}
		return sn;
	}
    //拼接字符串，只有部门的
    public StringBuffer hh(StringBuffer sn,List<Dept> dept,Integer i){
		for(Dept d:dept){
			if(d.getPid()==i){
				sn.append("{");
				sn.append("id:"+d.getDid());
				sn.append(",pId:"+d.getPid());
				sn.append(",name:'"+d.getDname());
				
				sn.append("'},");
				sn=hh(sn,dept,d.getDid());
				
			
		}
		
		}
		
		return sn;
	}
    
    
}