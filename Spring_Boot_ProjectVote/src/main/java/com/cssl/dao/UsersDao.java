package com.cssl.dao;

import com.cssl.pojo.Users;

import java.util.List;

public interface UsersDao {//用户类dao接口
    public String pDUsers(Users users);//判断用户是否存在

    public int insertUsers(Users users);//注册新用户

    public String pDAdmin(Users users);//判断是管理员还是普通用户

    public Users PdUsersPiao(String username);//判断用户是否投票
}
