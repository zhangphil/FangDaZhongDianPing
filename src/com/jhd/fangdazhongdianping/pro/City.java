package com.jhd.fangdazhongdianping.pro;

public class City {
	private int id;
	private String name;
	private String sortKey;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSortKey() {
		return sortKey;
	}
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}
	public City(int id, String name, String sortKey) {
		super();
		this.id = id;
		this.name = name;
		this.sortKey = sortKey;
	}
	public City() {
		super();
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", sortKey=" + sortKey
				+ "]";
	}
	

}
