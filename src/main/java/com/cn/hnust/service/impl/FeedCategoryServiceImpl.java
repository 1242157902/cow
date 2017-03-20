package com.cn.hnust.service.impl;

import com.cn.hnust.pojo.Cow;
import com.cn.hnust.pojo.FeedCategory;
import com.cn.hnust.service.FeedCategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/3/20
 * Time:   17:57
 */
@Service("feedCategoryService")
public class FeedCategoryServiceImpl extends BaseService<FeedCategory> implements FeedCategoryService {

    public List<FeedCategory> selectByFeedCategory(FeedCategory fc,int pageNum,int pageSize)
    {
        Example example = new Example(FeedCategory.class);
        Example.Criteria criteria = example.createCriteria();

        if (StringUtil.isNotEmpty(fc.getFeedname())) {
            criteria.andLike("feedname", "%" + fc.getFeedname() + "%");
        }
        if (fc.getFeedid() != null) {
            criteria.andEqualTo("feedid", fc.getFeedid());
        }
        if(fc.getState()!=null)
        {
            criteria.andEqualTo("state",fc.getState());
        }
        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<FeedCategory> feedCategoryList =selectByExample(example);
        return feedCategoryList;
    }
}
