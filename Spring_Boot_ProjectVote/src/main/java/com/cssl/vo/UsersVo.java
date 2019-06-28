package com.cssl.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersVo {//用户类VO
    private int uid;//编号
    private String username;//用户名
    private String password;//密码
    private String qrpassword;//确认密码
    private int isAdmin;//判断是否是管理员
    private int piao;//判断是否投过票
    public String getPassword() {
        return password;
    }

    public String getQrpassword() {
        return qrpassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setQrpassword(String qrpassword) {
        this.qrpassword = qrpassword;
    }
}
