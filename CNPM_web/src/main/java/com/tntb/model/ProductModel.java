package com.tntb.model;


public class ProductModel {
	private int pID;
	private int categotyID;
	private int suplierID;
	private String pname;
	private int pprice;
	private String pcontent;
	private int discount;
	private String pimage;
	private int amount;
	private int sl;

	public ProductModel() {
		super();
	}

	public ProductModel(int categotyID, int suplierID, String pname, int pprice, String pcontent, int discount,
			String pimage, int amount, int sl) {
		super();
		this.categotyID = categotyID;
		this.suplierID = suplierID;
		this.pname = pname;
		this.pprice = pprice;
		this.pcontent = pcontent;
		this.discount = discount;
		this.pimage = pimage;
		this.amount = amount;
		this.sl = sl;
	}

	public ProductModel(int pID, int categotyID, int suplierID, String pname, int pprice, String pcontent,
			int discount, String pimage, int amount, int sl) {
		super();
		this.pID = pID;
		this.categotyID = categotyID;
		this.suplierID = suplierID;
		this.pname = pname;
		this.pprice = pprice;
		this.pcontent = pcontent;
		this.discount = discount;
		this.pimage = pimage;
		this.amount = amount;
		this.sl = sl;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public int getCategotyID() {
		return categotyID;
	}

	public void setCategotyID(int categotyID) {
		this.categotyID = categotyID;
	}

	public int getSuplierID() {
		return suplierID;
	}

	public void setSuplierID(int suplierID) {
		this.suplierID = suplierID;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPprice() {
		return pprice;
	}

	public void setPprice(int pprice) {
		this.pprice = pprice;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	@Override
	public String toString() {
		return "ProductModel [pID=" + pID + ", categotyID=" + categotyID + ", suplierID=" + suplierID + ", pname="
				+ pname + ", pprice=" + pprice + ", pcontent=" + pcontent + ", discount=" + discount + ", pimage="
				+ pimage + ", amount=" + amount + ", sl=" + sl + "]";
	}

}
