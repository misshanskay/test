package cn.sirbox.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.sirbox.dao.AreaMapper;
import cn.sirbox.dao.CityMapper;
import cn.sirbox.dao.EnterpriseMapper;
import cn.sirbox.dao.ProvinceMapper;
import cn.sirbox.dao.UserEnterpriseMapper;
import cn.sirbox.dao.UserExtendMapper;
import cn.sirbox.dao.UserUMapper;
import cn.sirbox.model.Area;
import cn.sirbox.model.AreaExample;
import cn.sirbox.model.City;
import cn.sirbox.model.CityExample;
import cn.sirbox.model.Enterprise;
import cn.sirbox.model.EnterpriseExample;
import cn.sirbox.model.EnterpriseExample.Criteria;
import cn.sirbox.model.Province;
import cn.sirbox.model.ProvinceExample;
import cn.sirbox.model.UserEnterpriseExample;
import cn.sirbox.model.UserEnterpriseKey;
import cn.sirbox.model.UserExtend;
import cn.sirbox.model.UserU;
import cn.sirbox.model.UserUExample;
import cn.sirbox.utils.utils;

@Service
public class EnterpriseService {

	@Autowired
	private EnterpriseMapper enterpriseMapper;
	
	@Autowired
    private UserUMapper userUMapper;
	
	@Autowired
    private UserEnterpriseMapper userEnterpriseMapper;
	
	@Autowired
    private UserExtendMapper userExtendMapper;
	
	@Autowired
    private ProvinceMapper provinceMapper;
	
	@Autowired
    private CityMapper cityMapper;
	
	@Autowired
    private AreaMapper areaMapper;
	
	public Integer countByExample() {
		// TODO Auto-generated method stub
		return enterpriseMapper.countByExample(new EnterpriseExample());
	}

	

    public void insertSelective(UserU userU, Enterprise enterprise) {
        // TODO Auto-generated method stub
        //添加用户和企业
        userU.setEnabled(1);
        userU.setStatus("enterprise");
        userU.setCreatetime(new Date());
        userU.setUpdatetime(new Date());
        userU.setUpassword(utils.string2MD5(userU.getUpassword()));
        userUMapper.insertSelective(userU);
        int uid=userUMapper.insertLastId();
        //添加用户扩展表
        UserExtend ue=new UserExtend();
        ue.setUid(uid);
        userExtendMapper.insertSelective(ue);
        enterprise.setEnabled(1);
        enterprise.setCreatetime(new Date());
        enterprise.setUpdatetime(new Date());
        enterpriseMapper.insertSelective(enterprise);
        int eid=enterpriseMapper.insertLastId();
        
        //为用户和企业关联表添加数据
        UserEnterpriseKey uep=new UserEnterpriseKey();
        uep.setEid(eid);
        uep.setUid(uid);
        userEnterpriseMapper.insertSelective(uep);
       
    }

    public Enterprise getEnterpriseById(Integer eid) {
        // TODO Auto-generated method stub
        EnterpriseExample ee=new EnterpriseExample();
        ee.createCriteria().andEidEqualTo(eid).andEnabledEqualTo(1);
        return enterpriseMapper.selectByExample(ee).get(0);
    }
    
    public void updateStatusById(Integer eid, Integer estatus) {
        // TODO Auto-generated method stub
        //enterpriseMapper.updateStatusById(eid,estatus);
        EnterpriseExample ee=new EnterpriseExample();
        ee.createCriteria().andEidEqualTo(eid).andEnabledEqualTo(1);
        Enterprise enterprise=new Enterprise();
        enterprise.setEid(eid);
        enterprise.setEstatus(estatus);
        enterprise.setUpdatetime(new Date());
       enterpriseMapper.updateByExampleSelective(enterprise, ee);
       
    }
    
    public void updateStatus(Enterprise enterprise){
        EnterpriseExample ee=new EnterpriseExample();
        ee.createCriteria().andEidEqualTo(enterprise.getEid()).andEnabledEqualTo(1);
        enterprise.setUpdatetime(new Date());
       enterpriseMapper.updateByExampleSelective(enterprise, ee);
    }
	

    public void updateByPrimaryKeySelective(Enterprise enterprise) {
        // TODO Auto-generated method stub
        enterprise.setEstatus(1);
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
    }
    
    public List<UserEnterpriseKey> getUserEnterprise(Integer eid) {
        // TODO Auto-generated method stub
        UserEnterpriseExample uee=new UserEnterpriseExample();
        uee.createCriteria().andEidEqualTo(eid);
        return userEnterpriseMapper.selectByExample(uee);
    }

    public List<Province> getProvince() {
        // TODO Auto-generated method stub
        ProvinceExample pe=new ProvinceExample();
        
        return provinceMapper.selectByExample(pe);
    }

    public List<City> getCity(String name) {
        // TODO Auto-generated method stub
        ProvinceExample pe=new ProvinceExample();
        pe.createCriteria().andNameEqualTo(name);
        CityExample ce=new CityExample();
        ce.createCriteria().andProvincecodeEqualTo(provinceMapper.selectByExample(pe).get(0).getCode());
        return cityMapper.selectByExample(ce);
    }

    public List<Area> getArea(String name) {
        // TODO Auto-generated method stub
        CityExample ce=new CityExample();
        ce.createCriteria().andNameEqualTo(name);
        AreaExample ae=new AreaExample();
        ae.createCriteria().andCitycodeEqualTo(cityMapper.selectByExample(ce).get(0).getCode());
        return areaMapper.selectByExample(ae);
    }

   
    public void updateImg(Enterprise enterprise) {
        // TODO Auto-generated method stub
        EnterpriseExample ee=new EnterpriseExample();
        ee.createCriteria().andEidEqualTo(enterprise.getEid()).andEnabledEqualTo(1);
        enterprise.setUpdatetime(new Date());
        enterpriseMapper.updateByExampleSelective(enterprise, ee);
    }

    public void dele(Enterprise enterprise) {
        // TODO Auto-generated method stub
        //把企业状态设为禁用
        enterprise.setEnabled(0);
        enterprise.setUpdatetime(new Date());
        enterpriseMapper.updateByPrimaryKeySelective(enterprise);
        
        //获取这个企业的用户，把这些用户的状态也设为禁用
        UserEnterpriseExample ue=new UserEnterpriseExample();
        ue.createCriteria().andEidEqualTo(enterprise.getEid());
        List<UserEnterpriseKey> list=userEnterpriseMapper.selectByExample(ue);
        for(int i=0;i<list.size();i++){
            UserU user=userUMapper.selectByPrimaryKey(list.get(i).getUid());
            user.setEnabled(0);
            user.setUpdatetime(new Date());
            userUMapper.updateByPrimaryKeySelective(user);
        }
    }

    public List<Enterprise> selectAllEnterprise(Integer thispage, int pagenumber) {
        // TODO Auto-generated method stub
        EnterpriseExample ee=new EnterpriseExample();
        
        ee.createCriteria().andEnabledEqualTo(1);
        PageHelper.startPage(thispage,pagenumber);
        return enterpriseMapper.selectByExample(ee);
    }



    public List<Enterprise> searchenterprise(Integer thispage,Enterprise enterprise, String amount1, String amount2,Integer pagenumber) {
        // TODO Auto-generated method stub
        EnterpriseExample ee=new EnterpriseExample();
        PageHelper.startPage(thispage, pagenumber);
        Criteria ee1=ee.createCriteria();
        if(enterprise.getEname()!=null&&!"".equals(enterprise.getEname())){
            ee1.andEnameLike("%"+enterprise.getEname()+"%");
        }
        if(enterprise.getEbusines()!=null&&!"".equals(enterprise.getEbusines())){
            ee1.andEbusinesLike("%"+enterprise.getEbusines()+"%");
        }
        if(enterprise.getEte()!=null&&!"".equals(enterprise.getEte())){
            ee1.andEteLike(enterprise.getEte());
        }
        if(enterprise.getEaddress()!=null && !enterprise.getEaddress().equals("---")){
            ee1.andEaddressLike("%"+enterprise.getEaddress()+"%");
        }
        if(amount1!=null&&!"".equals(amount1)){
            ee1.andEamountGreaterThanOrEqualTo(Float.parseFloat(amount1));
        }
        if(amount2==null&&!"".equals(amount2)){
            ee1.andEamountLessThanOrEqualTo(Float.parseFloat(amount2));
        }
        if(enterprise.getEintention()!=null&&!"".equals(enterprise.getEintention())){
            ee1.andEintentionLike("%"+enterprise.getEintention()+"%");
        }
        
        if(enterprise.getEtype()!=null&&!"".equals(enterprise.getEtype())){
            ee1.andEtypeLike("%"+enterprise.getEtype()+"%");
        }
        if(enterprise.getEfinancingbegin()!=null&&!"".equals(enterprise.getEfinancingbegin())){
            ee1.andEfinancingbeginGreaterThanOrEqualTo(enterprise.getEfinancingbegin());
        }
        if(enterprise.getEfinancingout()!=null&&!"".equals(enterprise.getEfinancingout())){
            ee1.andEfinancingoutLessThanOrEqualTo(enterprise.getEfinancingout());
        }
        if(enterprise.getEcontacts()!=null&&!"".equals(enterprise.getEcontacts())){
            ee1.andEcontactsLike("%"+enterprise.getEcontacts()+"%");
        }
        if(enterprise.getEphone()!=null&&!"".equals(enterprise.getEphone())){
            ee1.andEphoneLike("%"+enterprise.getEphone()+"%");
        }
        if(enterprise.getEemail()!=null&&!"".equals(enterprise.getEemail())){
            ee1.andEemailLike("%"+enterprise.getEemail()+"%");
        }
        ee1.andEnabledEqualTo(1);
        
        return enterpriseMapper.selectByExample(ee);
    }


    //统计每月的注册数
    public List<String> getCountInsert1(Integer year, Integer month,Integer month1) {
        // TODO Auto-generated method stub
        
       
        List<String> list=new ArrayList<>();
        list.add("注册");
        
        for(int i=0;i<month;i++){
            
            GregorianCalendar gc1 = new GregorianCalendar(year,month1,1,00,00,00);
            GregorianCalendar gc2=null;
            if(month1==11){
                
                gc2 = new GregorianCalendar(year+1,0,1,00,00,00);
            }else{
                
                gc2 = new GregorianCalendar(year,month1+1,1,00,00,00);
            }
            EnterpriseExample ee=new EnterpriseExample();
            ee.createCriteria().andCreatetimeBetween(gc1.getTime(), gc2.getTime());
            list.add(String.valueOf(enterpriseMapper.countByExample(ee)));
            month1++;
            if(month1==12){
                month1=0;
                year=year+1;
            }
        }
        return list;
    }


//统计注册通过的
    public List<String> getCountInsert2(Integer year, Integer month,Integer month1) {
        // TODO Auto-generated method stub
        List<String> list=new ArrayList<>();
        list.add("审核通过");
        for(int i=0;i<month;i++){
            
            GregorianCalendar gc1 = new GregorianCalendar(year,month1,1,00,00,00);
            GregorianCalendar gc2=null;
            if(month1==11){
                
                gc2 = new GregorianCalendar(year+1,0,1,00,00,00);
            }else{
                
                gc2 = new GregorianCalendar(year,month1+1,1,00,00,00);
            }
            EnterpriseExample ee=new EnterpriseExample();
            ee.createCriteria().andCreatetimeBetween(gc1.getTime(), gc2.getTime()).andEstatusEqualTo(2);
            list.add(String.valueOf(enterpriseMapper.countByExample(ee)));
            month1++;
            if(month1==12){
                month1=0;
                year=year+1;
            }
        }
        
        return list;
    }

  //统计注册未通过的
    public List<String> getCountInsert3(Integer year, Integer month,Integer month1) {
        // TODO Auto-generated method stub
        List<String> list=new ArrayList<>();
        
        list.add("审核未通过");
        
        for(int i=0;i<month;i++){
            
            GregorianCalendar gc1 = new GregorianCalendar(year,month1,1,00,00,00);
            GregorianCalendar gc2=null;
            if(month1==11){
                
                gc2 = new GregorianCalendar(year+1,0,1,00,00,00);
            }else{
                
                gc2 = new GregorianCalendar(year,month1+1,1,00,00,00);
            }
            EnterpriseExample ee=new EnterpriseExample();
            ee.createCriteria().andCreatetimeBetween(gc1.getTime(), gc2.getTime()).andEstatusEqualTo(3);
            list.add(String.valueOf(enterpriseMapper.countByExample(ee)));
            month1++;
            if(month1==12){
                month1=0;
                year=year+1;
            }
        }
        return list;
    }
    
    
    public List<String> getCountInsert4(Integer year, Integer month,Integer month1) {
        // TODO Auto-generated method stub
        List<String> list=new ArrayList<>();
       
        list.add("找资金");
        
        for(int i=0;i<month;i++){
            
            GregorianCalendar gc1 = new GregorianCalendar(year,month1,1,00,00,00);
            GregorianCalendar gc2=null;
            if(month1==11){
                
                gc2 = new GregorianCalendar(year+1,0,1,00,00,00);
            }else{
                
                gc2 = new GregorianCalendar(year,month1+1,1,00,00,00);
            }
            EnterpriseExample ee=new EnterpriseExample();
            ee.createCriteria().andCreatetimeBetween(gc1.getTime(), gc2.getTime()).andEintentionEqualTo("找资金");
            list.add(String.valueOf(enterpriseMapper.countByExample(ee)));
            month1++;
            if(month1==12){
                month1=0;
                year=year+1;
            }
        }
        return list;
    }
    
    
    
    public List<String> getCountInsert5(Integer year, Integer month,Integer month1) {
        // TODO Auto-generated method stub
        List<String> list=new ArrayList<>();
        list.add("找项目");
        
        for(int i=0;i<month;i++){
            
            GregorianCalendar gc1 = new GregorianCalendar(year,month1,1,00,00,00);
            GregorianCalendar gc2=null;
            if(month1==11){
                
                gc2 = new GregorianCalendar(year+1,0,1,00,00,00);
            }else{
                
                gc2 = new GregorianCalendar(year,month1+1,1,00,00,00);
            }
            EnterpriseExample ee=new EnterpriseExample();
            ee.createCriteria().andCreatetimeBetween(gc1.getTime(), gc2.getTime()).andEintentionEqualTo("找项目");
            list.add(String.valueOf(enterpriseMapper.countByExample(ee)));
            month1++;
            if(month1==12){
                month1=0;
                year=year+1;
            }
        }
        return list;
    }
    
    
    public List<String> getCountInsert6(Integer year, Integer month,Integer month1) {
        // TODO Auto-generated method stub
        List<String> list=new ArrayList<>();
        list.add("找技术");
        
        for(int i=0;i<month;i++){
            
            GregorianCalendar gc1 = new GregorianCalendar(year,month1,1,00,00,00);
            GregorianCalendar gc2=null;
            if(month1==11){
                
                gc2 = new GregorianCalendar(year+1,0,1,00,00,00);
            }else{
                
                gc2 = new GregorianCalendar(year,month1+1,1,00,00,00);
            }
            EnterpriseExample ee=new EnterpriseExample();
            ee.createCriteria().andCreatetimeBetween(gc1.getTime(), gc2.getTime()).andEintentionEqualTo("找技术");
            list.add(String.valueOf(enterpriseMapper.countByExample(ee)));
            month1++;
            if(month1==12){
                month1=0;
                year=year+1;
            }
        }
        return list;
    }



    public List<Enterprise> getAllEnterprise() {
        // TODO Auto-generated method stub
        EnterpriseExample ee=new EnterpriseExample();
        ee.createCriteria().andEnabledEqualTo(1);
        return enterpriseMapper.selectByExample(ee);
    }
    //通过request查询当前登录用户所在企业的信息
    public Enterprise getEnterpriseByRequest(HttpServletRequest request){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()  
                .getAuthentication()  
                .getPrincipal();  
        UserUExample uue=new UserUExample();
        uue.createCriteria().andUnameEqualTo(userDetails.getUsername());
        UserU user=userUMapper.selectByExample(uue).get(0);
        UserEnterpriseExample uee=new UserEnterpriseExample();
        uee.createCriteria().andUidEqualTo(user.getUid());
        UserEnterpriseKey uek=userEnterpriseMapper.selectByExample(uee).get(0);
        return getEnterpriseById(uek.getEid());
    }
    //查询所有企业的信息，包括其中用户的信息，但用户的扩展信息没存
    public List<Enterprise> getEnterpriseAndUserU(){
        EnterpriseExample ee=new EnterpriseExample();
        List<Enterprise> list=enterpriseMapper.selectByExample(ee);
        for(int i=0;i<list.size();i++){
            UserEnterpriseExample uee=new UserEnterpriseExample();
            uee.createCriteria().andEidEqualTo(list.get(i).getEid());
            List<UserEnterpriseKey> uek=userEnterpriseMapper.selectByExample(uee);
            List<UserU> userU=new ArrayList<>();
            for(int j=0;j<uek.size();j++){
                UserUExample uue=new UserUExample();
                uue.createCriteria().andUidEqualTo(uek.get(j).getUid());
                
                userU.add(userUMapper.selectByExample(uue).get(0));
            }
            list.get(i).setUserU(userU);
        }
        return list;
    }
    //根据用户的name获取其所在企业的信息
    public Enterprise getEnterpriseByUname(String uname){
        UserUExample uue=new UserUExample();
        uue.createCriteria().andUnameEqualTo(uname);
        UserU user=userUMapper.selectByExample(uue).get(0);
        UserEnterpriseExample uee=new UserEnterpriseExample();
        uee.createCriteria().andEidEqualTo(user.getUid());
        UserEnterpriseKey uek=userEnterpriseMapper.selectByExample(uee).get(0);
        EnterpriseExample ee=new EnterpriseExample();
        ee.createCriteria().andEidEqualTo(uek.getEid());
        return enterpriseMapper.selectByExample(ee).get(0);
    }

}
