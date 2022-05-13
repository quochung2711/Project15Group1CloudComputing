package com.tntb.model;

public class AccountModel {
	private int id;
	private String fullname;
	private String phone;
	private String username;
	private String password;
	private String email;
	private int roleid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "AccountModel [id=" + id + ", fullname=" + fullname + ", phone=" + phone + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", roleid=" + roleid + "]";
	}
	public AccountModel() {
		super();
	}
	public AccountModel(String fullname, String phone, String username, String password, String email) {
		super();
		this.fullname = fullname;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public AccountModel(String fullname, String phone, String username, String password, String email, int roleid) {
		super();
		this.fullname = fullname;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roleid = roleid;
	}
	public AccountModel(int id, String fullname, String phone, String username, String password, String email,
			int roleid) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roleid = roleid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
}
