package com.cn.hnust.service;

import com.cn.hnust.pojo.Cow;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/27
 * Time:   19:00
 */
public interface CowService extends IService<Cow> {
    public List<Cow> selectByCow(Cow cow,int pageNum,int pageSize);
}
