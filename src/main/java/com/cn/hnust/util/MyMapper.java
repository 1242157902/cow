package com.cn.hnust.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *
 * @param <T>
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}