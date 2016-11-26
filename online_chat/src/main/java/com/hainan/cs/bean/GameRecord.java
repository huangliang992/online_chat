package com.hainan.cs.bean;

import javax.xml.crypto.Data;

public class GameRecord {
	private int id;
	private String userid;
	private String username;
	private Data sdata;
	private String content;
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
	public Data getSdata() {
		return sdata;
	}
	public void setSdata(Data sdata) {
		this.sdata = sdata;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
