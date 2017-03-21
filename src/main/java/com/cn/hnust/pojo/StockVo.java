package com.cn.hnust.pojo;

/**
 * User：    ysl
 * Date:   2017/3/21
 * Time:   9:47
 */
public class StockVo {
    private Stock stock;

    private FeedCategory feedCategory;

    public StockVo(Stock stock) {
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public FeedCategory getFeedCategory() {
        return feedCategory;
    }

    public void setFeedCategory(FeedCategory feedCategory) {
        this.feedCategory = feedCategory;
    }

    @Override
    public String toString() {
        return "StockVo{" +
                "stock=" + stock +
                ", feedCategory=" + feedCategory +
                '}';
    }
}
