package com.hainan.cs.bean;

import javax.xml.crypto.Data;

public class EducationRecord {
	private int id;
	private String userid;
	private String username;
	private String content;
	private Data sdata;
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
	public Data getSdata() {
		return sdata;
	}
	public void setSdata(Data sdata) {
		this.sdata = sdata;
	}
	
}
