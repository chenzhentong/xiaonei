package com.xiaonei.web.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class AlbumForm extends ActionForm {
	private Integer id;
	private String title;
	private FormFile  photo;
	private String sort;
	
	
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
	public FormFile getPhoto() {
		return photo;
	}
	public void setPhoto(FormFile  photo) {
		this.photo = photo;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	

}
