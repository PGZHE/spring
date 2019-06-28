package com.cssl.intercepter;

import com.cssl.pojo.Users;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class myIntercepter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.print("拦截前");
        String url=String.valueOf(request.getRequestURI());

        HttpSession session=request.getSession();
        Users users=(Users) session.getAttribute("user");
        if (users==null){
            System.out.print("去登陆界面");
            response.sendRedirect("login.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("拦截后");
    }

}
