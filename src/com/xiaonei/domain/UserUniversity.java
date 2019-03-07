package com.xiaonei.domain;

public class UserUniversity {
	private Integer id;

	private Users users;
    private University university;
	private Integer uniYear;
	private String userType;
	private String college;
	private String drom;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getUniYear() {
		return uniYear;
	}
	public void setUniYear(Integer uniYear) {
		this.uniYear = uniYear;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getDrom() {
		return drom;
	}
	public void setDrom(String drom) {
		this.drom = drom;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	
}