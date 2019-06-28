package com.cssl.web;

import com.cssl.pojo.Users;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

public class MyListen implements ServletContextListener,HttpSessionListener {
    private ServletContext application;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //创建session
        System.out.println("创建session");
        HttpSession session = se.getSession();
        System.out.println("sessionid"+session.getId());
        //设置时间
        session.setMaxInactiveInterval(1);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //判断销毁的是哪一个session
        HttpSession session = se.getSession();
        System.out.println("销毁");
        System.out.println(session.getId()+"销毁的id");
        Users us =(Users)session.getAttribute("user");
        List<Users> list =( List<Users>)application.getAttribute("users");
        if(list.contains(us)){

            list.remove(us);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application初始化");
        application = sce.getServletContext();
        //保存所有在线用户
        application.setAttribute("users", new ArrayList<Users>());
    }
}
