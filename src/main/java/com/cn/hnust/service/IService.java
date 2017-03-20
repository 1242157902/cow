package com.cn.hnust.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/19
 * Time:   15:02
 */
@Service
public interface IService<T>{


    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
}
