package crawler.news;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class XueyoudaoPageProcessor implements PageProcessor{
	
	private Site site = Site.me().setRetrySleepTime(3).setSleepTime(1000);

	@Override
	public void process(Page page) {
		List<String> contentList = page.getHtml().xpath("//*[@id='bd']/div/div[2]/div[1]/ul/li").all();
		List<XueyoudaoPo> xueyoudaoPolist = new ArrayList<>();
		 boolean exist = false;
		for(int i=0 ;i<contentList.size()-1;i++){
			String content = new Html(contentList.get(i)).xpath("//div[@class='example english']/div[@class='content']/tidyText()").get();
			String img = new Html(contentList.get(i)).xpath("//div[@class='example english']/div[@class='pic-show']/img/@src").get();
			String publishDate = new Html(contentList.get(i)).xpath("//div[@class='example english']/h2/tidyText()").get();
		/*	page.putField("publishDate", new Html(contentList.get(i)).xpath("//div[@class='example english']/h2/tidyText()"));
			page.putField("content", new Html(contentList.get(i)).xpath("//div[@class='example english']/div[@class='content']/tidyText()"));
			page.putField("img", new Html(contentList.get(i)).xpath("//div[@class='example english']/div[@class='pic-show']/img/@src"));*/
			XueyoudaoPo xueyoudaoPo = new XueyoudaoPo();
			xueyoudaoPo.setContent(content);
			xueyoudaoPo.setImg(img);
			xueyoudaoPo.setPublishDate(publishDate);
			xueyoudaoPolist.add(xueyoudaoPo);
			exist = true;
		}
		page.putField("xueyoudaoPolist", xueyoudaoPolist);
		if(!exist){
			page.setSkip(true);
		}
		page.addTargetRequest(getNextPageURL(page.getUrl().get()));
	}

	@Override
	public Site getSite() {
		return site;
	}
	
	
	public static String getNextPageURL(String url){
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(url);
		String nextUrl = "";
		if(matcher.find()){
			nextUrl =url.replaceFirst(matcher.group(0), String.valueOf(Integer.parseInt(matcher.group(0))+1));
		}
		return nextUrl;
	}
	
	public static void main(String[] args){
		Spider.create(new XueyoudaoPageProcessor())
				.addUrl("http://xue.youdao.com/w?page=1&type=all")
				.addPipeline(new XueyoudaoPagePipeline())
				.thread(5)
				.run();
//		getNextPageURL("http://xue.youdao.com/w?page=1&type=all");
		
//		BaiduBaikePageProcessor.main(args);
	}
	
	
	

}
