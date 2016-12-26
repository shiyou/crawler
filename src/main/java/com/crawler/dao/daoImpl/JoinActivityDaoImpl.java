package com.crawler.dao.daoImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.common.GenericDAOImpl;
import com.crawler.dao.JoinActivityDao;
import com.crawler.po.JoinActivityPo;

@Repository("JoinActivityDao")
public class JoinActivityDaoImpl extends GenericDAOImpl<JoinActivityPo, Serializable>implements JoinActivityDao {
	
}
