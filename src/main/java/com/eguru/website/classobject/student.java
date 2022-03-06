package com.eguru.website.classobject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class student {

	@Id
	private int studid;
	private String name;
	private String username;
	private String password;
	private String headline;
	private String profileimg;
	private String linkedin;
	private String github;
	private String coursenroll;
	private String last2course;
	private String emailid;
	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
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
	public String getCoursenroll() {
		return coursenroll;
	}
	public void setCoursenroll(String coursenroll) {
		this.coursenroll = coursenroll;
	}
	public String getLast2course() {
		return last2course;
	}
	public void setLast2course(String last2course) {
		this.last2course = last2course;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public student(String emailid) {
		this.studid = 0;
		this.name = "";
		this.username = "";
		this.password = "";
		this.headline = "";
		this.profileimg = "";
		this.linkedin = "";
		this.github = "";
		this.coursenroll = "";
		this.last2course = "";
		this.emailid = emailid;
	}
	public student() {
		this.studid = 0;
		this.name = "";
		this.username = "";
		this.password = "";
		this.headline = "";
		this.profileimg = "";
		this.linkedin = "";
		this.github = "";
		this.coursenroll = "";
		this.last2course = "";
		this.emailid = "";
	}
	public student(int studid, String name, String username, String password, String headline, String profileimg,
			String linkedin, String github, String coursenroll, String last2course, String emailid) {
		this.studid = studid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.headline = headline;
		this.profileimg = profileimg;
		this.linkedin = linkedin;
		this.github = github;
		this.coursenroll = coursenroll;
		this.last2course = last2course;
		this.emailid = emailid;
	}
	

}
