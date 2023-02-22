package com.masai.DTO;

import java.util.Objects;

public class StudentImpl implements Student{

	private int id;
	private String name;
	private String state;
	private String email;
	private String phone;
	private String password;
	private Batch batch;
	
	
	
	
	public StudentImpl() {
		super();
	}




	public StudentImpl(int id, String name, String state, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}




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




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Batch getBatch() {
		return batch;
	}




	public void setBatch(Batch batch) {
		this.batch = batch;
	}




	@Override
	public String toString() {
		return "StudentImpl [id=" + id + ", name=" + name + ", state=" + state + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + ", batch=" + batch + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentImpl other = (StudentImpl) obj;
		return id == other.id;
	}
	
	
	
	
	
	
}
