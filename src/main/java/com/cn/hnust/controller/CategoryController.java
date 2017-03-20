package com.cn.hnust.controller;

import com.cn.hnust.pojo.CowCategory;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.CowCategoryService;
import com.cn.hnust.service.CowService;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/27
 * Time:   22:22
 */
@Controller
public class CategoryController {

    private static Logger log = LoggerFactory.getLogger(CategoryController.class);
    private static Gson gson = new Gson();

    @Resource
    private CowCategoryService cowCategoryService;


    @RequestMapping("/getCategoryList.do")
    public ModelAndView getList(CowCategory cowCategory,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView("mainCategory");
        List<CowCategory> cowCategoryList= cowCategoryService.selectByCowCategory(cowCategory,page,rows);
        result.addObject("pageInfo", new PageInfo<CowCategory>(cowCategoryList));
        result.addObject("queryParam", cowCategory);
        result.addObject("page", page);
        result.addObject("rows", rows);
        log.info("page:{},rows:{},result:{}", new String[]{page+"",rows+"",gson.toJson(cowCategoryList)});
        return result;
    }


    @RequestMapping("/updateCategory.do")
    public ModelAndView updateUser(Integer cowCategoryId) {
        ModelAndView result = new ModelAndView("addCategory");
        CowCategory cowCategory = cowCategoryService.selectByKey(cowCategoryId);
        result.addObject("cowCategory",cowCategory);
        log.info("userId:{},result:{}", new String[]{cowCategoryId+"",gson.toJson(cowCategory)});
        return result;
    }


    @RequestMapping(value = "/addCategory.do",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public ModelAndView addUser(CowCategory cowCategory)
    {
        List<CowCategory> categoryList = null;
        ModelAndView result = new ModelAndView("mainCategory");
        Integer cowCategroyId = cowCategory.getId();
        log.info("cowCategory:{}",gson.toJson(cowCategory));
        if(null!=cowCategroyId)
        {
            CowCategory oldCategory = cowCategoryService.selectByKey(cowCategroyId);
            oldCategory.setDescription(cowCategory.getDescription());
            oldCategory.setState(cowCategory.getState());
            oldCategory.setCategoryname(cowCategory.getCategoryname());
            cowCategoryService.updateAll(oldCategory);
            categoryList = cowCategoryService.selectByCowCategory(oldCategory,1,10);
        }else{
            cowCategoryService.save(cowCategory);
            categoryList = cowCategoryService.selectByCowCategory(cowCategory,1,10);
        }

        result.addObject("pageInfo", new PageInfo<CowCategory>(categoryList));
        result.addObject("queryParam", cowCategory);
        result.addObject("page", 1);
        result.addObject("rows", 10);
        log.info("page:{},rows:{},result:{}", new String[]{1 + "", 10 + "", gson.toJson(categoryList)});
        return result;
    }


}
