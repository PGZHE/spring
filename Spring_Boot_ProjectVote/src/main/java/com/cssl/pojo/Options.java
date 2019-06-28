package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Options {//选项类
    private int oid;//选项编号
    private String content;//选项
    private int osid;//选择的主题编号

    public int getOid() {
        return oid;
    }

    public String getContent() {
        return content;
    }

    public int getOsid() {
        return osid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOsid(int osid) {
        this.osid = osid;
    }
}
