package com.xiaonei.web.forms;

import org.apache.struts.action.ActionForm;

import com.xiaonei.domain.Blogsort;

public class BlogForm extends ActionForm {
	
	private Integer id;
	private String title;
	private String content;
	private String blogsort;
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
	public String getBlogsort() {
		return blogsort;
	}
	public void setBlogsort(String blogsort) {
		this.blogsort = blogsort;
	}
	

}
