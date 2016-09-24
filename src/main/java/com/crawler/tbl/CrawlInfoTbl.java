package com.crawler.tbl;

import java.util.Date;

/**
 * 
 * @author hjd
 * @date 2016年9月22日
 * @table(COLUMNS)
 */
public class CrawlInfoTbl {
		/**
		 * 
		 * @column(id_)
		*/
		private String id;
		/**
		 * 标题
		 * @column(title_)
		*/
		private String title;
		/**
		 * 描述
		 * @column(desc_)
		*/
		private String desc;
		/**
		 * 内容
		 * @column(content_)
		*/
		private String content;
		/**
		 * 图片
		 * @column(img_)
		*/
		private String img;
		/**
		 * 发布用户
		 * @column(pulish_author_)
		*/
		private String pulishAuthor;
		/**
		 * 发布时间
		 * @column(pulish_time_)
		*/
		private Date pulishTime;
		/**
		 * 请求来源
		 * @column(requst_from_)
		*/
		private String requstFrom;
		/**
		 * 请求链接
		 * @column(requst_url_)
		*/
		private String requstUrl;
		/**
		 * 创建人
		 * @column(create_by_)
		*/
		private String createBy;
		/**
		 * 创建时间
		 * @column(create_time_)
		*/
		private Date createTime;
	
		public String getId(){
			return id;
		}
		public void setId(String id){
			this.id = id;
		}
		
		public String getTitle(){
			return title;
		}
		public void setTitle(String title){
			this.title = title;
		}
		
		public String getDesc(){
			return desc;
		}
		public void setDesc(String desc){
			this.desc = desc;
		}
		
		public String getContent(){
			return content;
		}
		public void setContent(String content){
			this.content = content;
		}
		
		public String getImg(){
			return img;
		}
		public void setImg(String img){
			this.img = img;
		}
		
		public String getPulishAuthor(){
			return pulishAuthor;
		}
		public void setPulishAuthor(String pulishAuthor){
			this.pulishAuthor = pulishAuthor;
		}
		
		public Date getPulishTime(){
			return pulishTime;
		}
		public void setPulishTime(Date pulishTime){
			this.pulishTime = pulishTime;
		}
		
		public String getRequstFrom(){
			return requstFrom;
		}
		public void setRequstFrom(String requstFrom){
			this.requstFrom = requstFrom;
		}
		
		public String getRequstUrl(){
			return requstUrl;
		}
		public void setRequstUrl(String requstUrl){
			this.requstUrl = requstUrl;
		}
		
		public String getCreateBy(){
			return createBy;
		}
		public void setCreateBy(String createBy){
			this.createBy = createBy;
		}
		
		public Date getCreateTime(){
			return createTime;
		}
		public void setCreateTime(Date createTime){
			this.createTime = createTime;
		}
		
	
	@Override
	public String toString() {
		return "CrawlInfoTbl[id="+id+",title="+title+",desc="+desc+",content="+content+",img="+img+",pulishAuthor="+pulishAuthor+",pulishTime="+pulishTime+",requstFrom="+requstFrom+",requstUrl="+requstUrl+",createBy="+createBy+",createTime="+createTime+"]";
	}

}
