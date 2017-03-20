package com.cn.hnust.service.impl;

import com.cn.hnust.pojo.Cow;
import com.cn.hnust.pojo.Stock;
import com.cn.hnust.service.StockService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/3/20
 * Time:   14:20
 */
@Service("stockService")
public class StockServiceImpl extends BaseService<Stock> implements StockService {

    public List<Stock> selectByStock(Stock stock,int pageNum,int pageSize)
    {
        Example example = new Example(Cow.class);
        Example.Criteria criteria = example.createCriteria();

        if (stock.getId() != null) {
            criteria.andEqualTo("id", stock.getId());
        }
        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<Stock> stockList =selectByExample(example);
        return stockList;
    }
}
