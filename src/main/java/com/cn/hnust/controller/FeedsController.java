package com.cn.hnust.controller;

import com.cn.hnust.pojo.*;
import com.cn.hnust.service.FeedCategoryService;
import com.cn.hnust.service.FeedsService;
import com.cn.hnust.service.StockService;
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
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * User：    ysl
 * Date:   2017/3/20
 * Time:   21:29
 */
@Controller
public class FeedsController {
    private static Logger log = LoggerFactory.getLogger(FeedsController.class);
    private static Gson gson = new Gson();

    @Resource
    private FeedsService feedsService;

    @Resource
    private FeedCategoryService feedCategoryService;

    @Resource
    private StockService stockService;

    @RequestMapping("/getFeedsList.do")
    public ModelAndView getFeedsList(Feeds feeds,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView("mainFeeds");
        List<FeedsVo> feedsVoList = new ArrayList<FeedsVo>();
        List<Feeds> feedsList = feedsService.selectByFeeds(feeds,page,rows);
        for(Feeds f:feedsList)
        {
            FeedsVo fv = new FeedsVo(f);
            FeedCategory fc = feedCategoryService.selectByKey(f.getFeedid());
            fv.setFeedCategory(fc.getFeedname());
            feedsVoList.add(fv);
        }
        result.addObject("pageInfo", new PageInfo<Feeds>(feedsList));
        result.addObject("queryParam", feeds);
        result.addObject("feedsVoList",feedsVoList);
        result.addObject("page", page);
        result.addObject("rows", rows);
        log.info("page:{},rows:{},result:{}", new String[]{page+"",rows+"",gson.toJson(feedsList)});
        return result;
    }


    @RequestMapping("/toAddFeeds.do")
    public ModelAndView toAddHouse() {
        ModelAndView result = new ModelAndView("addFeeds");
        List<FeedCategory> feedCategoryList =  feedCategoryService.selectByFeedCategory(new FeedCategory(), 1, Integer.SIZE);
        result.addObject("feedCategoryList", feedCategoryList);
        log.info("cowHouseList:{}",gson.toJson(feedCategoryList));
        return result;
    }


    @RequestMapping(value = "/addFeeds.do",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public ModelAndView addFeeds(Feeds feeds,HttpServletRequest request)
    {
        List<House> houses = new ArrayList<House>();
        List<Feeds> feedsList = null;
        List<FeedsVo> feedsVoList = new ArrayList<FeedsVo>();
        ModelAndView result = new ModelAndView("mainFeeds");
        Integer id = feeds.getId();
        log.info("Feeds:{}", gson.toJson(feeds));
        if (null != id) {

        } else {
            User user = (User) request.getSession().getAttribute("loginUser");
            feeds.setTotal(feeds.getNum() * feeds.getPrice());
            feeds.setUsername(user.getName());
            feedsService.save(feeds);

            int feedid = feeds.getFeedid();
            Stock ss = new Stock();
            ss.setFeedid(feedid);
            Stock stock = ((List<Stock>)stockService.selectByStock(ss,1,10)).get(0);
            //判断是入库还是出库，并加减到库存
            int state = feeds.getState();
            switch (state)
            {
                case 1:
                    //入库
                    if(null!=stock)
                    {
                        double quantity = stock.getQuantity();
                        quantity +=feeds.getNum();
                        stock.setQuantity(quantity);
                        stockService.updateAll(stock);
                    }else{
                        Stock s = new Stock();
                        s.setFeedid(feedid);
                        FeedCategory fc = feedCategoryService.selectByKey(feedid);
                        s.setFeedname(fc.getFeedname());
                        s.setQuantity(feeds.getNum());
                        stockService.save(s);
                    }

                    break;
                case 2:
                    //出库
                    if(null!=stock)
                    {
                        double quantity = stock.getQuantity();
                        quantity -=feeds.getNum();
                        stock.setQuantity(quantity);
                        stockService.updateAll(stock);
                    }else{
                        Stock s = new Stock();
                        s.setFeedid(feedid);
                        FeedCategory fc = feedCategoryService.selectByKey(feedid);
                        s.setFeedname(fc.getFeedname());
                        s.setQuantity(- feeds.getNum());
                        stockService.save(s);
                    }
                    break;
            }

            feedsList = feedsService.selectByFeeds(feeds, 1, 10);
            for(Feeds f:feedsList)
            {
                FeedsVo fv = new FeedsVo(f);
                FeedCategory fc = feedCategoryService.selectByKey(f.getFeedid());
                fv.setFeedCategory(fc.getFeedname());
                feedsVoList.add(fv);
            }
        }
        result.addObject("feedsVoList", feedsVoList);
        result.addObject("pageInfo", new PageInfo<Feeds>(feedsList));
        result.addObject("queryParam", feeds);
        result.addObject("page", 1);
        result.addObject("rows", 10);
        log.info("page:{},rows:{},result:{}", new String[]{1 + "", 10 + "", gson.toJson(feedsList)});
        return result;
    }

    @RequestMapping("/deleteFeeds.do")
    public ModelAndView deleteUser(Integer id,
                                   @RequestParam(required = false, defaultValue = "1") int page,
                                   @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView("mainFeeds");
        feedsService.delete(id);
        List<FeedsVo> feedsVoList = new ArrayList<FeedsVo>();
        Feeds feeds = new Feeds();
        List<Feeds> feedsList = feedsService.selectByFeeds(new Feeds(), page, rows);
        for(Feeds f:feedsList)
        {
            FeedsVo fv = new FeedsVo(f);
            FeedCategory fc = feedCategoryService.selectByKey(f.getFeedid());
            fv.setFeedCategory(fc.getFeedname());
            feedsVoList.add(fv);
        }
        result.addObject("pageInfo", new PageInfo<Feeds>(feedsList));
        result.addObject("queryParam", feeds);
        result.addObject("feedsVoList",feedsVoList);
        result.addObject("page", page);
        result.addObject("rows", rows);
        log.info("page:{},rows:{},result:{}", new String[]{page+"",rows+"",gson.toJson(feedsList)});
        return result;
    }


}
