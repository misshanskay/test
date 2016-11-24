package cn.sirbox.service.impl;


import cn.sirbox.dao.EnterpriseMapper;
import cn.sirbox.dao.UserEnterpriseMapper;
import cn.sirbox.dao.UserUMapper;
import cn.sirbox.model.Enterprise;
import cn.sirbox.model.EnterpriseExample;
import cn.sirbox.model.UserEnterpriseExample;
import cn.sirbox.model.UserEnterpriseKey;
import cn.sirbox.model.UserU;
import cn.sirbox.model.UserUExample;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by X201 on 2016/9/1 0001.
 */
@Service
public class myUserDetailsService implements UserDetailsService{
    @Resource
    private UserUMapper userUMapper;
    
    @Resource
    private UserEnterpriseMapper userEnterpriseMapper;
    @Resource
    private EnterpriseMapper enterpriseMapper;
    
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {
    	try {
			String uname= new String(s.getBytes("ISO-8859-1"),"UTF-8");
			String[] str1 = uname.split(",");
			
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
	        if("government".equals(str1[1])==true){
	        	/*List<String>  role=roleMapper.getRoleByName(name);
	            System.out.println(role.get(1));*/
	           // System.out.println(str1[0]);
	           UserUExample e = new UserUExample();
	            e.createCriteria().andUnameEqualTo(str1[0]).andStatusEqualTo("government");
	            List<UserU> userU=userUMapper.selectByExample(e);
	           
	            if(userU.size()==0){
	            	return null;
	            	
	            }
	            authList.add(new GrantedAuthorityImpl("ROLE_USER"));
	            
	            UserDetails user = new User(userU.get(0).getUname(),userU.get(0).getUpassword(),true,true,true,true,authList);
	            //UserDetails user = new User("admin","123",true,true,true,true,authList);
	            return user;
	        }else if("enterprise".equals(str1[1])==true){
	            UserUExample e = new UserUExample();
                e.createCriteria().andUnameEqualTo(str1[0]).andStatusEqualTo("enterprise");
                List<UserU> userU=userUMapper.selectByExample(e);
               
                if(userU.size()==0){
                    return null;
                    
                }
                UserEnterpriseExample uee=new UserEnterpriseExample();
                uee.createCriteria().andEidEqualTo(userU.get(0).getUid());
                UserEnterpriseKey uek=userEnterpriseMapper.selectByExample(uee).get(0);
                EnterpriseExample ee=new EnterpriseExample();
                ee.createCriteria().andEidEqualTo(uek.getEid());
                Enterprise enterprise=enterpriseMapper.selectByExample(ee).get(0);
                if(enterprise.getEstatus()!=2){
                    return null;
                }
                authList.add(new GrantedAuthorityImpl("ROLE_USER"));
                
                UserDetails user = new User(userU.get(0).getUname(),userU.get(0).getUpassword(),true,true,true,true,authList);
                //UserDetails user = new User("admin","123",true,true,true,true,authList);
                return user;
	        }else{
	            return null;
	        }
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	
    	
        
    }
}
