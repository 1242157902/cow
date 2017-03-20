package com.cn.hnust.service.impl;

import com.cn.hnust.dao.UserMapper;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.util.DateUtils;
import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/14
 * Time:   19:25
 */
@Service("userService")
public class UserServiceImpl extends BaseService<User> implements IUserService {

    private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private static Gson gson = new Gson();

    public List<User> selectByUser(User user,int pageNum,int pageSize)
    {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(user.getName())) {
            criteria.andLike("name", "%" + user.getName() + "%");
        }
        if (StringUtil.isNotEmpty(user.getLoginname())) {
            criteria.andEqualTo("loginname", user.getLoginname());
        }
        if (StringUtil.isNotEmpty(user.getPassword())) {
            criteria.andEqualTo("password", user.getPassword());
          }

        if (null!=user.getRole()) {
            criteria.andEqualTo("role", user.getRole());
        }
        if (user.getId() != null) {
            criteria.andEqualTo("id", user.getId());
        }
        //分页查询
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList =selectByExample(example);
        userList = convertTimeStampToDateStr(userList);
        return userList;
    }


    public User getUserByName(String name) {

        User user = null;
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("name",name);
        List<User> users = this.selectByExample(example);
        if(null!=users&&users.size()>0)
        {
            user = users.get(0);
            log.info("dao return result:{}",gson.toJson(users));
        }
        return user;
    }

    public List<User> convertTimeStampToDateStr(List<User> userList)
    {
        for(User user:userList)
        {
            user.setTime(DateUtils.millionsToShortStrDate(Long.parseLong(user.getTime())));
        }
        return userList;
    }


    public User getUserByKey(Integer userId) {
        return this.selectByKey(userId);
    }

    /**
     * 增加用户
     * @param user
     */
    public void insertUser(User user)
    {
         this.save(user);
    }

    public void updateUser(User user)
    {
        this.updateAll(user);
    }


    /**
     * 通过用户名和密码登陆系统
     * @param loginName
     * @param password
     * @return
     */
    public User getUserByCondition(String loginName,String password)
    {
        User user = null;
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("loginname",loginName).andEqualTo("password", password);
        List<User> users = this.selectByExample(example);
        if(null!=users&&users.size()>0)
        {
            user = users.get(0);
            log.info("dao return result:{}",gson.toJson(users));
        }
        return user;
    }


    /**
     * 通过主键id删除对应的记录数据
     * @param userId
     */
    public void deleteUserByKey(Integer userId)
    {
        this.delete(userId);
    }



}
