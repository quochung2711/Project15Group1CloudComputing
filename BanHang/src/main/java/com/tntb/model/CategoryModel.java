package com.tntb.model;

public class CategoryModel {
	private int catalogID;
	private String cname;
	private String cDescription;
	public CategoryModel() {
		super();
	}
	public CategoryModel(String cname, String cDescription) {
		super();
		this.cname = cname;
		this.cDescription = cDescription;
	}
	public CategoryModel(int catalogID, String cname, String cDescription) {
		super();
		this.catalogID = catalogID;
		this.cname = cname;
		this.cDescription = cDescription;
	}
	public int getCatalogID() {
		return catalogID;
	}
	public void setCatalogID(int catalogID) {
		this.catalogID = catalogID;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getcDescription() {
		return cDescription;
	}
	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}
	@Override
	public String toString() {
		return "CategoryModel [catalogID=" + catalogID + ", cname=" + cname + ", cDescription=" + cDescription + "]";
	}
}
