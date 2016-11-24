package cn.sirbox.service.impl;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.sirbox.dao.UorderMapper;
import cn.sirbox.dao.UserUMapper;
import cn.sirbox.model.Uorder;
import cn.sirbox.model.UorderExample;
import cn.sirbox.model.UorderExample.Criteria;
import cn.sirbox.model.UserU;
import cn.sirbox.model.UserUExample;
import cn.sirbox.utils.utils;

@Service
public class UorderService {

    @Autowired
    private UorderMapper uorderMapper;

    
    @Autowired
    private UserUMapper userUMapper;
    private static HashMap<String, String> map = new HashMap<String, String>() {
        {
        
            put("ORDER_RELEASE", "项目信息");
           
            
           
        }
    };
    //查询所有订单
    public List<Uorder> selectAllOrder(Integer thispage, Integer pagenumber) {
        // TODO Auto-generated method stub
        UorderExample oe=new UorderExample();
        PageHelper.startPage(thispage,pagenumber);
        return uorderMapper.selectByExample(oe);
    }
    //查询未付款订单
    public List<Uorder> selectAllOrder1(Integer thispage, Integer pagenumber) {
        // TODO Auto-generated method stub
        UorderExample oe=new UorderExample();
        oe.createCriteria().andStatusEqualTo(0);
        PageHelper.startPage(thispage,pagenumber);
        return uorderMapper.selectByExample(oe);
    }
    //查询今日订单
    public List<Uorder> selectAllOrder2(Integer thispage, Integer pagenumber) {
        // TODO Auto-generated method stub
        UorderExample oe=new UorderExample();
        oe.createCriteria().andUpdatetimeBetween(new Date(getDayBeginTimestamp()), new Date());
        PageHelper.startPage(thispage,pagenumber);
        return uorderMapper.selectByExample(oe);
    }
    //添加一个订单，状态为未支付mid是项目id，money是金额，type是类型（具体看上面的map）
    public void insertOrder(Integer mid,Integer money,String type,HttpServletRequest request){
        Uorder uorder=new Uorder();
        uorder.setMid(mid);
        uorder.setMoney(money);
        uorder.setType(map.get(type));
        uorder.setOrderid("P"+new Date().getTime());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()  
                .getAuthentication()  
                .getPrincipal();  
        UserUExample uue=new UserUExample();
        uue.createCriteria().andUnameEqualTo(userDetails.getUsername());
        UserU user=userUMapper.selectByExample(uue).get(0);
        uorder.setUid(user.getUid());
        uorder.setCreatetime(new Date());
        uorder.setUpdatetime(new Date());
        uorder.setStatus(0);
        uorderMapper.insertSelective(uorder);
    }
    //修改订单的状态
    public void updateOrder(Integer oid){
        Uorder uorder=new Uorder();
        uorder.setOid(oid);
        uorder.setStatus(1);
        uorderMapper.updateByPrimaryKeySelective(uorder);
    }
    
  //修改订单的状态
    public Uorder getUorderByMid(Integer mid){
        UorderExample ue=new UorderExample();
        ue.createCriteria().andMidEqualTo(mid);
        return uorderMapper.selectByExample(ue).get(0);
    }
    
    //获取当天时间0点的时间戳
    public Long getDayBeginTimestamp() {
        Date date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        Date date2 = new Date(date.getTime() - gc.get(gc.HOUR_OF_DAY) * 60 * 60
          * 1000 - gc.get(gc.MINUTE) * 60 * 1000 - gc.get(gc.SECOND)
          * 1000);
        return date2.getTime();
       }
    
    //根据条件查询订单
    public List<Uorder> seachorder(Uorder uorder, Integer money1, Integer money2, List<Integer> list1) {
        // TODO Auto-generated method stub
       UorderExample ue=new UorderExample();
       Criteria ue1=ue.createCriteria();
        if(uorder.getOrderid()!=null && !"".equals(uorder.getOrderid())){
            ue1.andOrderidLike("%"+uorder.getOrderid()+"%");
        }
        if(uorder.getType()!=null && !"".equals(uorder.getType())){
            ue1.andTypeEqualTo(uorder.getType());
        }
        if(list1.size()!=0){
            ue1.andUidIn(list1);
        }
        if(money1!=null && !"".equals(money1)){
            
            ue1.andMoneyGreaterThanOrEqualTo(money1);
        }
        if(money2!=null && !"".equals(money2)){
            ue1.andMoneyLessThanOrEqualTo(money2);
        }
        if(uorder.getStatus()!=null&&!"".equals(uorder.getStatus())){
            ue1.andStatusEqualTo(uorder.getStatus());
        }
        return uorderMapper.selectByExample(ue);
    }

}
