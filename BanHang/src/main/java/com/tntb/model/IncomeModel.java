package com.tntb.model;

import java.util.Date;

public class IncomeModel {
	private Date date;
	private int money;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public IncomeModel(Date date, int money) {
		super();
		this.date = date;
		this.money = money;
	}
	public IncomeModel() {
		super();
	}
	@Override
	public String toString() {
		return "IncomeModel [date=" + date + ", money=" + money + "]";
	}
	
}
