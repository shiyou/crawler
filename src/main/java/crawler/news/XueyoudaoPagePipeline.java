package crawler.news;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;

import com.crawler.po.CrawlerInfoPo;
import com.crawler.service.CrawlerInfoService;
import com.crawler.util.StringUtil;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Service
public class XueyoudaoPagePipeline implements Pipeline{
	
	@Autowired
	private CrawlerInfoService crawlerInfoService;
	
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		crawlerInfoService = ContextLoader.getCurrentWebApplicationContext().getBean(CrawlerInfoService.class);
		 System.out.println("get page: " + resultItems.getRequest().getUrl());
		 List<XueyoudaoPo> xueyoudaoPos = resultItems.get("xueyoudaoPolist");
		 for(XueyoudaoPo xueyoudaoPo : xueyoudaoPos){
			 CrawlerInfoPo crawlerInfoPo = new CrawlerInfoPo();
			 crawlerInfoPo.setId(String.valueOf(Math.random()*1000000));
			 crawlerInfoPo.setContent(xueyoudaoPo.getContent().replaceAll("\\n|\r", ""));
			 crawlerInfoPo.setImg(xueyoudaoPo.getImg());
			 crawlerInfoPo.setPulishTime(StringUtil.parseDate(xueyoudaoPo.getPublishDate().replaceAll("\\s", ""), StringUtil.yyyy_mm_dd));
			 crawlerInfoPo.setCreateTime(new Date());
			 crawlerInfoService.save(crawlerInfoPo);
		 }
	        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
	            System.out.println(entry.getKey() + ":\t" + entry.getValue());
	        }
	}

	public void setCrawlerInfoService(CrawlerInfoService crawlerInfoService) {
		this.crawlerInfoService = crawlerInfoService;
	}
	

}
