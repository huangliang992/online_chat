package com.hainan.cs.bean;

import java.util.Date;

public class TechRecord {
	private int id;
	private String userid;
	private String userneame;
	private String content;
	private Date sdate;
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
	public String getUserneame() {
		return userneame;
	}
	public void setUserneame(String userneame) {
		this.userneame = userneame;
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
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	
}
