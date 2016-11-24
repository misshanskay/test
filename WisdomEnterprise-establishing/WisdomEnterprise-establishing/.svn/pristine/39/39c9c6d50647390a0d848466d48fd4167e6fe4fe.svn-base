package cn.sirbox.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by X201 on 2016/9/2 0002.
 */
public class LoginUrlEntryPoint implements AuthenticationEntryPoint {
    
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        String targetUrl = null;
        String url = request.getRequestURI();

        if(url.indexOf("admin") != -1){
            //未登录而访问后台受控资源时，跳转到后台登录页面
            targetUrl = "/admin/login.jsp";
        }else{
            //未登录而访问前台受控资源时，跳转到前台登录页面
            targetUrl = "/login.jsp";
        }

        targetUrl = request.getContextPath() + targetUrl;
        response.sendRedirect(targetUrl);
    }
}
