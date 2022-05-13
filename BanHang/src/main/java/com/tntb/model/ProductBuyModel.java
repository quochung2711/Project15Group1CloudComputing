package com.tntb.model;



public class ProductBuyModel {
	private String name;
	private int sl;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSl() {
		return sl;
	}
	public void setSl(int sl) {
		this.sl = sl;
	}
	public ProductBuyModel(String name, int sl) {
		super();
		this.name = name;
		this.sl = sl;
	}
	@Override
	public String toString() {
		return "ProductBuyModel [name=" + name + ", sl=" + sl + "]";
	}
	
}
