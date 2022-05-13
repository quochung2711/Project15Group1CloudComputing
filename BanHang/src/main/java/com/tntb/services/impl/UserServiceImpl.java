package com.tntb.services.impl;

import java.util.List;

import com.tntb.dao.UserDao;
import com.tntb.dao.impl.UserDaoImpl;
import com.tntb.model.AccountModel;
import com.tntb.services.UserService;

public class UserServiceImpl implements UserService{
	UserDao userDao = new UserDaoImpl();
	@Override
	public void insert(AccountModel user) {
		userDao.insert(user);
	}

	@Override
	public void edit(AccountModel newuser) {
		AccountModel olduser = userDao.getbyid(newuser.getId());
		olduser.setFullname(newuser.getFullname());
		olduser.setPhone(newuser.getPhone());
		olduser.setUsername(newuser.getUsername());
		olduser.setPassword(newuser.getPassword());
		olduser.setEmail(newuser.getEmail());
		olduser.setRoleid(newuser.getRoleid());
		
		userDao.edit(olduser);
	}

	@Override
	public void delete(int id) {
		 userDao.delete(id);
	}

	@Override
	public AccountModel get(String username) {
		// TODO Auto-generated method stub
		return userDao.get(username);
	}
	@Override
	public AccountModel getbyid(int id) {
		// TODO Auto-generated method stub
		return userDao.getbyid(id);
	}
	
	
	@Override
	public AccountModel login(String username, String password) {
		AccountModel user = this.get(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public boolean register(String fullname,String phone, String username, String password, String email) {
		if(userDao.checkExitUsername(username)|| userDao.checkExitEmail(email)) {
			return false;
		}
		userDao.insert(new AccountModel(fullname, phone, username, password, email, 2));
		return true;
	}


	@Override
	public List<AccountModel> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public List<AccountModel> search(String username) {
		// TODO Auto-generated method stub
		return userDao.search(username);
	}

	@Override
	public boolean checkExitEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.checkExitEmail(email);
	}

	@Override
	public boolean checkExitUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.checkExitUsername(username);
	}

	

	}


