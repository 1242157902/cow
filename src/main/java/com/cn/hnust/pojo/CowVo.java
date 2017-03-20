package com.cn.hnust.pojo;

/**
 * User：    ysl
 * Date:   2017/3/1
 * Time:   21:59
 */
public class CowVo {

    private Cow cow;

    private String categoryname;


    public CowVo() {
    }

    public CowVo(Cow cow) {
        this.cow = cow;
    }

    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Override
    public String toString() {
        return "CowVo{" +
                "cow=" + cow +
                ", categoryname='" + categoryname + '\'' +
                '}';
    }
}
