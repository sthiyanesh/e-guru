package com.eguru.website.classobject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class guru {

	@Id
	private int guruid;
	private String name;
	private String username;
	private String emailid;
	private String password;
	private String headline;
	private String profileimg;
	private String linkedin;
	private String github;
	
	public int getGuruid() {
		return guruid;
	}
	public void setGuruid(int guruid) {
		this.guruid = guruid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getProfileimg() {
		return profileimg;
	}
	public void setProfileimg(String profileimg) {
		this.profileimg = profileimg;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
	public guru(String emailid) {
		this.guruid = 0;
		this.name = "";
		this.username = "";
		this.emailid = emailid;
		this.password = "";
		this.headline = "";
		this.profileimg = "";
		this.linkedin = "";
		this.github = "";
	}
	public guru() {
		this.guruid = 0;
		this.name = "";
		this.username = "";
		this.emailid = "";
		this.password = "";
		this.headline = "";
		this.profileimg = "";
		this.linkedin = "";
		this.github = "";
	}
	public guru(int guruid, String name, String username, String emailid, String password, String headline,
			String profileimg, String linkedin, String github) {
		super();
		this.guruid = guruid;
		this.name = name;
		this.username = username;
		this.emailid = emailid;
		this.password = password;
		this.headline = headline;
		this.profileimg = profileimg;
		this.linkedin = linkedin;
		this.github = github;
	}
	
}
