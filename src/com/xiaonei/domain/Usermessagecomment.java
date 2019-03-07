package com.xiaonei.domain;

public class Usermessagecomment {
	private Integer id;
	private Users sender;
	private Users receiver;
	private Message  message;
	private String content;
	private java.util.Date publishDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Users getSender() {
		return sender;
	}
	public void setSender(Users sender) {
		this.sender = sender;
	}
	public Users getReceiver() {
		return receiver;
	}
	public void setReceiver(Users receiver) {
		this.receiver = receiver;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.util.Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(java.util.Date publishDate) {
		this.publishDate = publishDate;
	}
	
	

}
