package com.cn.hnust.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Feeds {
    @Id
    @Column(name = "id")
    private Integer id;

    private String username;

    private Integer feedid;

    private Double num;

    private String unit;

    private Double price;

    private Double total;

    private String manufacturer;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getFeedid() {
        return feedid;
    }

    public void setFeedid(Integer feedid) {
        this.feedid = feedid;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}