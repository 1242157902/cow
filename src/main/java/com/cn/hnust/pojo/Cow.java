package com.cn.hnust.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

public class Cow {

    @Id
    @Column(name = "cowId")
    private Integer cowid;

    private Integer sex;

    private Integer cowcategory;


    private String birthday;

    private Double weight;

    private Double inweight;

    private String indate;



    private Integer houseid;

    private Integer state;


    public Integer getCowid() {
        return cowid;
    }

    public void setCowid(Integer cowid) {
        this.cowid = cowid;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCowcategory() {
        return cowcategory;
    }

    public void setCowcategory(Integer cowcategory) {
        this.cowcategory = cowcategory;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getInweight() {
        return inweight;
    }

    public void setInweight(Double inweight) {
        this.inweight = inweight;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate == null ? null : indate.trim();
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}