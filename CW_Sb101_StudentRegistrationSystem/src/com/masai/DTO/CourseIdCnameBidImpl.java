package com.masai.DTO;

public class CourseIdCnameBidImpl  implements CourseIdCnameBid{

	private int cid;
	private String name;
	private int bid;
	public CourseIdCnameBidImpl(int cid, String name, int bid) {
		super();
		this.cid = cid;
		this.name = name;
		this.bid = bid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	@Override
	public String toString() {
		return "cid=" + cid + ", name=" + name + ", bid=" + bid ;
	}
	
	
	
}
