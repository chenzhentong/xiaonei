package com.xiaonei.web.forms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.xiaonei.domain.City;
import com.xiaonei.domain.Junior;
import com.xiaonei.domain.PrimarySchool;
import com.xiaonei.domain.Province;
import com.xiaonei.domain.TechSchool;

public class UserForm extends ActionForm {
	private String id;
	private String email;
	private String name;
	private String pwd; 
	private FormFile photo;
	private String sex;
	private String homePro;
	private String homeCity;
	private String birthday;
	private String tel;
	private String mobile;
	private String oicq;
	private String msn;
	private String website;
	private String techSch;
	private String techSchYear;
	private String juniorSch;
	private String juniorYear;
	private String primarySch;
	private String primaryYear;
	private String interset;
	private String music;
	private String game;
	private String cartoon;
	private String sport;
	private String book;
	private String assh;
	private String visited;
	private String doing;
	private String online;
	private String registerDate;
	private String logindate;
	private String locked;
	private String identity;
	private String universityId;
	private String usersType;
	private String keep;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
		System.out.println("setName±»µ÷ÓÃ"+name);
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public FormFile getPhoto() {
		return photo;
	}
	public void setPhoto(FormFile photo) {
		
		this.photo = photo;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHomePro() {
		return homePro;
	}
	public void setHomePro(String homePro) {
		this.homePro = homePro;
	}
	public String getHomeCity() {
		return homeCity;
	}
	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
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
	public String getTechSch() {
		return techSch;
	}
	public void setTechSch(String techSch) {
		this.techSch = techSch;
	}
	public String getTechSchYear() {
		return techSchYear;
	}
	public void setTechSchYear(String techSchYear) {
		this.techSchYear = techSchYear;
	}
	public String getJuniorSch() {
		return juniorSch;
	}
	public void setJuniorSch(String juniorSch) {
		this.juniorSch = juniorSch;
	}
	public String getJuniorYear() {
		return juniorYear;
	}
	public void setJuniorYear(String juniorYear) {
		this.juniorYear = juniorYear;
	}
	public String getPrimarySch() {
		return primarySch;
	}
	public void setPrimarySch(String primarySch) {
		this.primarySch = primarySch;
	}
	public String getPrimaryYear() {
		return primaryYear;
	}
	public void setPrimaryYear(String primaryYear) {
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
	public String getVisited() {
		return visited;
	}
	public void setVisited(String visited) {
		this.visited = visited;
	}
	public String getDoing() {
		return doing;
	}
	public void setDoing(String doing) {
		this.doing = doing;
	}
	public String getOnline() {
		return online;
	}
	public void setOnline(String online) {
		this.online = online;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getLogindate() {
		return logindate;
	}
	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}
	public String getLocked() {
		return locked;
	}
	public void setLocked(String locked) {
		this.locked = locked;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getUniversityId() {
		return universityId;
	}
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}
	public String getUsersType() {
		return usersType;
	}
	public void setUsersType(String usersType) {
		this.usersType = usersType;
	}
	
	
	public String getKeep() {
		return keep;
	}
	public void setKeep(String keep) {
		this.keep = keep;
	}
	public UserForm(String id, String email, String name, String pwd, FormFile photo, String sex, String homePro,
			String homeCity, String birthday, String tel, String mobile, String oicq, String msn, String website,
			String techSch, String techSchYear, String juniorSch, String juniorYear, String primarySch,
			String primaryYear, String interset, String music, String game, String cartoon, String sport, String book,
			String assh, String visited, String doing, String online, String registerDate, String logindate,
			String locked, String identity, String universityId, String usersType) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.pwd = pwd;
		this.photo = photo;
		this.sex = sex;
		this.homePro = homePro;
		this.homeCity = homeCity;
		this.birthday = birthday;
		this.tel = tel;
		this.mobile = mobile;
		this.oicq = oicq;
		this.msn = msn;
		this.website = website;
		this.techSch = techSch;
		this.techSchYear = techSchYear;
		this.juniorSch = juniorSch;
		this.juniorYear = juniorYear;
		this.primarySch = primarySch;
		this.primaryYear = primaryYear;
		this.interset = interset;
		this.music = music;
		this.game = game;
		this.cartoon = cartoon;
		this.sport = sport;
		this.book = book;
		this.assh = assh;
		this.visited = visited;
		this.doing = doing;
		this.online = online;
		this.registerDate = registerDate;
		this.logindate = logindate;
		this.locked = locked;
		this.identity = identity;
		this.universityId = universityId;
		this.usersType = usersType;
	}
	
	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
