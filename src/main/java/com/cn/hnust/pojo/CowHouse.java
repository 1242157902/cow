package com.cn.hnust.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class CowHouse {
    @Id
    @Column(name = "houseId")
    private Integer houseid;

    private Integer cowcategory;

    private Integer cowmanager;

    private Integer cowfeeder;

    private Integer cowveter;

    private Integer stock;

    private Integer alredystock;

    private Integer state;

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public Integer getCowcategory() {
        return cowcategory;
    }

    public void setCowcategory(Integer cowcategory) {
        this.cowcategory = cowcategory;
    }

    public Integer getCowmanager() {
        return cowmanager;
    }

    public void setCowmanager(Integer cowmanager) {
        this.cowmanager = cowmanager;
    }

    public Integer getCowfeeder() {
        return cowfeeder;
    }

    public void setCowfeeder(Integer cowfeeder) {
        this.cowfeeder = cowfeeder;
    }

    public Integer getCowveter() {
        return cowveter;
    }

    public void setCowveter(Integer cowveter) {
        this.cowveter = cowveter;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getAlredystock() {
        return alredystock;
    }

    public void setAlredystock(Integer alredystock) {
        this.alredystock = alredystock;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}