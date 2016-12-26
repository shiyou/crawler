package crawler.processor;

import java.util.List;

import com.crawler.po.JoinCrawlerInfoPo;

import crawler.pipeline.WeixinPipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 爬取10页即可
 * @author hjd
 * @date 2016年12月26日
 */
//http://weixin.sogou.com/weixin?usip=null&query=%E4%BD%9B%E5%B1%B1+%E6%B4%BB%E5%8A%A8&from=tool&ft=&tsn=1&et=&interation=null&type=2&wxid=&page=1&ie=utf8
public class WeixinProcessor implements PageProcessor{
	
	private Site site = Site.me().setRetrySleepTime(1000).setSleepTime(10000)
			.setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

	public static String URL = "http://weixin.sogou.com/weixin?type=2&ie=utf8&query=%E4%BD%9B%E5%B1%B1%20%E6%B4%BB%E5%8A%A8&tsn=1&ft=&et=&interation=null&wxid=&usip=null&from=tool";
	public static boolean fistFlag = false;
	@Override
	public void process(Page page) {
		if(!fistFlag){
			System.out.println(page.getHtml());
			List<String> pageUrls = page.getHtml().links().regex(".*\\?usip=null&query=.*").all();	//获取所有分页链接
			page.addTargetRequests(pageUrls);
			fistFlag = true;
		}else{
//			List<String> contentUrls = page.getHtml().links().regex(".*http://mp.weixin.qq.com\\/s\\?src=3.*").all();
			List<String> contentUrls = page.getHtml().xpath("//div[@class='txt-box']/h3/a/@href").all();		//获取所有内容链接
			page.addTargetRequests(contentUrls);
		}
		if(page.getUrl().get().contains("src=3&timestamp")){
			JoinCrawlerInfoPo po = new JoinCrawlerInfoPo();
			po.setTitle(page.getHtml().xpath("//*[@id='activity-name']/tidyText()").get());
			po.setPublishTime(page.getHtml().xpath("//*[@id='post-date']/tidyText()").get());
			po.setAuthor(page.getHtml().xpath("//*[@id='img-content']/div[1]/em[2]/tidyText()").get());
			po.setContent(page.getHtml().xpath("//*[@id='js_content']").get());
			po.setViewCount(page.getHtml().xpath("//*[@id='sg_readNum3']").get());
			po.setFromType("weixin");
			po.setFromUrl(page.getUrl().get());
			page.putField("joinCrawlerInfoPo", po);	//内容
		}
	}

	@Override
	public Site getSite() {
		return site;
	}
	
	public static void main(String[] args){
		Spider.create(new WeixinProcessor())
		.addUrl(URL)
		.addPipeline(new WeixinPipeline())
		.thread(1)
		.run();
	}

}
