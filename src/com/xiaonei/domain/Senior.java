package com.xiaonei.domain;

import java.util.Set;

public class Senior {
	private Integer id;
	private String name;
	private City city;
	private Town town;
	private Set<UserSenior> userSeniors;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Town getTown() {
		return town;
	}
	public void setTown(Town town) {
		this.town = town;
	}
	public Set<UserSenior> getUserSeniors() {
		return userSeniors;
	}
	public void setUserSeniors(Set<UserSenior> userSeniors) {
		this.userSeniors = userSeniors;
	}
	
}
