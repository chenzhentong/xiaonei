package com.xiaonei.domain;

public class Uservisited {
	private Integer id;
	private Users visitor;
	private Users interviewee;
	
	private java.util.Date visitedDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Users getVisitor() {
		return visitor;
	}
	public void setVisitor(Users visitor) {
		this.visitor = visitor;
	}
	public Users getInterviewee() {
		return interviewee;
	}
	public void setInterviewee(Users interviewee) {
		this.interviewee = interviewee;
	}
	public java.util.Date getVisitedDate() {
		return visitedDate;
	}
	public void setVisitedDate(java.util.Date visitedDate) {
		this.visitedDate = visitedDate;
	}

}
