package com.hainan.cs.bean;

import java.util.Date;

public class EducationRecord {
	private int id;
	private String userid;
	private String username;
	private String content;
	private Date sdate;
	
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSdate() {
		return sdate;
	}
	
}
