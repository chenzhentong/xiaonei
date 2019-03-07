package com.xiaonei.web.forms;

import org.apache.struts.action.ActionForm;

import com.xiaonei.domain.Message;
import com.xiaonei.domain.Users;

public class UsermessagecommentForm extends ActionForm{
	private Integer id;
	private Integer senderId;
	private Integer receiverId;
	private Integer  messageId;
	private String content;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public Integer getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	

}
