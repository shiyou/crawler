package com.crawler.tbl;

import java.util.Date;

/**
 * 活动图片表
 * @author hjd
 * @date 2016年9月22日
 * @table(COLUMNS)
 */
public class JoinActivityTbl {
		/**
		 * ID
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
		 * 发布者
		 * @column(author_)
		*/
		private String author;
		
		/**
		 * 创建时间
		 * @column(create_time_)
		*/
		private Date createTime;
		
		/**
		 * 创建人
		 * @column(create_user_)
		*/
		private String createUser;
		
		/**
		 * 更新时间
		 * @column(update_time_)
		*/
		private Date updateTime;
		
		/**
		 * 更新人
		 * @column(update_user_)
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
		return "JoinActivityTbl[id="+id+",title="+title+",desc="+desc+",content="+content+",author="+author 				+",createTime="+createTime+",createUser="+createUser+",updateTime="+updateTime+",updateUser="+updateUser+"]";
	}

}
