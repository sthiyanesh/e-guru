package com.eguru.website.classobject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class course {

	@Id
	private int courseid;
	private String name;
	private String description;
	private String introvideo;
	private String profileimg;
	private int noofvideo;
	private String pgtitle;
	private String videolink;
	private String videodesc;
	private int guruid;
	private String guruname;
	
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIntrovideo() {
		return introvideo;
	}
	public void setIntrovideo(String introvideo) {
		this.introvideo = introvideo;
	}
	public String getProfileimg() {
		return profileimg;
	}
	public void setProfileimg(String profileimg) {
		this.profileimg = profileimg;
	}
	public int getNoofvideo() {
		return noofvideo;
	}
	public void setNoofvideo(int noofvideo) {
		this.noofvideo = noofvideo;
	}
	public String getPgtitle() {
		return pgtitle;
	}
	public void setPgtitle(String pgtitle) {
		this.pgtitle = pgtitle;
	}
	public String getVideolink() {
		return videolink;
	}
	public void setVideolink(String videolink) {
		this.videolink = videolink;
	}
	public String getVideodesc() {
		return videodesc;
	}
	public void setVideodesc(String videodesc) {
		this.videodesc = videodesc;
	}
	public int getGuruid() {
		return guruid;
	}
	public void setGuruid(int guruid) {
		this.guruid = guruid;
	}
	public String getGuruname() {
		return guruname;
	}
	public void setGuruname(String guruname) {
		this.guruname = guruname;
	}
	
}
