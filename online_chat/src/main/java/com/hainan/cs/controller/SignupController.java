package com.hainan.cs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hainan.cs.bean.UserBean;
import com.hainan.cs.dao.UserDaoImp;

@Controller
@RequestMapping(value="/signup")
public class SignupController {
	@RequestMapping()
	public ModelAndView signup(){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("signup");
		mav.addObject("tag", 0);
		return mav;
	}
	@RequestMapping(value="/adduser")
	public ModelAndView addUser(String username,String password,String email,String phone,String address){
		ModelAndView mav=new ModelAndView();
		UserBean user=new UserBean();
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setUsername(username);
		user.setAddress(address);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/application-config.xml");
		UserDaoImp udi=context.getBean(UserDaoImp.class);
		List<UserBean> userlist=udi.queryUser(username);
		if(userlist.size()==0){
			udi.insert(user);
			mav.setViewName("login");
		}else{
			//用户名已经存在
			mav.setViewName("signup");
			mav.addObject("tag", 1);
		}
		return mav;
	}
	
	@RequestMapping(value="/check")
	@ResponseBody
	public Map<String, Object> check(String username){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring/application-config.xml");
		UserDaoImp udi=context.getBean(UserDaoImp.class);
		List<UserBean> ulist=udi.queryUser(username);
		Map<String,Object> map=new HashMap<String,Object>();
		if(ulist.size()!=0){
			map.put("msg", "用户名已经存在");
		}else {
			map.put("msg", "用户名可以使用");
		}
		context.close();
		return map;
	}
}
