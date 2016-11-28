package com.hainan.cs.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hainan.cs.bean.EducationRecord;
import com.hainan.cs.dao.EducationDaoImp;
import com.hainan.cs.singleton.UserSingleton;

@Controller
@RequestMapping(value="/chat")
public class ChatController {
	@RequestMapping()
	public ModelAndView chat(){
		ModelAndView mav=new ModelAndView();
		UserSingleton user=UserSingleton.getInstance();
		mav.addObject("username", user.getUsername());
		mav.setViewName("chat");
		return mav;
	}
	@RequestMapping(value="/echat")
	@ResponseBody
	public Map<String,EducationRecord> echat(String message){
		System.out.println(message);
		Map<String, EducationRecord> map=new HashMap<String,EducationRecord>();
		UserSingleton user=UserSingleton.getInstance();
		Date date=new Date();
		EducationRecord er=new EducationRecord();
		er.setContent(message);
		er.setSdata(date);
		er.setUserid(user.getUserid());
		er.setUsername(user.getUsername());
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		EducationDaoImp edi=context.getBean(EducationDaoImp.class);
		edi.isnert(er);
		context.close();
		return map;
	}
}
