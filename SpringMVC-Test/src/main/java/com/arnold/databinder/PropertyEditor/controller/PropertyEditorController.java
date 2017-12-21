package com.arnold.databinder.PropertyEditor.controller;

import com.arnold.databinder._domain.User;
import com.arnold.databinder.PropertyEditor.editor.UserEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class PropertyEditorController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(User.class, new UserEditor());
		//局部Validator
		// binder.setValidator(new UserValidator());
	}

	@RequestMapping(value = "/PropertyEditor")
	public String handle81(@RequestParam("user") User user, ModelMap modelMap) {
		modelMap.put("user", user);
		return "/user/showUser";
	}
}
