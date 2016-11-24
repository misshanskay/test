package cn.sirbox.service.impl;

import cn.sirbox.dao.UserUMapper;
import cn.sirbox.model.UserU;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        String name=s.substring(0, s.indexOf(","));
        String u=s.substring(s.indexOf(",")+1,s.length());
        UserU userU=userUMapper.getUserUByName(name);
        List<String>  role=roleMapper.getRoleByName(name);
        System.out.println(role.get(1));
        authList.add(new GrantedAuthorityImpl("ROLE_USER"));
        UserDetails user = new User(userU.getUname(),userU.getUpassword(),true,true,true,true,authList);
        return user;
    }
}
