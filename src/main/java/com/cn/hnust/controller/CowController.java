package com.cn.hnust.controller;

import com.cn.hnust.pojo.*;
import com.cn.hnust.service.CowCategoryService;
import com.cn.hnust.service.CowHouseService;
import com.cn.hnust.service.CowService;
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
public class CowController {

    private static Logger log = LoggerFactory.getLogger(CowController.class);
    private static Gson gson = new Gson();

    @Resource
    private CowHouseService cowHouseService;

    @Resource
    private IUserService userService;

    @Resource
    private CowCategoryService cowCategoryService;

    @Resource
    private  CowService cowService;





    @RequestMapping("/getCowList.do")
    public ModelAndView getList(Cow cow,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView("mainCow");
        List<CowVo> cowVoList = new ArrayList<CowVo>();
        List<Cow> cowList= cowService.selectByCow(cow,page,rows);
        for(Cow cw:cowList)
        {
            CowVo cowVo = new CowVo(cw);
            CowCategory cowCategory = cowCategoryService.selectByKey(cw.getCowcategory());
            cowVo.setCategoryname(cowCategory.getCategoryname());
            cowVoList.add(cowVo);
        }

        List<CowCategory> cowCategoryList =  cowCategoryService.selectByCowCategory(new CowCategory(), 1, Integer.SIZE);
        result.addObject("categoryList", cowCategoryList);
        log.info("result:{}", cowCategoryList);
        result.addObject("cowVoList", cowVoList);
        result.addObject("pageInfo", new PageInfo<Cow>(cowList));
        result.addObject("queryParam", cow);
        result.addObject("page", page);
        result.addObject("rows", rows);
        log.info("page:{},rows:{},result:{}", new String[]{page+"",rows+"",gson.toJson(cowList)});
        return result;
    }


    @RequestMapping("/updateCow.do")
    public ModelAndView updateHouse(Integer cowId) {
        ModelAndView result = new ModelAndView("addCow");
        Cow cow = cowService.selectByKey(cowId);
        result.addObject("cow",cow);
        log.info("houseId:{},result:{}", new String[]{cowId + "", gson.toJson(cow)});

        List<CowCategory> categoryList =  cowCategoryService.selectByCowCategory(new CowCategory(), 1, Integer.SIZE);
        List<CowHouse> cowHouseList = cowHouseService.selectByCowHouse(new CowHouse(), 1, Integer.SIZE);
        result.addObject("categoryList", categoryList);
        result.addObject("cowHouseList", cowHouseList);
        return result;
    }

    @RequestMapping("/toAddCow.do")
    public ModelAndView toAddHouse() {
        ModelAndView result = new ModelAndView("addCow");
        List<CowCategory> categoryList =  cowCategoryService.selectByCowCategory(new CowCategory(), 1, Integer.SIZE);
        List<CowHouse> cowHouseList = cowHouseService.selectByCowHouse(new CowHouse(),1,Integer.SIZE);
        result.addObject("categoryList", categoryList);
        result.addObject("cowHouseList", cowHouseList);
        log.info("categoryList:{}", gson.toJson(categoryList));
        log.info("cowHouseList:{}",gson.toJson(cowHouseList));
        return result;
    }


    @RequestMapping(value = "/addCow.do",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public ModelAndView addCow(Cow cow)
    {
        List<House> houses = new ArrayList<House>();
        List<Cow> cowList = null;
        List<CowVo> cowVoList = new ArrayList<CowVo>();
        ModelAndView result = new ModelAndView("mainCow");
        Integer cowId = cow.getCowid();
        log.info("Cow:{}",gson.toJson(cow));
        if(null!=cowId)
        {
            Cow oldCow = cowService.selectByKey(cowId);
            oldCow.setState(cow.getState());
            oldCow.setCowcategory(cow.getCowcategory());
            oldCow.setBirthday(cow.getBirthday());
            oldCow.setHouseid(cow.getHouseid());
            oldCow.setInweight(cow.getInweight());
            oldCow.setWeight(cow.getWeight());
            oldCow.setSex(cow.getSex());
            oldCow.setIndate(cow.getIndate());
            cowService.updateAll(oldCow);
            cowList = cowService.selectByCow(oldCow, 1, 10);
            for(Cow cw :cowList)
            {
                CowVo cowVo = new CowVo(cw);
                CowCategory cowCategory = cowCategoryService.selectByKey(cw.getCowcategory());
                cowVo.setCategoryname(cowCategory.getCategoryname());
                cowVoList.add(cowVo);
            }

        }else{
            cowService.save(cow);
            cowList = cowService.selectByCow(cow, 1, 10);
            for(Cow cw :cowList)
            {
                CowVo cowVo = new CowVo(cw);
                CowCategory cowCategory = cowCategoryService.selectByKey(cw.getCowcategory());
                cowVo.setCategoryname(cowCategory.getCategoryname());
                cowVoList.add(cowVo);
            }
        }
        result.addObject("cowVoList", cowVoList);
        result.addObject("pageInfo", new PageInfo<Cow>(cowList));
        result.addObject("queryParam", cow);
        result.addObject("page", 1);
        result.addObject("rows", 10);
        log.info("page:{},rows:{},result:{}", new String[]{1 + "", 10 + "", gson.toJson(cowList)});
        return result;
    }


}
