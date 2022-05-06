package com.tntb.model;

import java.sql.Timestamp;

public class NewsModel {
	private int newID;
	private int authorID;
	private String imageNew;
	private String title;
	private String brief;
	private String content;
	private Timestamp createDate;
	private Timestamp updateDate;
	public NewsModel(int newID, int authorID, String imageNew, String title, String brief, String content,
			Timestamp createDate, Timestamp updateDate) {
		super();
		this.newID = newID;
		this.authorID = authorID;
		this.imageNew = imageNew;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public NewsModel() {
		super();
	}
	public int getNewID() {
		return newID;
	}
	public void setNewID(int newID) {
		this.newID = newID;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getImageNew() {
		return imageNew;
	}
	public void setImageNew(String imageNew) {
		this.imageNew = imageNew;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "NewsModel [newID=" + newID + ", authorID=" + authorID + ", imageNew=" + imageNew + ", title=" + title
				+ ", brief=" + brief + ", content=" + content + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}
	
	
	
}
