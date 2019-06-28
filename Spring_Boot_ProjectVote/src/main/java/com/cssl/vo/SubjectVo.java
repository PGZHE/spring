package com.cssl.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectVo {
    private int sid;//主题编号
    private String title;//主题名
    private int type;//主题类型
    public int getSid() {
        return sid;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

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
