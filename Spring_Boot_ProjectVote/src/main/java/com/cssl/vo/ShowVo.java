package com.cssl.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowVo {
    private int sid;//主题编号
    private String title;//哪个主题
    private int xuan;//有几个选项
    private int tou;//投了多少票
    private int type;//投票类型
}
