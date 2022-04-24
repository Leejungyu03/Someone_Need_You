package com.SNY.resume.model;

import java.util.Date;

public class Resume {
	private int id;
	private int userId;
	private String oneLineIntroduction;
	private String birth;
	private String gender;
	private String phoneNumber;
	private String profile;
	private String portfolio_url;
	private String portfolio_file;
	private String introduce;
	private Date createdAt;
	private Date updatedAt;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOneLineIntroduction() {
		return oneLineIntroduction;
	}
	public void setOneLineIntroduction(String oneLineIntroduction) {
		this.oneLineIntroduction = oneLineIntroduction;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getPortfolio_url() {
		return portfolio_url;
	}
	public void setPortfolio_url(String portfolio_url) {
		this.portfolio_url = portfolio_url;
	}
	public String getPortfolio_file() {
		return portfolio_file;
	}
	public void setPortfolio_file(String portfolio_file) {
		this.portfolio_file = portfolio_file;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
