package com.crawler.dao.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crawler.dao.ColumnsDao;
import com.crawler.po.ColumnsPo;

@Repository
public class ColumnsDaoImpl implements ColumnsDao {
    @Resource
    private SqlSession sqlSession;

    public List<ColumnsPo> list(ColumnsPo columnPo) {
        return sqlSession.selectList("list", columnPo);
    }

}
