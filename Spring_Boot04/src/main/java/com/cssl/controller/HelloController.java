package com.cssl.controller;

import com.cssl.pojo.NewsDetail;
import com.cssl.pojo.Student;
import com.cssl.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private StuService ss;

    @GetMapping("/hello")
    public String hello(Model model, HttpSession session){
       List<Student> list= ss.selectAll();//查询全部信息
        NewsDetail n = new NewsDetail();
        n.setId(3);
        n.setTitle("sytle渲染存入session中的数据");
        model.addAttribute("list",list);//将查询到的信息存放到model中
        model.addAttribute("name", "欢迎admin进行模板渲染");
        session.setAttribute("nd",n);
       return "hello";//跳转去hello页面
    }
}
