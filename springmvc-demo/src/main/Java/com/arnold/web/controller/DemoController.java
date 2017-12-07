package com.arnold.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DemoController {

    @RequestMapping("/hh")
    public String hello(Model model, HttpServletRequest request){

        model.addAttribute("hello", "123");
        return "hello";
    }
}
