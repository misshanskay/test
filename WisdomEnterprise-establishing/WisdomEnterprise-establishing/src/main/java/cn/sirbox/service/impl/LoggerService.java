package cn.sirbox.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.sirbox.dao.LoggerMapper;
import cn.sirbox.dao.UserLoggerMapper;
import cn.sirbox.dao.UserUMapper;
import cn.sirbox.model.Logger;
import cn.sirbox.model.LoggerExample;
import cn.sirbox.model.LoggerExample.Criteria;
import cn.sirbox.model.UserLoggerExample;
import cn.sirbox.model.UserLoggerKey;
import cn.sirbox.model.UserU;
import cn.sirbox.model.UserUExample;
import cn.sirbox.utils.utils;

@Service
public class LoggerService {

    @Autowired
    private LoggerMapper loggerMapper;
    
    @Autowired
    private UserLoggerMapper userLoggerMapper;
    
    @Autowired
    private UserUMapper userUMapper;
    
    private static HashMap<String, String> map = new HashMap<String, String>() {
        {
        
            put("LOG_LOGIN", "系统登录");
            put("LOG_LOGOUT", "系统登出");
            put("LOG_ADDUSER", "用户添加");
            put("LOG_ADDENTERPRISE", "企业注册");
            put("LOG_ENTERPRISEREVIEWED", "企业审核");
            put("LOG_ENTERPRISEDOWN", "企业信息下载");
            put("LOG_ADDRELEASE", "招商信息发布");
            put("LOG_RELEASEREVIEWED", "招商信息审核");
            put("LOG_RELEASEDOWN", "招商信息下载");
            put("LOG_ADDDOARTICLE", "发起办文");
            put("LOG_DOARTICLE", "办文");
            put("LOG_SELECTDOARTICLE", "办文查询");
            put("LOG_MONITORANDREMINDER", "监控与催办");
            put("LOG_WORKCOMMISSION", "工作委托");
            put("LOG_UPDATEUSER", "修改个人信息");
            put("LOG_RECHARGE", "充值");
            put("LOG_CONSUMPTION", "消费");
            put("LOG_FINANCIALSTATEMENTSDOWN", "下载财务报表");
            put("LOG_ADDNOTICE", "公告发布");
            put("LOG_SELECTNOTICE", "公告查询");
            put("LOG_MATCHRELEASE", "手动匹配招商信息");
            put("LOG_SELECTLOGGER", "日志查询");
            put("LOG_UPDATEROADSHOW", "修改路演设备");
            put("LOG_ADDROADSHOW", "添加路演设备");
            put("LOG_UPDATESYSTEM", "修改系统参数");
            
           
        }
    };
    
    private static HashMap<String, Integer> map1 = new HashMap<String, Integer>() {
        {
            put("LEVEL_DEBUG", 1);//调试
            put("LEVEL_INFO", 2);//正常
            put("LEVEL_WARN", 3);//警告
            put("LEVEL_ERROR", 4);//错误
            put("LEVEL_FATAL", 5);//严重错误
           
        }
    };
    
    //生成日志的接口
    public void logger(HttpServletRequest request,String type,String level,Integer result,String remark){
        Logger log=new Logger();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()  
                .getAuthentication()  
                .getPrincipal();  
        UserUExample uue=new UserUExample();
        uue.createCriteria().andUnameEqualTo(userDetails.getUsername());
        UserU user=userUMapper.selectByExample(uue).get(0);
        
        log.setUid(user.getUid());
        String ip=getIpAddr(request);
        
        log.setIp(ip);
        if(result==0){
            log.setResult(0);
        }else if(result==1){
            log.setResult(1);
        }
        log.setTime(new Date());
        log.setType(map.get(type));
        log.setRemark(remark);
        log.setLevel(map1.get(level));
        
        loggerMapper.insertSelective(log);
        UserLoggerKey ulk=new UserLoggerKey();
        ulk.setUid(user.getUid());
        ulk.setLid(loggerMapper.insertLastId());
        userLoggerMapper.insertSelective(ulk);
    }
    //查询24小时内的日志
    public List<Logger> selectAllLogger(Integer thispage,Integer pagenumber) {
        // TODO Auto-generated method stub
        LoggerExample le=new LoggerExample();
        if(!(thispage==0 && pagenumber==0)){
           
            PageHelper.startPage(thispage,pagenumber);
        }
        
        le.createCriteria().andTimeBetween(new Date(new Date().getTime()-24*60*60*1000), new Date());
        return loggerMapper.selectByExample(le);
    }
  //查询7天内的日志
    public List<Logger> selectAllLogger2(Integer thispage,Integer pagenumber) {
        // TODO Auto-generated method stub
        LoggerExample le=new LoggerExample();
        
        if(!(thispage==0 && pagenumber==0)){
            PageHelper.startPage(thispage,pagenumber);
        }
        le.createCriteria().andTimeBetween(new Date(new Date().getTime()-7*24*60*60*1000), new Date());
        return loggerMapper.selectByExample(le);
    }
    
  //查询30天内的日志
    public List<Logger> selectAllLogger3(Integer thispage,Integer pagenumber) {
        // TODO Auto-generated method stub
        LoggerExample le=new LoggerExample();
        if(!(thispage==0 && pagenumber==0)){
            PageHelper.startPage(thispage,pagenumber);
        }
        le.createCriteria().andTimeBetween(new Date(new Date().getTime()-(long)30*24*60*60*1000), new Date());
        return loggerMapper.selectByExample(le);
    }
    
    
    public String getIpAddr(HttpServletRequest request) { 
        String ip = request.getHeader("x-forwarded-for"); 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getRemoteAddr(); 
        } 
        return ip; 
    }
  //查询所有的日志
    public List<Logger> selectAllLogger1(Integer thispage, Integer pagenumber) {
        // TODO Auto-generated method stub
         LoggerExample le=new LoggerExample();
                
         if(!(thispage==0 && pagenumber==0)){
             PageHelper.startPage(thispage,pagenumber);
         }
        return loggerMapper.selectByExample(le);
    }
    
    //根据条件进行查询
    public List<Logger> seachLogger(Logger logger, String time1, String time2, List<Integer> list1) throws ParseException {
        // TODO Auto-generated method stub
        LoggerExample le=new LoggerExample();  
        Criteria cr=le.createCriteria();
        if(time1!=null && !"".equals(time1)){
            cr.andTimeGreaterThanOrEqualTo(utils.stringtodate(time1));
        }
        if(time2!=null && !"".equals(time2)){
            cr.andTimeLessThanOrEqualTo(utils.stringtodate(time2));
        }
        
        if(logger.getType()!=null&&!"".equals(logger.getType())){
           
            cr.andTypeEqualTo(logger.getType());
        }
        if(logger.getIp()!=null&&!"".equals(logger.getIp())){
            cr.andIpLike("%"+logger.getIp()+"%");
        }
        if(logger.getResult()!=null&&!"".equals(logger.getResult())&&logger.getResult()!=2){
            cr.andResultEqualTo(logger.getResult());
        }
        if(logger.getRemark()!=null&&!"".equals(logger.getRemark())){
            cr.andRemarkLike("%"+logger.getRemark()+"%");
        }
        if(list1.size()!=0){
            cr.andUidIn(list1);
        }else{
            return new ArrayList<>();
        }
        
        return loggerMapper.selectByExample(le);
    }

}
