package com.xiaonei.web.forms;

import org.apache.struts.action.ActionForm;

public class MessageForm extends ActionForm {
	private Integer id;
	private String content;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	} 
	
	

}
