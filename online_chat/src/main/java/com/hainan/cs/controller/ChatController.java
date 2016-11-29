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
import com.hainan.cs.bean.EntertainmentRecord;
import com.hainan.cs.bean.GameRecord;
import com.hainan.cs.bean.TechRecord;
import com.hainan.cs.dao.EducationDaoImp;
import com.hainan.cs.dao.EntertainmentDaoImp;
import com.hainan.cs.dao.GameDaoImp;
import com.hainan.cs.dao.TechDaoImp;
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
		TechDaoImp tdi=context.getBean(TechDaoImp.class);
		GameDaoImp gdi=context.getBean(GameDaoImp.class);
		EntertainmentDaoImp endi=context.getBean(EntertainmentDaoImp.class);
		
		List<EducationRecord> elist=edi.queryEducationRecord();
		List<TechRecord> tlist=tdi.query();
		List<GameRecord> glist=gdi.query();
		List<EntertainmentRecord> enlist=endi.query();
		
		List<JSONObject> jlist=new ArrayList<JSONObject>();
		List<JSONObject> tjlist=new ArrayList<JSONObject>();
		List<JSONObject> gjlist=new ArrayList<JSONObject>();
		List<JSONObject> enjlist=new ArrayList<JSONObject>();
		//教育聊天室记录
		for(int i=0;i<elist.size();i++){
			EducationRecord er=elist.get(i);
			JSONObject json=new JSONObject();
			json.append("username", er.getUsername());
			String time=er.getSdate().toString();
			json.append("time", time);
			json.append("content", er.getContent());
			jlist.add(json);
		}
		//科技聊天室记录
		for(int i=0;i<tlist.size();i++){
			TechRecord tr=tlist.get(i);
			JSONObject json=new JSONObject();
			json.append("username", tr.getUserneame());
			String time=tr.getSdate().toString();
			json.append("time", time);
			json.append("content", tr.getContent());
			tjlist.add(json);
		}
		//娱乐聊天室记录
		for(int i=0;i<enlist.size();i++){
			EntertainmentRecord enr=enlist.get(i);
			JSONObject json=new JSONObject();
			json.append("username", enr.getUsername());
			String time=enr.getSdate().toString();
			json.append("time", time);
			json.append("content", enr.getContent());
			enjlist.add(json);
		}
		//游戏聊天室记录
		for(int i=0;i<glist.size();i++){
			GameRecord gr=glist.get(i);
			JSONObject json=new JSONObject();
			json.append("username", gr.getUsername());
			String time=gr.getSdate().toString();
			json.append("time", time);
			json.append("content", gr.getContent());
			gjlist.add(json);
		}
		
		mav.addObject("erecord", jlist);
		mav.addObject("enrecord", enjlist);
		mav.addObject("grecord", gjlist);
		mav.addObject("trecord", tjlist);
		mav.addObject("username", user.getUsername());
		mav.setViewName("chat");
		context.close();
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
		er.setSdate(date);
		er.setUserid(user.getUserid());
		er.setUsername(user.getUsername());
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		EducationDaoImp edi=context.getBean(EducationDaoImp.class);
		edi.isnert(er);
		context.close();
		return map;
	}
	@RequestMapping(value="/enchat")
	@ResponseBody
	public Map<String,EntertainmentRecord> enchat(String message){
		System.out.println(message);
		Map<String, EntertainmentRecord> map=new HashMap<String,EntertainmentRecord>();
		UserSingleton user=UserSingleton.getInstance();
		Date date=new Date();
		EntertainmentRecord er=new EntertainmentRecord();
		er.setContent(message);
		er.setSdate(date);
		er.setUserid(user.getUserid());
		er.setUsername(user.getUsername());
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		EntertainmentDaoImp edi=context.getBean(EntertainmentDaoImp.class);
		edi.insert(er);
		context.close();
		return map;
	}
	@RequestMapping(value="/gchat")
	@ResponseBody
	public Map<String,GameRecord> gchat(String message){
		System.out.println(message);
		Map<String, GameRecord> map=new HashMap<String,GameRecord>();
		UserSingleton user=UserSingleton.getInstance();
		Date date=new Date();
		GameRecord er=new GameRecord();
		er.setContent(message);
		er.setSdate(date);
		er.setUserid(user.getUserid());
		er.setUsername(user.getUsername());
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		GameDaoImp edi=context.getBean(GameDaoImp.class);
		edi.insert(er);
		context.close();
		return map;
	}
	@RequestMapping(value="/tchat")
	@ResponseBody
	public Map<String,TechRecord> tchat(String message){
		System.out.println(message);
		Map<String, TechRecord> map=new HashMap<String,TechRecord>();
		UserSingleton user=UserSingleton.getInstance();
		Date date=new Date();
		TechRecord er=new TechRecord();
		er.setContent(message);
		er.setSdate(date);
		er.setUserid(user.getUserid());
		er.setUserneame(user.getUsername());
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		TechDaoImp edi=context.getBean(TechDaoImp.class);
		edi.insert(er);
		context.close();
		return map;
	}
}
