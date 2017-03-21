package com.cn.hnust.controller;

import com.cn.hnust.pojo.FeedCategory;
import com.cn.hnust.pojo.Stock;
import com.cn.hnust.pojo.StockVo;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.FeedCategoryService;
import com.cn.hnust.service.StockService;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User：    ysl
 * Date:   2017/3/21
 * Time:   9:41
 */
@Controller
public class StockController {

    private static Logger log = LoggerFactory.getLogger(StockController.class);
    private static Gson gson = new Gson();

    @Resource
    private StockService stockService;
    @Resource
    private FeedCategoryService feedCategoryService;


    @RequestMapping("/getStockList.do")
    public ModelAndView getStockList(Integer feedid,Stock stock,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        log.info("params:{}",gson.toJson(stock));
        ModelAndView result = new ModelAndView("mainStock");
        List<Stock> stockList = stockService.selectByStock(stock, page, rows);
        List<FeedCategory> feedCategoryList = feedCategoryService.selectByFeedCategory(new FeedCategory(), 1, Integer.SIZE);
        result.addObject("feedCategoryList",feedCategoryList);
        result.addObject("pageInfo", new PageInfo<Stock>(stockList));
        result.addObject("queryParam", stock);
        result.addObject("page", page);
        result.addObject("rows", rows);
        log.info("page:{},rows:{},result:{}", new String[]{page+"",rows+"",gson.toJson(stockList)});
        return result;
    }

    @RequestMapping("/toStockList.do")
    public ModelAndView toStockList(Stock stock)
    {
        ModelAndView result = new ModelAndView("mainStock");
        List<FeedCategory> feedCategoryList = feedCategoryService.selectByFeedCategory(new FeedCategory(),1,Integer.SIZE);
        result.addObject("feedCategoryList",feedCategoryList);
        return result;
    }


}
