package com.xiaonei.web.forms;

import org.apache.struts.action.ActionForm;

public class SpecialfriendForm extends ActionForm {
	private Integer id;
	private Integer userId1;
	private Integer userId2;
	private String description;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId1() {
		return userId1;
	}
	public void setUserId1(Integer userId1) {
		this.userId1 = userId1;
	}
	public Integer getUserId2() {
		return userId2;
	}
	public void setUserId2(Integer userId2) {
		this.userId2 = userId2;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
