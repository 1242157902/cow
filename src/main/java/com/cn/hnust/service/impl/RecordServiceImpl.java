package com.cn.hnust.service.impl;

import com.cn.hnust.pojo.Record;
import com.cn.hnust.service.RecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/27
 * Time:   20:15
 */
@Service("recordService")
public class RecordServiceImpl extends BaseService<Record> implements RecordService {

    public List<Record> selectByRecord(Record record,int pageNum,int pageSize)
    {
        Example example = new Example(Record.class);
        Example.Criteria criteria = example.createCriteria();
        if (null!=record.getState()) {
            criteria.andEqualTo("state",record.getState());
        }
        if (null!=record.getHouseid()) {
            criteria.andEqualTo("houseid", record.getHouseid());
        }
        if (null!=record.getCowid()) {
            criteria.andEqualTo("cowid", record.getCowid());
          }
        if (record.getId() != null) {
            criteria.andEqualTo("id", record.getId());
        }
        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<Record> recordList =selectByExample(example);
        return recordList;
    }

}
