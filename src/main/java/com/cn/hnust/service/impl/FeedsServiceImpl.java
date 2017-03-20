package com.cn.hnust.service.impl;

import com.cn.hnust.pojo.Feeds;
import com.cn.hnust.service.FeedsService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/3/20
 * Time:   12:18
 */
@Service("feedsService")
public class FeedsServiceImpl extends BaseService<Feeds> implements FeedsService {


    public List<Feeds> selectByFeeds(Feeds feeds, int pageNum, int pageSize) {
            Example example = new Example(Feeds.class);
            Example.Criteria criteria = example.createCriteria();
            if (feeds.getId()!= null) {
                criteria.andEqualTo("cowid", feeds.getFeedid());
            }
            //分页查询
            PageHelper.startPage(pageNum, pageSize);
            List<Feeds> feedsList =selectByExample(example);
            return feedsList;

    }
}
