package crawler.pipeline;

import com.crawler.po.JoinCrawlerInfoPo;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author hjd
 * @date 2016年12月26日
 */
public class WeixinPipeline implements Pipeline{

	@Override
	public void process(ResultItems resultItems, Task task) {
		JoinCrawlerInfoPo po = resultItems.get("joinCrawlerInfoPo");
		if(po!=null){
			System.out.println(po.toString());
		}
	}

}
