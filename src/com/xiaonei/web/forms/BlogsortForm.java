package com.xiaonei.web.forms;

import org.apache.struts.action.ActionForm;

public class BlogsortForm extends ActionForm {
	private Integer id;
	private String sort;
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
	public BlogsortForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
