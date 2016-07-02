package com.crawler.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crawler.po.UserPo;
import com.crawler.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);
	@Resource
	private UserService userService;
	
	@RequestMapping("test")
	public void testUser(String id){
		UserPo userPo = userService.getUserById(id);
		System.out.println(userPo.getName());
	}
	
	@RequestMapping("test2")
	public void testUser2(){
		List<UserPo> pos = userService.getUser();
		System.out.println(pos.size());
	}
	
	@RequestMapping("save")
	public void save(UserPo userPo){
		userService.add(userPo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



















