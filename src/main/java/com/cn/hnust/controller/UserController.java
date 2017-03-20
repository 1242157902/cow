package com.cn.hnust.controller;

import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * User：    ysl
 * Date:   2017/2/14
 * Time:   21:48
 */
@Controller
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);
    private static Gson gson = new Gson();

    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public String toIndex(HttpServletRequest request,Model model) {

        String  userId = request.getParameter("id");
        log.info("id:{}",new String[]{userId});
        User user = this.userService.getUserByKey(Integer.parseInt(userId));
        model.addAttribute("user", user);
        return "showUser";
    }




    @RequestMapping("/login.do")
    public ModelAndView login(HttpServletRequest request,Model model) {

        ModelAndView modelAndView = null;
        String  loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        log.info("loginName:{},password:{}",new String[]{loginName,password});
        User user  = this.userService.getUserByCondition(loginName,password);
        log.info("result:{}", new String[]{gson.toJson(user)});
        if(null!=user)
        {
            modelAndView = new ModelAndView("main");
            request.getSession().setAttribute("loginUser",user);
        }else{
            modelAndView = new ModelAndView("login");
        }
        return modelAndView;
    }



    @RequestMapping("/getUserList.do")
    public ModelAndView getList(User user,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView("right");
        List<User> userList = userService.selectByUser(user, page, rows);
        result.addObject("pageInfo", new PageInfo<User>(userList));
        result.addObject("queryParam", user);
        result.addObject("page", page);
        result.addObject("rows", rows);
        log.info("page:{},rows:{},result:{}", new String[]{page+"",rows+"",gson.toJson(userList)});
        return result;
    }



    @RequestMapping(value = "/addUser.do",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public ModelAndView addUser(User user)
    {
        List<User> userList = null;
        ModelAndView result = new ModelAndView("right");
        Integer userId = user.getId();
        log.info("User:{}",gson.toJson(user));
        if(null!=userId)
        {
            User oldUser = userService.getUserByKey(userId);
            user.setTime(oldUser.getTime());
            userService.updateAll(user);
            userList = userService.selectByUser(user, 1, 10);
        }else{
            user.setTime(System.currentTimeMillis() + "");
            userService.insertUser(user);
            userList = userService.selectByUser(user, 1, 10);
        }

        result.addObject("pageInfo", new PageInfo<User>(userList));
        result.addObject("queryParam", user);
        result.addObject("page", 1);
        result.addObject("rows", 10);
        log.info("page:{},rows:{},result:{}", new String[]{1 + "", 10 + "", gson.toJson(userList)});
        return result;
    }




    @RequestMapping("/updateUser.do")
    public ModelAndView updateUser(Integer userId) {
        ModelAndView result = new ModelAndView("addUser");
        User user = userService.selectByKey(userId);
        result.addObject("user",user);
        log.info("userId:{},result:{}", new String[]{userId+"",gson.toJson(user)});
        return result;
    }




    @RequestMapping("/deleteUser.do")
    public ModelAndView deleteUser(Integer userId,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView("right");
        userService.deleteUserByKey(userId);
        User user = new User();
        List<User> userList = userService.selectByUser(user, page, rows);
        result.addObject("pageInfo", new PageInfo<User>(userList));
        result.addObject("queryParam", user);
        result.addObject("page", page);
        result.addObject("rows", rows);
        log.info("userId:{},uupage:{},rows:{},result:{}", new String[]{userId+"",page+"",rows+"",gson.toJson(userList)});
        return result;
    }


}
