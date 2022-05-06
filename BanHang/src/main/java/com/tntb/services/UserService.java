package com.tntb.services;

import java.util.List;

import com.tntb.model.AccountModel;

public interface UserService {
	void insert(AccountModel user);
	
	void edit(AccountModel user);
	
	void delete(int id);
	
	AccountModel get(String username);
	
	AccountModel getbyid(int id);
	
	AccountModel login(String username, String password);
	
	boolean register(String fullname,String phone, String username, String password, String email);
	
	List<AccountModel> getAll();
	
	List<AccountModel> search(String keyword);
	
	boolean checkExitEmail(String email);
	
	boolean checkExitUsername(String username);
	
}
