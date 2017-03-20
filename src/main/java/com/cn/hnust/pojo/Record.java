package com.cn.hnust.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Record {


    @Id
    @Column(name = "id")
    private Integer id;

    private Integer houseid;

    private Integer cowid;

    private Integer state;

    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public Integer getCowid() {
        return cowid;
    }

    public void setCowid(Integer cowid) {
        this.cowid = cowid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}