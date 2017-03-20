package com.cn.hnust.pojo;

/**
 * User：    ysl
 * Date:   2017/3/20
 * Time:   21:56
 */
public class FeedsVo {

    private Feeds feeds;

    private String feedCategory;

    public FeedsVo(Feeds feeds) {
        this.feeds = feeds;
    }

    public Feeds getFeeds() {
        return feeds;
    }

    public void setFeeds(Feeds feeds) {
        this.feeds = feeds;
    }

    public String getFeedCategory() {
        return feedCategory;
    }

    public void setFeedCategory(String feedCategory) {
        this.feedCategory = feedCategory;
    }

    @Override
    public String toString() {
        return "FeedsVo{" +
                "feeds=" + feeds +
                ", feedCategory='" + feedCategory + '\'' +
                '}';
    }
}
