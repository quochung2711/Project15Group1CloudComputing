package com.tntb.model;

import java.util.Date;

public class OrderlListModel {
	private String cartitemid;
	private String cartid;
	private int product_id;
	private int quantity;
	private String user_fullname;
	private String pro_name;
	private int price;
	private Date buydate;
	private int user_id;
	public String getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(String cartitemid) {
		this.cartitemid = cartitemid;
	}
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUser_fullname() {
		return user_fullname;
	}
	public void setUser_fullname(String user_fullname) {
		this.user_fullname = user_fullname;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getBuydate() {
		return buydate;
	}
	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public OrderlListModel(String cartid, int product_id, int quantity, String user_fullname, String pro_name,
			int price, Date buydate, int user_id) {
		super();
		this.cartid = cartid;
		this.product_id = product_id;
		this.quantity = quantity;
		this.user_fullname = user_fullname;
		this.pro_name = pro_name;
		this.price = price;
		this.buydate = buydate;
		this.user_id = user_id;
	}
	
	public OrderlListModel(String cartitemid, String cartid, int product_id, int quantity, String user_fullname,
			String pro_name, int price, int user_id, Date buydate) {
		super();
		this.cartitemid = cartitemid;
		this.cartid = cartid;
		this.product_id = product_id;
		this.quantity = quantity;
		this.user_fullname = user_fullname;
		this.pro_name = pro_name;
		this.price = price;
		this.user_id = user_id;
		this.buydate = buydate;
	}
	public OrderlListModel() {
		super();
	}
	@Override
	public String toString() {
		return "OrderlListModel [cartitemid=" + cartitemid + ", cartid=" + cartid + ", product_id=" + product_id
				+ ", quantity=" + quantity + ", user_fullname=" + user_fullname + ", pro_name=" + pro_name + ", price="
				+ price + ", buydate=" + buydate + ", user_id=" + user_id + "]";
	}
	
}
	
	
	
	
	
	

