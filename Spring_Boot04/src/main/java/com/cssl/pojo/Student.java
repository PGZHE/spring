package com.cssl.pojo;

public class Student
{
    private int id;//编号
    private String name;//姓名
    private String pwd;//密码

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {

        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public int getId() {

        return id;
    }
}
