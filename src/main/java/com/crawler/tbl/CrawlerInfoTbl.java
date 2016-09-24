package com.crawler.tbl;

import java.util.Date;


public class CrawlerInfoTbl {
	private String id;
	private String title;
	private String desc;
	private String content;
	private String img;
	private String pulishAuthor;
	private Date pulishTime;
	private String requstFrom;
	private String requstUrl;
	private String createBy;
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getPulishAuthor() {
		return pulishAuthor;
	}
	public void setPulishAuthor(String pulishAuthor) {
		this.pulishAuthor = pulishAuthor;
	}
	public Date getPulishTime() {
		return pulishTime;
	}
	public void setPulishTime(Date pulishTime) {
		this.pulishTime = pulishTime;
	}
	public String getRequstFrom() {
		return requstFrom;
	}
	public void setRequstFrom(String requstFrom) {
		this.requstFrom = requstFrom;
	}
	public String getRequstUrl() {
		return requstUrl;
	}
	public void setRequstUrl(String requstUrl) {
		this.requstUrl = requstUrl;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "CrawlerInfoTbl [id=" + id + ", title=" + title + ", desc=" + desc + ", content=" + content + ", img="
				+ img + ", pulishAuthor=" + pulishAuthor + ", pulishTime=" + pulishTime + ", requstFrom=" + requstFrom
				+ ", requstUrl=" + requstUrl + ", createBy=" + createBy + ", createTime=" + createTime + "]";
	}
	
	

}
