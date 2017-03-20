package com.cn.hnust.service.impl;

import com.cn.hnust.pojo.Cow;
import com.cn.hnust.pojo.CowCategory;
import com.cn.hnust.service.CowService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/27
 * Time:   19:01
 */
@Service("cowService")
public class CowServiceImpl extends BaseService<Cow> implements CowService{

    public List<Cow> selectByCow(Cow cow,int pageNum,int pageSize)
    {
        Example example = new Example(Cow.class);
        Example.Criteria criteria = example.createCriteria();
        if (null!=cow.getCowcategory()) {
            criteria.andEqualTo("cowcategory", cow.getCowcategory());
        }
        if (null!=cow.getState()) {
            criteria.andEqualTo("state",cow.getState());
        }

        if (cow.getCowid() != null) {
            criteria.andEqualTo("cowid", cow.getCowid());
        }
        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<Cow> cowList =selectByExample(example);
        return cowList;
    }
}
