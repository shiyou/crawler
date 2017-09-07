package com.crawler.dao.daoImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.common.GenericDAOImpl;
import com.crawler.dao.${rawObject.name}Dao;
import com.crawler.po.${rawObject.name}Po;

@Repository("${rawObject.name}Dao")
public class ${rawObject.name}DaoImpl extends GenericDAOImpl<${rawObject.name}Po, Serializable>implements ${rawObject.name}Dao {
	
}
