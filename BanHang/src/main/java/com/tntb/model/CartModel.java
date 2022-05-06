package com.tntb.model;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class CartModel implements Serializable{
	private String id;
	private AccountModel buyer;
	private Date buyDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public AccountModel getBuyer() {
		return buyer;
	}
	public void setBuyer(AccountModel us) {
		this.buyer = us;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public CartModel(String id, AccountModel buyer, Date buyDate) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.buyDate = buyDate;
	}
	public CartModel() {
		super();
	}
	
}
