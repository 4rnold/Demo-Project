package com.arnold.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("ehcache")
@Controller
public class EhCachePageCacheController {

	@RequestMapping("hello")
	public String hello(){
		return "hello";
	}
}
