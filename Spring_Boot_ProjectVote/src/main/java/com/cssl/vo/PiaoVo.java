package com.cssl.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PiaoVo {
    private int oid;//选项编号
    private String content;//选项名称
    private int piao;//选项投的票数
    private int size;//总票数
    private String color;//票数百分比

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {

        return color;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {

        return size;
    }

    public int getOid() {
        return oid;
    }

    public String getContent() {
        return content;
    }

    public int getPiao() {
        return piao;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPiao(int piao) {
        this.piao = piao;
    }
}
