package com.xiaonei.domain;

import java.util.Set;

public class City {

	private Integer id;
	private String name;
	private Province pro;
	private Set<Town> towns;
	private Set<TechSchool> techSchools;
	private Set<Junior> juniors;
	private Set<PrimarySchool> primarySchools;
	private Set<Senior> seniors;
	private Set<Users> users;

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

	public Province getPro() {
		return pro;
	}

	public void setPro(Province pro) {
		this.pro = pro;
	}

	public Set<Town> getTowns() {
		return towns;
	}

	public void setTowns(Set<Town> towns) {
		this.towns = towns;
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

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	
	

}
