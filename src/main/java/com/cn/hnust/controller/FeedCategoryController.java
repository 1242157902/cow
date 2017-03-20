package com.cn.hnust.controller;

import com.cn.hnust.pojo.CowCategory;
import com.cn.hnust.pojo.FeedCategory;
import com.cn.hnust.service.FeedCategoryService;
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
 * Date:   2017/3/20
 * Time:   20:30
 */
@Controller
public class FeedCategoryController {

    private static Logger log = LoggerFactory.getLogger(FeedCategoryController.class);
    private static Gson gson = new Gson();

    @Resource
    private FeedCategoryService feedCategoryService;

    @RequestMapping("/getFeedCategoryList.do")
    public ModelAndView getFeedCategoryList(FeedCategory feedCategory,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView("mainFeedCategory");
        List<FeedCategory> feedCategoryList = feedCategoryService.selectByFeedCategory(feedCategory,page,rows);
        result.addObject("pageInfo", new PageInfo<FeedCategory>(feedCategoryList));
        result.addObject("queryParam", feedCategory);
        result.addObject("page", page);
        result.addObject("rows", rows);
        log.info("page:{},rows:{},result:{}", new String[]{page+"",rows+"",gson.toJson(feedCategoryList)});
        return result;
    }




    @RequestMapping(value = "/addFeedCategory.do",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public ModelAndView addUser(FeedCategory feedCategory)
    {
        List<FeedCategory> feedCategoryList = null;
        ModelAndView result = new ModelAndView("mainFeedCategory");
        Integer feedid = feedCategory.getFeedid();
        log.info("feedCategory:{}",gson.toJson(feedCategory));
        if(null!=feedid)
        {
            FeedCategory oldfeedCategory = feedCategoryService.selectByKey(feedid);
            oldfeedCategory.setDescription(feedCategory.getDescription());
            oldfeedCategory.setState(feedCategory.getState());
            oldfeedCategory.setFeedname(feedCategory.getFeedname());
            feedCategoryService.updateAll(oldfeedCategory);
            feedCategoryList = feedCategoryService.selectByFeedCategory(feedCategory,1,10);
        }else{
            feedCategoryService.save(feedCategory);
            feedCategoryList = feedCategoryService.selectByFeedCategory(feedCategory,1,10);
        }

        result.addObject("pageInfo", new PageInfo<FeedCategory>(feedCategoryList));
        result.addObject("queryParam", feedCategory);
        result.addObject("page", 1);
        result.addObject("rows", 10);
        log.info("page:{},rows:{},result:{}", new String[]{1 + "", 10 + "", gson.toJson(feedCategoryList)});
        return result;
    }



    @RequestMapping("/updateFeedCategory.do")
    public ModelAndView updateUser(Integer feedid) {
        ModelAndView result = new ModelAndView("addFeedCategory");
        FeedCategory feedCategory = feedCategoryService.selectByKey(feedid);
        result.addObject("feedCategory",feedCategory);
        log.info("userId:{},result:{}", new String[]{feedid+"",gson.toJson(feedCategory)});
        return result;
    }

}
