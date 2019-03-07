package com.xiaonei.domain;

import java.util.Set;

public class Town {
	private Integer id;
	private String name;
	private Set<TechSchool> techSchools;
	private City city;
	private Set<Junior> juniors;
	private Set<PrimarySchool> primarySchools;
	private Set<Senior> seniors;
	
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
	public Set<TechSchool> getTechSchools() {
		return techSchools;
	}
	public void setTechSchools(Set<TechSchool> techSchools) {
		this.techSchools = techSchools;
	}
	public Set<Junior> getJuniors() {
		return juniors;
	}
	public void setJuniors(Set<Junior> juniors) {
		this.juniors = juniors;
	}
	public Set<PrimarySchool> getPrimarySchools() {
		return primarySchools;
	}
	public void setPrimarySchools(Set<PrimarySchool> primarySchools) {
		this.primarySchools = primarySchools;
	}
	public Set<Senior> getSeniors() {
		return seniors;
	}
	public void setSeniors(Set<Senior> seniors) {
		this.seniors = seniors;
	}
	
	
	
}
