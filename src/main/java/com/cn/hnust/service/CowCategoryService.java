package com.cn.hnust.service;

import com.cn.hnust.pojo.CowCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CowCategory：    ysl
 * Date:   2017/2/22
 * Time:   22:52
 */

public interface CowCategoryService extends IService<CowCategory> {

    public List<CowCategory> selectByCowCategory(CowCategory cowCategory,int pageNum,int pageSize);
    public void insertCowCategory(CowCategory cowCategory);
    public void updateCowCategory(CowCategory cowCategory);
}
