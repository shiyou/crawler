package com.crawler.dao;

import java.util.List;

import com.crawler.po.ColumnsPo;

public interface ColumnsDao {
	
	List<ColumnsPo> list(ColumnsPo columnPo);

}
