package com.it.vo;

import java.io.Serializable;

/**
 * @author wangchao
 * @description TODO
 * @date 2019/08/29 11:47
 */
public class Dept implements Serializable {
    private static final long serialVersionUID = -3544813604213182874L;

    private Long deptno;
    private String dname;
    private String loc;

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
