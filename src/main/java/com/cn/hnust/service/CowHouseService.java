package com.cn.hnust.service;

import com.cn.hnust.pojo.CowHouse;
import com.cn.hnust.pojo.CowHouse;
import com.cn.hnust.pojo.User;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/23
 * Time:   20:11
 */
public interface CowHouseService extends IService<CowHouse> {
    public List<CowHouse> selectByCowHouse(CowHouse cowHouse,int pageNum,int pageSize);
    public void insertCowHouse(CowHouse cowHouse);
    public void updateCowHouse(CowHouse cowHouse);
    public CowHouse getCowHouseByKey(Integer houseId);

}
