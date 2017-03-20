package com.cn.hnust.service;

import com.cn.hnust.pojo.User;

import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/14
 * Time:   19:27
 */
public interface IUserService extends IService<User>{

    public User getUserByKey(Integer userId);
    public User  getUserByCondition(String loginName,String password);
    public List<User> selectByUser(User user,int pageNum,int pageSize);
    public User  getUserByName(String name);

    public void insertUser(User user);
    public void updateUser(User user);
    public void deleteUserByKey(Integer userId);

}
