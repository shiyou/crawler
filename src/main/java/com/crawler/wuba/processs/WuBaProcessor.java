package com.crawler.wuba.processs;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

import org.junit.Test;

import com.sun.media.jfxmedia.control.VideoDataBuffer;

import crawler.news.GithubRepoPageProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 58同城爬虫处理器
 *
 * @author hjd
 */
public class WuBaProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
//		page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
//		page.putField("title", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("title", page.getHtml().xpath("/html/body/div[4]/div[1]/h1/text()").toString());
        page.putField("price", page.getHtml().xpath("/html/body/div[4]/div[2]/div[2]/div[1]/div[1]/div/span[1]/b/text()").toString());
        page.putField("description", page.getHtml().xpath("/html/body/div[4]/div[3]/div[1]/div[1]/ul/allText()").toString());
        if (page.getResultItems().get("price") == null) {
            // skip this page
            page.setSkip(true);
        }
        page.putField("urlList", page.getHtml().xpath("//*[@id='housePicList']/li[@class='pic']/img/@src").get());
//		page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
        try {
            page.addTargetRequest("http://gz.58.com/zufang/31035159460431x.shtml?" + URLEncoder.encode("adtype=3", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        String url = "psid=131103886196936794275838911&cookie=|||c5/ns1h7dBu2I/1RIWdRAg==&apptype=0&entinfo=30035722780866_0&fzbref=0&key=&pubid=16389494&params=busitime^desc&local=1654&trackkey=30035722780866_7dd63ecc-03c0-4372-b7aa-aeaae0d48e15_20170812115020_1502509820012&fcinfotype=gz";
//		String codeUrl = Base64.getDecoder().decode(url.getBytes()).toString();
//		String enCodeUrl = Base64.getEncoder().encodeToString(url.getBytes());
        String urlCode = URLEncoder.encode(url, "utf-8").toString();
        System.out.println(urlCode);

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        Spider.create(new WuBaProcessor())
                // 从"https://github.com/code4craft"开始抓
                .addUrl("http://gz.58.com/zufang/30035722780866x.shtml?" + URLEncoder.encode("psid=131103886196936794275838911&cookie=|||c5/ns1h7dBu2I/1RIWdRAg==&apptype=0&entinfo=30035722780866_0&fzbref=0&key=&pubid=16389494&params=busitime^desc&local=1654&trackkey=30035722780866_7dd63ecc-03c0-4372-b7aa-aeaae0d48e15_20170812115020_1502509820012&fcinfotype=gz", "UTF-8"))
                .addPipeline(new ConsolePipeline())
                // 开启5个线程抓取
                .thread(5)
                // 启动爬虫
                .run();
    }


}
