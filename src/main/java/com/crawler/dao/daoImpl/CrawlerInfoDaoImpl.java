package com.crawler.dao.daoImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.common.GenericDAOImpl;
import com.crawler.dao.CrawlerInfoDao;
import com.crawler.po.CrawlerInfoPo;

@Repository("crawlerInfoDao")
public class CrawlerInfoDaoImpl extends GenericDAOImpl<CrawlerInfoPo, Serializable>implements CrawlerInfoDao {
	
}
