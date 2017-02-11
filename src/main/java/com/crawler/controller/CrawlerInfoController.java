package com.crawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crawler.po.CrawlerInfoPo;
import com.crawler.service.CrawlerInfoService;

@Controller
@RequestMapping(value="/crawlerInfo")
public class CrawlerInfoController {
	
	@Autowired
	public CrawlerInfoService crawlerInfoService;
	
	@RequestMapping("test")
	public void test(){
		CrawlerInfoPo crawlerInfoPo = new CrawlerInfoPo();
		crawlerInfoPo.setContent("hhhh");
		crawlerInfoService.save(crawlerInfoPo);
	}

}
