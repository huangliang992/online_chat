package com.hainan.cs.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hainan.cs.bean.UserBean;
import com.hainan.cs.dao.UserDaoImp;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	@RequestMapping()
	public ModelAndView login(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		mav.addObject("tag",0);
		return mav;
	}
	
}
