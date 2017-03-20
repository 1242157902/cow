package com.cn.hnust.controller;

import com.cn.hnust.pojo.*;
import com.cn.hnust.service.CowHouseService;
import com.cn.hnust.service.CowService;
import com.cn.hnust.service.RecordService;
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
 * Date:   2017/3/8
 * Time:   10:38
 */
@Controller
public class RecordController {

    private static Logger log = LoggerFactory.getLogger(RecordController.class);
    private static Gson gson = new Gson();


    @Resource
    private RecordService recordService;


    @Resource
    private CowHouseService cowHouseService;

    @Resource
    private CowService cowService;




    @RequestMapping("/getRecordList.do")
    public ModelAndView getList(Record record,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView("mainRecord");
        log.info("record:{}",new String[]{gson.toJson(record)});
        List<Record> recordList= recordService.selectByRecord(record,page,rows);
        List<CowHouse> cowHouseList = cowHouseService.selectByCowHouse(new CowHouse(), 1, Integer.SIZE);
        result.addObject("recordList", recordList);
        result.addObject("cowHouseList", cowHouseList);
        result.addObject("pageInfo", new PageInfo<Record>(recordList));
        result.addObject("queryParam", record);
        result.addObject("page", page);
        result.addObject("rows", rows);
        log.info("page:{},rows:{},resultList:{}", new String[]{page+"",rows+"",gson.toJson(recordList)});
        return result;
    }



    @RequestMapping("/toAddRecord.do")
    public ModelAndView toAddHouse() {
        ModelAndView result = new ModelAndView("addRecord");
       List<Cow> cowList = cowService.selectByCow(new Cow(),1,Integer.SIZE);
        result.addObject("cowList", cowList);
        log.info("cowList:{}",gson.toJson(cowList));
        return result;
    }



    @RequestMapping(value = "/addRecord.do",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public ModelAndView addRecord(Record  record)
    {
        List<Record> recordList = null;
        ModelAndView result = new ModelAndView("mainRecord");
        Integer recordId = record.getId();
        log.info("record:{}",gson.toJson(record));
        if(null!=recordId)
        {
            Record oldRecord = recordService.selectByKey(recordId);
            oldRecord.setState(record.getState());
            oldRecord.setTime(record.getTime());
            oldRecord.setCowid(record.getCowid());
            recordService.updateAll(oldRecord);
            recordList = recordService.selectByRecord(record,1,10);
        }else{

            Cow cow =  cowService.selectByKey(record.getCowid());
            record.setHouseid(cow.getHouseid());
            recordService.save(record);
            recordList = recordService.selectByRecord(record,1,10);
        }

        result.addObject("pageInfo", new PageInfo<Record>(recordList));
        result.addObject("queryParam", record);
        result.addObject("page", 1);
        result.addObject("rows", 10);
        log.info("page:{},rows:{},result:{}", new String[]{1 + "", 10 + "", gson.toJson(recordList)});
        return result;
    }



    @RequestMapping("/updateRecord.do")
    public ModelAndView updateUser(Integer id) {
        ModelAndView result = new ModelAndView("addRecord");
        Record record = recordService.selectByKey(id);
        result.addObject("record",record);
        List<Cow> cowList = cowService.selectByCow(new Cow(), 1, Integer.SIZE);
        result.addObject("cowList", cowList);
        log.info("id:{},result:{}", new String[]{id+"",gson.toJson(record)});
        return result;
    }



}
