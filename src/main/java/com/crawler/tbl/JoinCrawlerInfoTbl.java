package com.crawler.tbl;

import java.util.Date;

/**
 * 爬取信息表
 * @author hjd
 * @date 2016年9月22日
 * @table(COLUMNS)
 */
public class JoinCrawlerInfoTbl {
		/**
		 * 
		 * @column(ID_)
		*/
		private String id;
		
		/**
		 * 标题
		 * @column(TITLE_)
		*/
		private String title;
		
		/**
		 * 描述
		 * @column(DESC_)
		*/
		private String desc;
		
		/**
		 * 内容
		 * @column(CONTENT_)
		*/
		private String content;
		
		/**
		 * 发布人
		 * @column(AUTHOR_)
		*/
		private String author;
		
		/**
		 * 发布时间
		 * @column(PUBLISH_TIME_)
		*/
		private String publishTime;
		
		/**
		 * 浏览数
		 * @column(VIEW_COUNT_)
		*/
		private String viewCount;
		
		/**
		 * 来源type
		 * @column(FROM_TYPE_)
		*/
		private String fromType;
		
		/**
		 * 来源url
		 * @column(FROM_URL_)
		*/
		private String fromUrl;
		
		/**
		 * 
		 * @column(CREATE_TIME_)
		*/
		private Date createTime;
		
		/**
		 * 
		 * @column(CREATE_USER_)
		*/
		private String createUser;
		
		/**
		 * 
		 * @column(UPDATE_TIME_)
		*/
		private Date updateTime;
		
		/**
		 * 
		 * @column(UPDATE_USER_)
		*/
		private String updateUser;
		
	
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
		
		public String getAuthor(){
			return author;
		}
		public void setAuthor(String author){
			this.author = author;
		}
		
		public String getPublishTime(){
			return publishTime;
		}
		public void setPublishTime(String publishTime){
			this.publishTime = publishTime;
		}
		
		public String getViewCount(){
			return viewCount;
		}
		public void setViewCount(String viewCount){
			this.viewCount = viewCount;
		}
		
		public String getFromType(){
			return fromType;
		}
		public void setFromType(String fromType){
			this.fromType = fromType;
		}
		
		public String getFromUrl(){
			return fromUrl;
		}
		public void setFromUrl(String fromUrl){
			this.fromUrl = fromUrl;
		}
		
		public Date getCreateTime(){
			return createTime;
		}
		public void setCreateTime(Date createTime){
			this.createTime = createTime;
		}
		
		public String getCreateUser(){
			return createUser;
		}
		public void setCreateUser(String createUser){
			this.createUser = createUser;
		}
		
		public Date getUpdateTime(){
			return updateTime;
		}
		public void setUpdateTime(Date updateTime){
			this.updateTime = updateTime;
		}
		
		public String getUpdateUser(){
			return updateUser;
		}
		public void setUpdateUser(String updateUser){
			this.updateUser = updateUser;
		}
		
	
	@Override
	public String toString() {
		return "JoinCrawlerInfoTbl[id="+id+",title="+title+",desc="+desc+",content="+content+",author="+author 				+",publishTime="+publishTime+",viewCount="+viewCount+",fromType="+fromType+",fromUrl="+fromUrl+",createTime="+createTime 				+",createUser="+createUser+",updateTime="+updateTime+",updateUser="+updateUser+"]";
	}

}
