package com.cn.hnust.service;

import com.cn.hnust.pojo.Cow;
import com.cn.hnust.pojo.Record;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/27
 * Time:   20:14
 */
public interface RecordService extends IService<Record> {

    public List<Record> selectByRecord(Record record,int pageNum,int pageSize);
}
