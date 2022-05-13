package com.tntb.dao;

import java.util.List;

import com.tntb.model.AccountModel;


public interface UserDao {
	void insert(AccountModel user);

	void edit(AccountModel user);

	void delete(int id);

	AccountModel get(String username);

	AccountModel getbyid(int id);

	List<AccountModel> getAll();

	List<AccountModel> search(String keyword);

	boolean checkExitEmail(String email);

	boolean checkExitUsername(String username);
}
