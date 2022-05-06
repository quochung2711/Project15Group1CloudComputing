package com.tntb.model;

public class ContactModel {
	private int contactId;
	private String ctAddress;
	private String ctPhone;
	private String ctEmail;
	public ContactModel() {
		super();
	}
	public ContactModel(int contactId, String ctAddress, String ctPhone, String ctEmail) {
		super();
		this.contactId = contactId;
		this.ctAddress = ctAddress;
		this.ctPhone = ctPhone;
		this.ctEmail = ctEmail;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getCtAddress() {
		return ctAddress;
	}
	public void setCtAddress(String ctAddress) {
		this.ctAddress = ctAddress;
	}
	public String getCtPhone() {
		return ctPhone;
	}
	public void setCtPhone(String ctPhone) {
		this.ctPhone = ctPhone;
	}
	public String getCtEmail() {
		return ctEmail;
	}
	public void setCtEmail(String ctEmail) {
		this.ctEmail = ctEmail;
	}
	@Override
	public String toString() {
		return "ContactModel [contactId=" + contactId + ", ctAddress=" + ctAddress + ", ctPhone=" + ctPhone
				+ ", ctEmail=" + ctEmail + "]";
	}
	
	
}
