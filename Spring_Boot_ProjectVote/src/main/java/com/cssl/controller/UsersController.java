package com.cssl.controller;

import com.cssl.pojo.Users;
import com.cssl.serviceImpl.UsersServiceImpl;
import com.cssl.vo.UsersVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UsersController {//用户控制器
    @Autowired
    private UsersServiceImpl usi;//持有用户逻辑层的引用

    @GetMapping("denglu")
    public String dengLu(UsersVo uvo, HttpServletRequest request, Model model){//判断登陆成功方法
        //System.out.print("进来了");
        Users user=new Users();
        BeanUtils.copyProperties(uvo, user);
            if(usi.pDUsers(user)!=null){//表示用户存在
                user=usi.PdUsersPiao(user.getUsername());
                //System.out.print("用户名:"+user.getUsername()+"啊啊啊");
                //model.addAttribute("user",user);
                request.getSession().setAttribute("user",user);
                //session.setAttribute("user",user);
                if(usi.pDAdmin(user).equals("1")){//管理员
                    return "forward:jiazai";
                }else{//普通用户
                    return "forward:jiazai";
                }
            }else{//表示用户不存在
                return "login";
            }
    }

    @GetMapping("zhuce")
    public String zhuce(UsersVo uvo){//注册用户方法
        Users user=new Users();
        BeanUtils.copyProperties(uvo, user);
        if(user.getPassword().equals(user.getQrpassword())){//判断密码是否与确认密码一致
            if(usi.insertUsers(user)>0){//注册成功
                return "forward:jiazai";
            }else{//注册失败
                return "login";
            }
        }else {//密码与确认密码不一致,注册失败
            return "login";
        }
    }
}
