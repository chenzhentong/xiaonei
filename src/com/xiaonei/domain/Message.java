package com.xiaonei.domain;

import java.util.Set;

public class Message {
	private Integer id;
	private String content;
	private Users user;
	private Users host;
	private java.util.Date messageDate;
	private Set<Usermessagecomment> usermessagecomments;
	
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
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Users getHost() {
		return host;
	}
	public void setHost(Users host) {
		this.host = host;
	}
	public java.util.Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(java.util.Date messageDate) {
		this.messageDate = messageDate;
	}
	public Set<Usermessagecomment> getUsermessagecomments() {
		return usermessagecomments;
	}
	public void setUsermessagecomments(Set<Usermessagecomment> usermessagecomments) {
		this.usermessagecomments = usermessagecomments;
	}
	
	
	

}
