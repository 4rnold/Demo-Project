package com.arnold.databinder.vaildator.controller;

import com.arnold.databinder._domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * @author Arnold
 */
@Controller
@RequestMapping("/valid")
public class ValidatorController {


	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register3(/*@ModelAttribute("user")*/ User user) {
		return "/DataBinder/validator/register3";
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String handle91(@Valid @ModelAttribute("user") User user,
						   BindingResult bindingResult, ModelMap mm) {
		if (bindingResult.hasErrors()) {
			return "/DataBinder/validator/register3";
		} else {
			return "/user/showUser";
		}
	}
}
