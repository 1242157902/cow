package com.cn.hnust.service;

import com.cn.hnust.pojo.Feeds;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/3/20
 * Time:   12:16
 */
public interface FeedsService extends IService<Feeds> {
    public List<Feeds> selectByFeeds(Feeds feeds, int pageNum, int pageSize);
}
