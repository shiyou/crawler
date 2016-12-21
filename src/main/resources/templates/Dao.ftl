package com.crawler.dao;

import java.io.Serializable;

import com.common.GenericDAO;
import com.crawler.po.CrawlerInfoPo;

/**
 * ${rawObject.tablesTbl.tableComment}
 * @author hjd
 * @date 2016年9月22日
 * @table(COLUMNS)
 */
public interface UserDao extends GenericDAO<CrawlerInfoPo, Serializable>{

	
	List<UserPo> getUser();

	UserPo getUserById(String userId);
	
	int add(UserPo userPo);
}
