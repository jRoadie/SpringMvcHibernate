package com.jroadie.tvprogram.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {
	
	@RequestMapping("/")
	public String homePage(){
		return "index";
	}
	
}
