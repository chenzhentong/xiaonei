package com.xiaonei.domain;

import java.util.Set;

import org.hibernate.annotations.Proxy;

public class Users {
	private Integer id;
	private String email;
	private String name;
	private String pwd; 
	private String photo;
	private String photo2;
	private String sex;
	private Province homePro;
	private City homeCity;
	private java.util.Date birthday;
	private String tel;
	private String mobile;
	private String oicq;
	private String msn;
	private String website;
	private TechSchool techSch;
	private Integer techSchYear;
	private Junior juniorSch;
	private Integer juniorYear;
	private PrimarySchool primarySch;
	private Integer primaryYear;
	private String interset;
	private String music;
	private String game;
	private String cartoon;
	private String sport;
	private String book;
	private String assh;
	private Integer visited=0;
	private String doing;
	private Boolean online;
	private java.util.Date registerDate;
	private java.util.Date logindate;
	private boolean locked=false;
	private Set<UserSenior> userSeniors;
	private Set<UserUniversity> userUniversities;
	private Set<UserNet> userNets;
	private Set<Message> commentMessages;
	private Set<Message> hostMessages;
	private Set<Usermessagecomment> messageSenders;
	private Set<Usermessagecomment> messageReceivers;
	private Set<Blog> blogs;
	private Set<Blogagree> agrees;
	private Set<Album> albums;
	private Set<Friend> friends1;
	private Set<Friend> friends2;
	private Set<Uservisited> visitors;
	private Set<Uservisited> interviewees;
	private Set<Specialfriend> specialfriends1;
	private Set<Specialfriend> specialfriends2;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Province getHomePro() {
		return homePro;
	}

	public void setHomePro(Province homePro) {
		this.homePro = homePro;
	}

	public City getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(City homeCity) {
		this.homeCity = homeCity;
	}

	public java.util.Date getBirthday() {
	
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOicq() {
		return oicq;
	}

	public void setOicq(String oicq) {
		this.oicq = oicq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public TechSchool getTechSch() {
		return techSch;
	}

	public void setTechSch(TechSchool techSch) {
		this.techSch = techSch;
	}

	public Integer getTechSchYear() {
		return techSchYear;
	}

	public void setTechSchYear(Integer techSchYear) {
		this.techSchYear = techSchYear;
	}

	public Junior getJuniorSch() {
		return juniorSch;
	}

	public void setJuniorSch(Junior juniorSch) {
		this.juniorSch = juniorSch;
	}
	

	public Set<UserNet> getUserNets() {
		return userNets;
	}

	public void setUserNets(Set<UserNet> userNets) {
		this.userNets = userNets;
	}

	public Integer getJuniorYear() {
		return juniorYear;
	}

	public void setJuniorYear(Integer juniorYear) {
		this.juniorYear = juniorYear;
	}

	public PrimarySchool getPrimarySch() {
		return primarySch;
	}

	public void setPrimarySch(PrimarySchool primarySch) {
		this.primarySch = primarySch;
	}
	

	public Set<Blogagree> getAgrees() {
		return agrees;
	}

	public void setAgrees(Set<Blogagree> agrees) {
		this.agrees = agrees;
	}

	public Integer getPrimaryYear() {
		return primaryYear;
	}

	public void setPrimaryYear(Integer primaryYear) {
		this.primaryYear = primaryYear;
	}

	public String getInterset() {
		return interset;
	}

	public void setInterset(String interset) {
		this.interset = interset;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getCartoon() {
		return cartoon;
	}

	public void setCartoon(String cartoon) {
		this.cartoon = cartoon;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getAssh() {
		return assh;
	}

	public void setAssh(String assh) {
		this.assh = assh;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public String getDoing() {
		return doing;
	}

	public void setDoing(String doing) {
		this.doing = doing;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public java.util.Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(java.util.Date registerDate) {
		this.registerDate = registerDate;
	}

	public java.util.Date getLogindate() {
		return logindate;
	}

	public void setLogindate(java.util.Date logindate) {
		this.logindate = logindate;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}
	

	public Set<UserSenior> getUserSeniors() {
		return userSeniors;
	}

	public void setUserSeniors(Set<UserSenior> userSeniors) {
		this.userSeniors = userSeniors;
	}

	public Set<UserUniversity> getUserUniversities() {
		return userUniversities;
	}

	public void setUserUniversities(Set<UserUniversity> userUniversities) {
		this.userUniversities = userUniversities;
	}

	public String getPhoto2() {
		return photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	

	public Set<Message> getCommentMessages() {
		return commentMessages;
	}

	public void setCommentMessages(Set<Message> commentMessages) {
		this.commentMessages = commentMessages;
	}

	public Set<Message> getHostMessages() {
		return hostMessages;
	}

	public void setHostMessages(Set<Message> hostMessages) {
		this.hostMessages = hostMessages;
	}

	public Set<Usermessagecomment> getMessageSenders() {
		return messageSenders;
	}

	public void setMessageSenders(Set<Usermessagecomment> messageSenders) {
		this.messageSenders = messageSenders;
	}

	public Set<Usermessagecomment> getMessageReceivers() {
		return messageReceivers;
	}

	public void setMessageReceivers(Set<Usermessagecomment> messageReceivers) {
		this.messageReceivers = messageReceivers;
	}

	public Set<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public Set<Friend> getFriends1() {
		return friends1;
	}

	public void setFriends1(Set<Friend> friends1) {
		this.friends1 = friends1;
	}

	public Set<Friend> getFriends2() {
		return friends2;
	}

	public void setFriends2(Set<Friend> friends2) {
		this.friends2 = friends2;
	}

	public Set<Uservisited> getVisitors() {
		return visitors;
	}

	public void setVisitors(Set<Uservisited> visitors) {
		this.visitors = visitors;
	}

	public Set<Uservisited> getInterviewees() {
		return interviewees;
	}

	public void setInterviewees(Set<Uservisited> interviewees) {
		this.interviewees = interviewees;
	}

	public Set<Specialfriend> getSpecialfriends1() {
		return specialfriends1;
	}

	public void setSpecialfriends1(Set<Specialfriend> specialfriends1) {
		this.specialfriends1 = specialfriends1;
	}

	public Set<Specialfriend> getSpecialfriends2() {
		return specialfriends2;
	}

	public void setSpecialfriends2(Set<Specialfriend> specialfriends2) {
		this.specialfriends2 = specialfriends2;
	}

	
	

	 

}
