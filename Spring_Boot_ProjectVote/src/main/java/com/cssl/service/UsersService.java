package com.cssl.service;

import com.cssl.pojo.Users;

import java.util.List;

public interface UsersService {//用户类业务逻辑接口

    public String pDUsers(Users users);//判断用户是否存在

    public int insertUsers(Users users);//注册新用户

    public String pDAdmin(Users users);//判断是管理员还是普通用户

    public Users PdUsersPiao(String username);//判断用户是否投票
}
