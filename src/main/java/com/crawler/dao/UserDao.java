package com.crawler.dao;

import java.util.List;

import com.crawler.po.UserPo;

public interface UserDao {

	
	List<UserPo> getUser();

	UserPo getUserById(String userId);
	
	int add(UserPo userPo);
}
