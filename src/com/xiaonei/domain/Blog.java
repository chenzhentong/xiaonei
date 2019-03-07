package com.xiaonei.domain;

import java.util.Set;

public class Blog {
	private Integer id;
	private String title;
	private String content;
	private Blogsort blogsort;
	private Users publisher;
	private java.util.Date publishDate; 
	private Set<Blogagree> agrees;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Blogsort getBlogsort() {
		return blogsort;
	}
	public void setBlogsort(Blogsort blogsort) {
		this.blogsort = blogsort;
	}
	public Users getPublisher() {
		return publisher;
	}
	public void setPublisher(Users publisher) {
		this.publisher = publisher;
	}
	public java.util.Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(java.util.Date publishDate) {
		this.publishDate = publishDate;
	}
	public Set<Blogagree> getAgrees() {
		return agrees;
	}
	public void setAgrees(Set<Blogagree> agrees) {
		this.agrees = agrees;
	}
	
	
}
