package crawler.news;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import us.codecraft.webmagic.Spider;


@Controller
@RequestMapping("/xueyoudao")
public class XueyoudaoPageCrawler {
	
	Logger logger = Logger.getLogger(XueyoudaoPageCrawler.class);
	
	@ResponseBody
	@RequestMapping("run")
	public String runCrawler(){
		logger.info("crawler begin ........");
		Spider.create(new XueyoudaoPageProcessor())
		.addUrl("http://xue.youdao.com/w?page=1&type=all")
		.addPipeline(new XueyoudaoPagePipeline())
		.thread(5)
		.run();
		return "";
	}

}
