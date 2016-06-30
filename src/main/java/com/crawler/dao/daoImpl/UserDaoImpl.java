package com.crawler.dao.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crawler.dao.UserDao;
import com.crawler.po.UserPo;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	
	@Resource
	private SqlSession sqlSession;

	public List<UserPo> getUser() {
		return sqlSession.selectList("getUser");
	}

	public UserPo getUserById(String id) {
		return sqlSession.selectOne("getUserById", id);
	}

	
		
}
