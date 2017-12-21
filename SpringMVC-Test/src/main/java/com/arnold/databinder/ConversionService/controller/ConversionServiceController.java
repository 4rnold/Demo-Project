package com.arnold.databinder.ConversionService.controller;

import com.arnold.databinder._domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class ConversionServiceController {

	/**
	 * 测试自定义converter
	 * @param user
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/handle81")
	public String handle81(@RequestParam("user") User user, ModelMap modelMap) {
		modelMap.put("user", user);
		return "/user/showUser";
	}
}
