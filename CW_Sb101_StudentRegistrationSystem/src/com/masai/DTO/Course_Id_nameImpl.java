package com.masai.DTO;

public class Course_Id_nameImpl implements Course_Id_name {

	private int cid;
	private String cname;
	public Course_Id_nameImpl(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "cid=" + cid + ", cname=" + cname;
	}
	
	
	
	
}
