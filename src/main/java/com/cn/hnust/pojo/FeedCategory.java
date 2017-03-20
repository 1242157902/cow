package com.cn.hnust.pojo;

import javax.persistence.Column;
import javax.persistence.Id;

public class FeedCategory {

    @Id
    @Column(name = "feedid")
    private Integer feedid;

    private String feedname;

    private String description;

    public Integer getFeedid() {
        return feedid;
    }

    public void setFeedid(Integer feedid) {
        this.feedid = feedid;
    }

    public String getFeedname() {
        return feedname;
    }

    public void setFeedname(String feedname) {
        this.feedname = feedname == null ? null : feedname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}