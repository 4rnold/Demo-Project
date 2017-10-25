package com.arnold.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @RequestMapping("/hh")
    public String hello(Model model){
        model.addAttribute("hello", "123");
        return "hello";
    }
}
