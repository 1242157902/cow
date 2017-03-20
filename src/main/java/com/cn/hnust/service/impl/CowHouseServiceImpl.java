package com.cn.hnust.service.impl;

import com.cn.hnust.pojo.CowCategory;
import com.cn.hnust.pojo.CowHouse;
import com.cn.hnust.service.CowHouseService;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/23
 * Time:   20:12
 */
@Service("cowHouseService")
public class CowHouseServiceImpl extends BaseService<CowHouse> implements CowHouseService {

    private static Logger log = LoggerFactory.getLogger(CowHouseServiceImpl.class);
    private static Gson gson = new Gson();


    public List<CowHouse> selectByCowHouse(CowHouse cowHouse,int pageNum,int pageSize)
    {

        Example example = new Example(CowHouse.class);
        Example.Criteria criteria = example.createCriteria();
        Example.Criteria criteria1 = example.createCriteria();
        Example.Criteria criteria2 = example.createCriteria();
        Example.Criteria criteria3 = example.createCriteria();
        if (null!=cowHouse.getCowcategory()) {
            criteria.andEqualTo("cowcategory", cowHouse.getCowcategory());
        }
        if (null!=cowHouse.getState()) {
            criteria.andEqualTo("state",cowHouse.getState());
        }
        if ( null!=cowHouse.getHouseid()) {
            criteria.andEqualTo("houseid", cowHouse.getHouseid());
        }
        if (null!=cowHouse.getCowmanager()) {
            criteria.andEqualTo("cowmanager",cowHouse.getCowmanager());
        }



        if (null!=cowHouse.getCowfeeder()) {
            criteria1.andEqualTo("cowfeeder",cowHouse.getCowfeeder());
        }
        if (null!=cowHouse.getCowcategory()) {
            criteria1.andEqualTo("cowcategory", cowHouse.getCowcategory());
        }

        if (null!=cowHouse.getState()) {
            criteria1.andEqualTo("state",cowHouse.getState());
        }

        if ( null!=cowHouse.getHouseid()) {
            criteria1.andEqualTo("houseid", cowHouse.getHouseid());
        }



        if (null!=cowHouse.getCowveter()) {
            criteria1.andEqualTo("cowveter",cowHouse.getCowveter());
        }
        if (null!=cowHouse.getCowcategory()) {
            criteria1.andEqualTo("cowcategory", cowHouse.getCowcategory());
        }

        if (null!=cowHouse.getState()) {
            criteria1.andEqualTo("state",cowHouse.getState());
        }

        if ( null!=cowHouse.getHouseid()) {
            criteria1.andEqualTo("houseid", cowHouse.getHouseid());
        }

        example.or(criteria1);
        example.or(criteria2);
        example.or(criteria3);


        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<CowHouse> houseList =selectByExample(example);
        return houseList;
    }
    public void insertCowHouse(CowHouse cowHouse)
    {
        this.save(cowHouse);
    }
    public void updateCowHouse(CowHouse cowHouse)
    {
        this.updateAll(cowHouse);
    }

    public CowHouse getCowHouseByKey(Integer houseId)
    {
        return this.selectByKey(houseId);
    }

}
