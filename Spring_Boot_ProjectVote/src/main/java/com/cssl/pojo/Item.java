package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {//中间表
    private int iid;//中间表编号
    private int uid;//用户编号
    private int sid;//主题编号
    private int oid;//选项编号
}
