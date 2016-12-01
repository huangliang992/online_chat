package com.hainan.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/chat1")
public class Chat1Controller {
	@RequestMapping
	public ModelAndView chat1(){
		return new ModelAndView("chat1");
	}
}
