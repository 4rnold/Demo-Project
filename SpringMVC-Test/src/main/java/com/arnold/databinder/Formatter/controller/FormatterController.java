package com.arnold.databinder.Formatter.controller;

import com.arnold.databinder._domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class FormatterController {

	@RequestMapping(value = "/Formatter",method = RequestMethod.POST)
	public String handle82(User user, ModelMap modelMap) {
		return "/user/showUser";
	}
}
