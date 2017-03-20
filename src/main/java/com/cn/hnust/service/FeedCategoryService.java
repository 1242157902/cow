package com.cn.hnust.service;

import com.cn.hnust.pojo.FeedCategory;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/3/20
 * Time:   17:56
 */
public interface FeedCategoryService extends IService<FeedCategory> {
    public List<FeedCategory> selectByFeedCategory(FeedCategory fc,int pageNum,int pageSize);
}
