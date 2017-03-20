package com.cn.hnust.service;

import com.cn.hnust.pojo.Stock;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/3/20
 * Time:   14:18
 */
public interface StockService extends IService<Stock> {
    public List<Stock> selectByStock(Stock stock, int pageNum, int pageSize);
}
