package com.crawler.service;

import java.util.List;

import com.crawler.po.UserPo;

public interface UserService {
	
	UserPo getUserById(String id);
	
	List<UserPo> getUser();
	
	int add(UserPo userPo);

}
