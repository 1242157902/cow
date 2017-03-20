package com.cn.hnust.service.impl;

import com.cn.hnust.pojo.CowCategory;
import com.cn.hnust.service.CowCategoryService;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Locale;

/**
 * User：    ysl
 * Date:   2017/2/22
 * Time:   23:06
 */
@Service("cowCategoryService")
public class CowCategoryServiceImpl extends BaseService<CowCategory> implements CowCategoryService {

    private static Logger log = LoggerFactory.getLogger(CowCategoryServiceImpl.class);
    private static Gson gson = new Gson();


    /**
     * 通过类别Id获取对应的实体信息
     * @param categoryId
     * @return
     */
    public CowCategory getUserByKey(Integer categoryId)
    {
        CowCategory cowCategory = this.selectByKey(categoryId);
        log.info("categoryId:{},result:{}",new String[]{categoryId+"",gson.toJson(cowCategory)});
        return cowCategory;
    }

    /**
     * 分页获取某些条件下的类别数据
     * @param cowCategory
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<CowCategory> selectByCowCategory(CowCategory cowCategory,int pageNum,int pageSize)
    {
        Example example = new Example(CowCategory.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(cowCategory.getCategoryname())) {
            criteria.andLike("categoryname", "%" + cowCategory.getCategoryname() + "%");
        }
        if (null!=cowCategory.getState()) {
            criteria.andEqualTo("state",cowCategory.getState());
        }

        if (cowCategory.getId() != null) {
            criteria.andEqualTo("id", cowCategory.getId());
        }
        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<CowCategory> categoryList =selectByExample(example);
        return categoryList;
    }


    /**
     * 插入类别
     * @param cowCategory
     */
    public void insertCowCategory(CowCategory cowCategory)
    {

        this.save(cowCategory);
    }



    /**
     * 更新相应的类别
     * @param cowCategory
     */
    public void updateCowCategory(CowCategory cowCategory)
    {

        this.updateAll(cowCategory);
    }



}
