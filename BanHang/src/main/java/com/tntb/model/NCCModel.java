package com.tntb.model;

public class NCCModel {
	private int nccID;
	private String nccName;
	private String nccPhone;
	private String nccAddress;
	public NCCModel() {
		super();
	}
	public NCCModel(int nccID, String nccName, String nccPhone, String nccAddress) {
		super();
		this.nccID = nccID;
		this.nccName = nccName;
		this.nccPhone = nccPhone;
		this.nccAddress = nccAddress;
	}
	public int getNccID() {
		return nccID;
	}
	public void setNccID(int nccID) {
		this.nccID = nccID;
	}
	public String getNccName() {
		return nccName;
	}
	public void setNccName(String nccName) {
		this.nccName = nccName;
	}
	public String getNccPhone() {
		return nccPhone;
	}
	public void setNccPhone(String nccPhone) {
		this.nccPhone = nccPhone;
	}
	public String getNccAddress() {
		return nccAddress;
	}
	public void setNccAddress(String nccAddress) {
		this.nccAddress = nccAddress;
	}
	@Override
	public String toString() {
		return "NCCModel [nccID=" + nccID + ", nccName=" + nccName + ", nccPhone=" + nccPhone + ", nccAddress="
				+ nccAddress + "]";
	}
	
	
}
