package com.crawler.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawler.dao.ColumnsDao;
import com.crawler.po.ColumnsPo;
import com.crawler.service.ColumnsService;

@Service
public class ColumnsServviceImpl implements ColumnsService {

    @Resource
    private ColumnsDao columnDao;

    public List<ColumnsPo> list(ColumnsPo columnPo) {
        return columnDao.list(columnPo);
    }

}
