package com.crawler.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawler.dao.CrawlerInfoDao;
import com.crawler.po.CrawlerInfoPo;
import com.crawler.service.CrawlerInfoService;

@Service("crawlerInfoService")
public class CrawlerInfoServiceImpl implements CrawlerInfoService {

    @Autowired
    private CrawlerInfoDao crawlerinfoDao;

    @Override
    public void save(CrawlerInfoPo crawlerInfoPo) {
        crawlerinfoDao.save(crawlerInfoPo);
    }

}
