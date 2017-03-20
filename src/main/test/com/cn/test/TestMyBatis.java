package com.cn.test;


import com.alibaba.fastjson.JSON;
import com.cn.hnust.dao.UserMapper;
import com.cn.hnust.pojo.Cow;
import com.cn.hnust.pojo.CowCategory;
import com.cn.hnust.pojo.CowHouse;
import com.cn.hnust.pojo.User;
import com.cn.hnust.pojo.Record;
import com.cn.hnust.service.*;
import com.cn.hnust.util.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/14
 * Time:   21:54
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestMyBatis {

    private static Logger logger = LoggerFactory.getLogger(TestMyBatis.class);
    private static Gson gson = new Gson();

    @Resource
    private IUserService userService ;

    @Resource
    private CowCategoryService cowCategoryService;

    @Resource
    private CowHouseService cowHouseService;

    @Resource
    private CowService cowService;

    @Resource
    private RecordService recordService;

    @Autowired
    private SqlSession sqlSession;


    @Test
    public void test2()
    {
        //CowCategory category = cowCategoryService.selectByKey(1000);
        //category.setCategoryname("ss");
        //logger.info("result:{}",gson.toJson(category));
       // CowCategory cowCategory = new CowCategory();
       // cowCategory.setCategoryname("ss");
        //cowCategory.setDescription("ssss2");
       // cowCategory.setState(0);
        //category.setDescription("ddddd");
       // cowCategoryService.updateAll(category);

    /*    List<CowCategory> cowCategoryList = cowCategoryService.selectByCowCategory(cowCategory, 1, 10);
        logger.info("result:{}",gson.toJson(cowCategoryList));*/
/*        CowHouse cowHouse = new CowHouse();
        cowHouse.setState(1);
        cowHouse.setCowcategory(1001);
        cowHouse.setCowfeeder(15);
        cowHouse.setCowmanager(18);
        cowHouse.setCowveter(19);
        cowHouse.setStock(200);
        cowHouse.setAlredystock(22);
        cowHouseService.save(cowHouse);*/

/*        Cow cow = new Cow();
        cow.setBirthday(DateUtils.dateToShortStr(new Date()));
        cow.setCowcategory(1001);
        cow.setHouseid(1000);
        cow.setIndate(DateUtils.dateToShortStr(new Date()));
        cow.setInweight(56.8);
        cow.setWeight(90.0);
        cow.setUserid(20);
        cow.setState(1);
        cow.setSex(1);
        cowService.save(cow);*/
    /*    Cow cow = cowService.selectByKey(1000);
        logger.info("Cow:{}",gson.toJson(cow));
        cow.setCowcategory(1001);
        cowService.updateAll(cow);*/

    /*    Cow cow = new Cow();
        List<Cow> cowList = cowService.selectByCowHouse(cow,1,1);
        logger.info("result List:{}",gson.toJson(cowList));*/

    /*    Record record = new Record();
        record.setHouseid(1000);
        record.setTime(DateUtils.dateToShortStr(new Date()));
        record.setCowid(1000);
        record.setState(2);
        recordService.save(record);*/


   /*     Record record =  recordService.selectByKey(1);
        record.setState(3);
        recordService.updateAll(record);*/
        Record record = new Record();

        List<Record>  recordList = recordService.selectByRecord(record,1,10);
        logger.info("result:{}",gson.toJson(recordList));

/*        CowHouse cowHouse1 = cowHouseService.selectByKey(1000);
        cowHouse1.setState(0);
        logger.info("result:{}", gson.toJson(cowHouse1));
        cowHouseService.updateAll(cowHouse1);*/


    }

    @Test
    public void test1() {
        logger.info("####");
        //User user = userService.getUserByKey(1);
       // logger.info("User:{}",gson.toJson(user));
        //userService.delete(1);
    /*    User user = new User();
        user.setTime(System.currentTimeMillis()+"");
        user.setPassword("123456");
        user.setName("杨双亮");
        user.setLoginname("test");
        user.setRole(3);
        user.setId(1);
        userService.insertUser(user);*/
       // userService.updateUser(user);
        //int result = userService.getUserByCondition("admin","123456");
        // System.out.println(user.getUserName());
        // logger.info("值："+user.getUserName());
        //logger.info(result);


     /*   UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
        Example example = new Example(User.class);
        //example.createCriteria().andEqualTo("id", "000001");
        example.createCriteria().andEqualTo("loginname","ysl").andEqualTo("password","123456");

       // PageHelper.startPage(1, 10);
        List<User> users = UserMapper.selectByExample(example);
        System.out.println("##"+users.get(0).getLoginname());*/
      //  PageInfo<User> pageInfo = new PageInfo<User>(countries);
        //System.out.println("@@"+pageInfo.getTotal());

        //countries = UserMapper.selectByExample(example);
       // pageInfo = new PageInfo<Country>(countries);
       // System.out.println("###"+pageInfo.getTotal());

    }


}
