package com.arnold.databinder.Formatter.OutputFormatterExample.controller;

import com.arnold.databinder.Formatter.OutputFormatterExample.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Arnold
 */
@Controller
@RequestMapping("/OutputFormatterExample")
public class OutputFormatterController {

	@RequestMapping("/index")
	public String index() {
		return "/DataBinder/Formatter/OutputFormatterExample/index";
	}

	@RequestMapping("/register")
    public String register(User user, Model model){
        model.addAttribute("user", user);
        return "/DataBinder/Formatter/OutputFormatterExample/result";
    }
}