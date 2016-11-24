package cn.sirbox.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.sirbox.dao.PartMapper;
import cn.sirbox.dao.UserDeptMapper;
import cn.sirbox.dao.UserExtendMapper;
import cn.sirbox.dao.UserPartMapper;
import cn.sirbox.dao.UserUMapper;
import cn.sirbox.model.UserDeptExample;
import cn.sirbox.model.UserDeptKey;
import cn.sirbox.model.UserExtend;
import cn.sirbox.model.UserExtendExample;
import cn.sirbox.model.UserPartExample;
import cn.sirbox.model.UserPartKey;
import cn.sirbox.model.UserU;
import cn.sirbox.model.UserUExample;
import cn.sirbox.model.UserUExample.Criteria;
import cn.sirbox.utils.utils;


/**
 * Created by X201 on 2016/8/26 0026.
 */
@Service
public class UserUService {

    @Autowired
    private UserUMapper userUMapper;
    
    @Autowired
    private UserDeptMapper userDeptMapper;

    @Autowired
    private UserExtendMapper userExtendMapper;
    
    @Autowired
    private UserPartMapper userPartMapper;
    
    @Autowired
    private PartMapper partMapper;
    
   public UserU getUserUById(Integer uid){

       UserUExample e = new UserUExample();
       e.createCriteria().andUidEqualTo(uid).andEnabledEqualTo(1);
        return userUMapper.selectByExample(e).get(0);
    }

    public UserU getUserUByName(String uname) {
        UserUExample e = new UserUExample();
        e.createCriteria().andUnameEqualTo(uname);
        List<UserU> user=userUMapper.selectByExample(e);
        if(user.size()!=0){
            return user.get(0);
        }
        return null;
    }
    public UserU insertSelective(UserU userU){
        userU.setEnabled(1);
        userU.setStatus("government");
        userU.setCreatetime(new Date());
        userU.setUpdatetime(new Date());
        userU.setUpassword(utils.string2MD5(userU.getUpassword()));
        userUMapper.insertSelective(userU);
        int uid=userUMapper.insertLastId();
         userU.setUid(uid);
        userU.getUserExtend().setUid(uid);
        userExtendMapper.insertSelective(userU.getUserExtend());
        
       userU.setUid(uid);
        return userU;
       
    }
    
    public void insertDept(UserU userU1) {
        // TODO Auto-generated method stub
        userU1.getUserDeptKey().setUid(userU1.getUid());
        userDeptMapper.insertSelective(userU1.getUserDeptKey());
    }
   
    public List<UserU> selectAllUserU(Integer thispage,Integer pagenumber) {
        UserUExample ue=new UserUExample();
        PageHelper.startPage(thispage,pagenumber);
        ue.createCriteria().andEnabledEqualTo(1).andStatusEqualTo("government");
        
        return userUMapper.selectByExample(ue);
       
    }
    public void deleteUserUById(Integer uid) {
        UserUExample ue=new UserUExample();
        ue.createCriteria().andUidEqualTo(uid);
        UserU user=getUserUById(uid);
        user.setEnabled(0);
        user.setUpdatetime(new Date());
       userUMapper.updateByExample(user, ue);
    }

    public Integer countByExample() {
        // TODO Auto-generated method stub
        UserUExample ue=new UserUExample();
        ue.createCriteria().andStatusEqualTo("government").andEnabledEqualTo(1);
        return userUMapper.countByExample(ue);
    }
    public List<UserU> getAllUserUGovernment() {
        // TODO Auto-generated method stub
        UserUExample e = new UserUExample();
        e.createCriteria().andStatusEqualTo("government").andEnabledEqualTo(1);
        
        return userUMapper.selectByExample(e);
    }
    public List<UserDeptKey> getUidByDid(Integer did) {
        // TODO Auto-generated method stub
        UserDeptExample ud=new UserDeptExample();
        ud.createCriteria().andDidEqualTo(did);
        return userDeptMapper.selectByExample(ud);
    }

    public UserExtend getUserExtend(Integer uid) {
        // TODO Auto-generated method stub
        UserExtendExample ue=new UserExtendExample();
        ue.createCriteria().andUidEqualTo(uid);
        return userExtendMapper.selectByExample(ue).get(0);
    }

    public void updateByPrimaryKeySelective(UserU user) {
        // TODO Auto-generated method stub
        user.setUpdatetime(new Date());
        userUMapper.updateByPrimaryKeySelective(user);
    }

    public UserDeptKey getUserUserDeptKey(Integer uid) {
        // TODO Auto-generated method stub
        UserDeptExample ud=new UserDeptExample();
        ud.createCriteria().andUidEqualTo(uid);
        return userDeptMapper.selectByExample(ud).get(0);
    }

    public List<UserPartKey> getUserPartKey(Integer uid) {
        // TODO Auto-generated method stub
        UserPartExample upe=new UserPartExample();
        upe.createCriteria().andUidEqualTo(uid);
        return userPartMapper.selectByExample(upe);
    }

    public void updateUserUImg(UserExtend userU) {
        // TODO Auto-generated method stub
        UserU u=getUserUById(userU.getUid());
        u.setUpdatetime(new Date());
        userUMapper.updateByPrimaryKeySelective(u);
        UserExtendExample ue=new UserExtendExample();
        ue.createCriteria().andUidEqualTo(userU.getUid());
        userExtendMapper.updateByExampleSelective(userU, ue);
    }

    public void updateSelective(UserU userU) {
        // TODO Auto-generated method stub
        if("".equals(userU.getUpassword())){
            userU.setUpassword(null);
        }
        if(userU.getUpassword()!=null){
            userU.setUpassword(utils.string2MD5(userU.getUpassword()));
        }
        userU.setUpdatetime(new Date());
        userUMapper.updateByPrimaryKeySelective(userU);
        //存用户扩展信息
        UserExtendExample uu=new UserExtendExample();
        uu.createCriteria().andUidEqualTo(userU.getUid());
        UserExtend uuu=userExtendMapper.selectByExample(uu).get(0);
        userU.getUserExtend().setId(uuu.getId());
        userU.getUserExtend().setUid(userU.getUid());
        userExtendMapper.updateByPrimaryKeySelective(userU.getUserExtend());
        //存用户和部门信息
        userU.getUserDeptKey().setUid(userU.getUid());
        UserDeptExample ue=new UserDeptExample();
        ue.createCriteria().andUidEqualTo(userU.getUid());
        userDeptMapper.updateByExampleSelective(userU.getUserDeptKey(), ue);
    }

    public void updateDeptById(Integer uu, Integer did) {
        // TODO Auto-generated method stub
        UserU u=getUserUById(uu);
        u.setUpdatetime(new Date());
        userUMapper.updateByPrimaryKeySelective(u);
        UserDeptKey uk=new UserDeptKey();
        uk.setDid(did);
        uk.setUid(uu);
        UserDeptExample ue=new UserDeptExample();
        ue.createCriteria().andUidEqualTo(uu);
        userDeptMapper.updateByExampleSelective(uk, ue);
    }

    public UserU getUserUById1(Integer uid) {
        UserUExample e = new UserUExample();
        e.createCriteria().andUidEqualTo(uid);
         return userUMapper.selectByExample(e).get(0);
    }

    public void startUserUById(Integer uid) {
        // TODO Auto-generated method stub
        UserUExample ue=new UserUExample();
        ue.createCriteria().andUidEqualTo(uid);
        UserU user=new UserU();
        user.setUid(uid);
        user.setEnabled(1);
        user.setUpdatetime(new Date());
       userUMapper.updateByExampleSelective(user, ue);
    }

    public List<UserU> getAllUserUname(UserU user) {
        // TODO Auto-generated method stub
        UserUExample ue=new UserUExample();
        Criteria ue1=ue.createCriteria();
        if(user.getStatus()!=null&&!"".equals(user.getStatus())){
            ue1.andStatusEqualTo(user.getStatus());
        }
        if(user.getUname()!=null&&!"".equals(user.getUname())){
            ue1.andUnameLike("%"+user.getUname()+"%");
        }
        
        return userUMapper.selectByExample(ue);
    }
    
    public List<UserU> getAllUserUname1(UserU user) {
        // TODO Auto-generated method stub
        UserUExample ue=new UserUExample();
        
            ue.createCriteria().andUnameLike("%"+user.getUname()+"%");
        
        PageHelper.startPage(0,5);
        
        return userUMapper.selectByExample(ue);
    }

    public void sss() {
        // TODO Auto-generated method stub
        UserUExample u=new UserUExample();
        u.createCriteria().andUidEqualTo(1);
        u.createCriteria().andUnameEqualTo("add");
        u.createCriteria().andCreatetimeEqualTo(new Date());
        userUMapper.selectByExample(u);
    }

    //获取当前用户的信息
    public UserU getUserUByRequest(HttpServletRequest request){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()  
                .getAuthentication()  
                .getPrincipal();  
        UserUExample uue=new UserUExample();
        uue.createCriteria().andUnameEqualTo(userDetails.getUsername());
        return userUMapper.selectByExample(uue).get(0);
        
    }

    public List<UserU> getUserByList(List<Integer> d, Integer thispage, Integer pagenumber) {
        // TODO Auto-generated method stub
        PageHelper.startPage(thispage,pagenumber);
        UserUExample uue=new UserUExample();
        uue.createCriteria().andUidIn(d).andEnabledEqualTo(1);
        return userUMapper.selectByExample(uue);
    }

    public int getCount(List<Integer> d) {
        // TODO Auto-generated method stub
        UserUExample uue=new UserUExample();
        uue.createCriteria().andUidIn(d).andEnabledEqualTo(1);
        return userUMapper.countByExample(uue);
    }
    

   
   

   

   
}
