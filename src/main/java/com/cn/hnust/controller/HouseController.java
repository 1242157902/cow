package com.cn.hnust.controller;

import com.cn.hnust.pojo.CowCategory;
import com.cn.hnust.pojo.CowHouse;
import com.cn.hnust.pojo.House;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.CowCategoryService;
import com.cn.hnust.service.CowHouseService;
import com.cn.hnust.service.IUserService;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User：    ysl
 * Date:   2017/3/1
 * Time:   11:21
 */
@Controller
public class HouseController {

    private static Logger log = LoggerFactory.getLogger(HouseController.class);
    private static Gson gson = new Gson();

    @Resource
    private CowHouseService cowHouseService;

    @Resource
    private IUserService userService;

    @Resource
    private CowCategoryService cowCategoryService;




    @RequestMapping("/getHouseList.do")
    public ModelAndView getList(String name,CowHouse cowHouse,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView("mainHouse");
        List<House> houseList = new ArrayList<House>();
        log.info("name:{},cowHouse:{}",new String[]{name,gson.toJson(cowHouse)});
        if(!StringUtils.isNullOrEmpty(name))
        {
            User user = userService.getUserByName(name);
            cowHouse.setCowmanager(user.getId());
            cowHouse.setCowveter(user.getId());
            cowHouse.setCowfeeder(user.getId());
        }
        List<CowHouse> cowHouseList= cowHouseService.selectByCowHouse(cowHouse,page,rows);
        for(CowHouse ch:cowHouseList)
        {
            House house = new House(ch);
            User  feeter = userService.selectByKey(ch.getCowfeeder());
            User  manager = userService.selectByKey(ch.getCowmanager());
            User  veter = userService.selectByKey(ch.getCowveter());
            CowCategory cowCategory = cowCategoryService.selectByKey(ch.getCowcategory());
            house.setCategoryname(cowCategory.getCategoryname());
            house.setFeetername(feeter.getName());
            house.setManagername(manager.getName());
            house.setVetername(veter.getName());
            houseList.add(house);
        }
        result.addObject("houseList", houseList);
        result.addObject("pageInfo", new PageInfo<CowHouse>(cowHouseList));
        result.addObject("queryParam", cowHouse);
        result.addObject("page", page);
        result.addObject("rows", rows);
        log.info("page:{},rows:{},result:{}", new String[]{page+"",rows+"",gson.toJson(cowHouseList)});
        return result;
    }


    @RequestMapping("/updateHouse.do")
    public ModelAndView updateHouse(Integer cowHouseId) {
        ModelAndView result = new ModelAndView("addHouse");
        CowHouse cowHouse = cowHouseService.selectByKey(cowHouseId);
        result.addObject("cowHouse",cowHouse);
        log.info("houseId:{},result:{}", new String[]{cowHouseId+"",gson.toJson(cowHouse)});

        List<CowCategory> categoryList =  cowCategoryService.selectByCowCategory(new CowCategory(), 1, Integer.SIZE);
        List<User> managers =   userService.selectByUser(new User(1), 1, Integer.SIZE);
        List<User> feeters = userService.selectByUser(new User(2), 1, Integer.SIZE);
        List<User> veters = userService.selectByUser(new User(3), 1, Integer.SIZE);
        result.addObject("categoryList",categoryList);
        result.addObject("managers",managers);
        result.addObject("feeters",feeters);
        result.addObject("veters", veters);

        return result;
    }

    @RequestMapping("/toAddHouse.do")
    public ModelAndView toAddHouse() {
        ModelAndView result = new ModelAndView("addHouse");
         List<CowCategory> categoryList =  cowCategoryService.selectByCowCategory(new CowCategory(), 1, Integer.SIZE);
      List<User> managers =   userService.selectByUser(new User(1), 1, Integer.SIZE);
        List<User> feeters = userService.selectByUser(new User(2), 1, Integer.SIZE);
        List<User> veters = userService.selectByUser(new User(3), 1, Integer.SIZE);
        result.addObject("categoryList",categoryList);
        result.addObject("managers",managers);
        result.addObject("feeters",feeters);
        result.addObject("veters",veters);
        log.info("categoryList:{},managers:{},feeters:{},veters:{}",
                new String[]{gson.toJson(categoryList),
                        gson.toJson(managers),
                        gson.toJson(feeters),
                        gson.toJson(veters)
                });
        return result;
    }


    @RequestMapping(value = "/addHouse.do",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public ModelAndView addUser(CowHouse cowHouse)
    {
        List<House> houses = new ArrayList<House>();
        List<CowHouse> houseList = null;
        ModelAndView result = new ModelAndView("mainHouse");
        Integer cowCategroyId = cowHouse.getHouseid();
        log.info("cowHouse:{}",gson.toJson(cowHouse));
        if(null!=cowCategroyId)
        {
            CowHouse oldHouse = cowHouseService.selectByKey(cowCategroyId);
            oldHouse.setState(cowHouse.getState());
            oldHouse.setAlredystock(cowHouse.getAlredystock());
            oldHouse.setCowmanager(cowHouse.getCowmanager());
            oldHouse.setCowfeeder(cowHouse.getCowfeeder());
            oldHouse.setCowveter(cowHouse.getCowveter());
            oldHouse.setCowcategory(cowHouse.getCowcategory());
            cowHouseService.updateAll(oldHouse);
            houseList = cowHouseService.selectByCowHouse(oldHouse, 1, 10);
            for(CowHouse ch :houseList)
            {
                House house = new House(ch);
                User  feeter = userService.selectByKey(ch.getCowfeeder());
                User  manager = userService.selectByKey(ch.getCowmanager());
                User  veter = userService.selectByKey(ch.getCowveter());
                CowCategory cowCategory = cowCategoryService.selectByKey(ch.getCowcategory());
                house.setCategoryname(cowCategory.getCategoryname());
                house.setFeetername(feeter.getName());
                house.setManagername(manager.getName());
                house.setVetername(veter.getName());
                houses.add(house);
            }

        }else{
            cowHouseService.save(cowHouse);
            houseList = cowHouseService.selectByCowHouse(cowHouse, 1, 10);
            for(CowHouse ch :houseList)
            {
                House house = new House(ch);
                User  feeter = userService.selectByKey(ch.getCowfeeder());
                User  manager = userService.selectByKey(ch.getCowmanager());
                User  veter = userService.selectByKey(ch.getCowveter());
                CowCategory cowCategory = cowCategoryService.selectByKey(ch.getCowcategory());
                house.setCategoryname(cowCategory.getCategoryname());
                house.setFeetername(feeter.getName());
                house.setManagername(manager.getName());
                house.setVetername(veter.getName());
                houses.add(house);
            }
        }
        result.addObject("houseList", houses);
        result.addObject("pageInfo", new PageInfo<CowHouse>(houseList));
        result.addObject("queryParam", cowHouse);
        result.addObject("page", 1);
        result.addObject("rows", 10);
        log.info("page:{},rows:{},result:{}", new String[]{1 + "", 10 + "", gson.toJson(houseList)});
        return result;
    }


}
