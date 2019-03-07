package com.xiaonei.domain;

import java.util.Set;

public class Province {
	private Integer id;
    private String name;
    private Country country;
    private Set<City> cities;
    private Set<Users> users;
    private Set<University> universities;
    
    
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
	public Set<City> getCities() {
		return cities;
	}
	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	public Set<University> getUniversities() {
		return universities;
	}
	public void setUniversities(Set<University> universities) {
		this.universities = universities;
	}
	
	
	
	
	

}
