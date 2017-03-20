package com.cn.hnust.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class Stock {
    @Id
    @Column(name = "id")
    private Integer id;

    private Integer feedid;

    private Double quantity;

    private String feedname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFeedid() {
        return feedid;
    }

    public void setFeedid(Integer feedid) {
        this.feedid = feedid;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getFeedname() {
        return feedname;
    }

    public void setFeedname(String feedname) {
        this.feedname = feedname == null ? null : feedname.trim();
    }
}