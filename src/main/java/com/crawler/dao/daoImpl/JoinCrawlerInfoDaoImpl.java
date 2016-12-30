package com.crawler.dao.daoImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.common.GenericDAOImpl;
import com.crawler.dao.JoinCrawlerInfoDao;
import com.crawler.po.JoinCrawlerInfoPo;

@Repository("JoinCrawlerInfoDao")
public class JoinCrawlerInfoDaoImpl extends GenericDAOImpl<JoinCrawlerInfoPo, Serializable>implements JoinCrawlerInfoDao {
	
}
