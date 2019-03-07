package com.xiaonei.domain;

public class Mail {
	private Integer id;
	private Users sender;
	private Users receiver;
	private String content;
	private java.util.Date sendDate;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.util.Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(java.util.Date sendDate) {
		this.sendDate = sendDate;
	}
	
	
}