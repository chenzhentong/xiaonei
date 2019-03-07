package com.xiaonei.domain;

import java.util.Set;

public class University {
	private Integer id;
	private String name;
	private Country country;
	private Province province;
	private Set<UserUniversity> userUniversities;
	
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
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	public Set<UserUniversity> getUserUniversities() {
		return userUniversities;
	}
	public void setUserUniversities(Set<UserUniversity> userUniversities) {
		this.userUniversities = userUniversities;
	}
	
	
	

}
