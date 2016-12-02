package com.hainan.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hainan.cs.singleton.UserSingleton;

@Controller
@RequestMapping(value="/chat3")
public class Chat3Controller {
	@RequestMapping
	public ModelAndView chat3(){
		ModelAndView mav=new ModelAndView();
		UserSingleton user=UserSingleton.getInstance();
		mav.addObject("username", user.getUsername());
		mav.setViewName("chat3");
		return mav;
	}
}
