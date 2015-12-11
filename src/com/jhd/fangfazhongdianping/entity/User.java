package com.jhd.fangfazhongdianping.entity;

public class User {
	private int id;
	private String phone;
	public User(int id, String phone) {
		super();
		this.id = id;
		this.phone = phone;
	}
	public User() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
