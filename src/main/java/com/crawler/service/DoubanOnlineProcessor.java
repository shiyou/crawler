package com.crawler.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import crawler.news.XueyoudaoPagePipeline;
import crawler.news.XueyoudaoPageProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * @author hjd
 * @date 2016年9月18日
 */
public class DoubanOnlineProcessor implements PageProcessor{
	
	private Site site = Site.me().setRetrySleepTime(3).setSleepTime(1000).setUseGzip(true);

	@Override
	public void process(Page page) {
//		Map<String, List<String>> contentMap = new HashMap<>();
		List<String> images = new ArrayList<>();
		List<String> nameLinks = new ArrayList<>();
		List<String> names = new ArrayList<>();
		List<String> contents = page.getHtml().xpath("//*[@id='content']/div/div[1]/div[3]/div/").all();
		for(String content:contents){
			String image = new Html(content).xpath("//a/img/@src").get();
			String nameLink = new Html(content).xpath("//div[@class='p1']/a/@href").get();
			String name = new Html(content).xpath("//div[@class='p1']/a/tidyText()").get();
			System.out.println("image:"+image+"|name:"+name+"|namelink:"+nameLink);
			images.add(image);
			nameLinks.add(nameLink);
			names.add(name);
		}
		if(images!=null) {
			for(int index=0;index<images.size() ; index++){
				URL source;
				try {
					if(images.get(index)!=null && images.get(index).contains(".jpg")){
						source = new URL(images.get(index).replace("thumb", "photo"));
						String pathname ="C:\\image\\"+index+".jpg";
						File destination = new File(pathname);
						FileUtils.copyURLToFile(source, destination);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public Site getSite() {
		site.setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0");
		site.setDomain("douban.com");
		return site;
	}
	
	
	
	public static void main(String[] args) throws IOException{
		Spider.create(new DoubanOnlineProcessor())
		.addUrl("https://www.douban.com/online/12168474/album/155485090/")
		.thread(5)
		.run();
		/*URL source = new URL("https://img1.doubanio.com/view/photo/photo/public/p2273282367.jpg");
		String pathname ="C:\\image\\t.jpg";
		File destination = new File(pathname);
		FileUtils.copyURLToFile(source, destination);*/
	}

}
