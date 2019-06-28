package com.cssl.serviceImpl;

import com.cssl.dao.UsersDao;
import com.cssl.pojo.Users;
import com.cssl.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {//实现用户service层接口中的方法
    @Autowired
    private UsersDao udao;//持有用户dao层引用

    @Override
    public String pDUsers(Users users) {//判断用户是否存在
        return udao.pDUsers(users);
    }

    @Override
    public int insertUsers(Users users) {//注册新用户
        return udao.insertUsers(users);
    }
    @Override
    public String pDAdmin(Users users) {//判断是管理员还是普通用户
        return  udao.pDAdmin(users);
    }

    @Override
    public Users PdUsersPiao(String username) {
        return udao.PdUsersPiao(username);
    }

}
