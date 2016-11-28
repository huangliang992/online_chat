package com.hainan.cs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
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
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		EducationDaoImp edi=context.getBean(EducationDaoImp.class);
		List<EducationRecord> elist=edi.queryEducationRecord();
		List<JSONObject> jlist=new ArrayList<JSONObject>();
		for(int i=0;i<elist.size();i++){
			EducationRecord er=elist.get(i);
			JSONObject json=new JSONObject();
			json.append("username", er.getUsername());
			String time=er.getSdate().toString();
			json.append("time", time);
			
			json.append("content", er.getContent());
			jlist.add(json);
		}
		mav.addObject("erecord", jlist);
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
