package com.arnold.web.converter.controller;

import com.arnold.web.XmlAndJsonRequest.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/converter")
public class ConverterServiceController {

    /**
     * 通过converterService转换
     * 用：将各属性分开。
     * @param user
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public User handler81(@RequestParam("user")User user) {
        return user;
    }



}
