package com.xiaonei.domain;

public class Album {
	private Integer id;
	private String title;
	private String photo;
	private String photo2;
	private Albumsort sort;
	private java.util.Date publihDate;
	private Users publisher;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPhoto2() {
		return photo2;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	public Albumsort getSort() {
		return sort;
	}
	public void setSort(Albumsort sort) {
		this.sort = sort;
	}
	public java.util.Date getPublihDate() {
		return publihDate;
	}
	public void setPublihDate(java.util.Date publihDate) {
		this.publihDate = publihDate;
	}
	public Users getPublisher() {
		return publisher;
	}
	public void setPublisher(Users publisher) {
		this.publisher = publisher;
	}
	
	

}
