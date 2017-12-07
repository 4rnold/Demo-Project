package com.arnold.web.converter.controller;

import com.arnold.web.XmlAndJsonRequest.domain.User;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/initBinder")
public class InitBinderController {

    /**
     * 添加editor 可以对参数进行加工
     * 添加formatter 设置时间格式
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(User.class,new UserEditor());
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }


    @RequestMapping("/index")
    @ResponseBody
    public User index(User user, Date date){
        System.out.println(date);
        return user;
    }


}
