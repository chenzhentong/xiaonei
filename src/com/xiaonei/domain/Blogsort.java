package com.xiaonei.domain;

import java.util.Set;

public class Blogsort {
	private Integer id;
	private String sort;
	private Set<Blog> blogs;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	public Set<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}
	public Blogsort() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
