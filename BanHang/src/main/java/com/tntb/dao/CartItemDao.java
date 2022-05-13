package com.tntb.dao;

import java.util.List;

import com.tntb.model.CartItemModel;

public interface CartItemDao {
void insert(CartItemModel cartitem);
	
	void edit(CartItemModel cartitem);
	
	void delete(String id);
	
	CartItemModel get(int id);
	
	CartItemModel get(String name);
	
	List<CartItemModel> getAll();
	
	List<CartItemModel> getAllCart();
	
	List<CartItemModel> search(String keyword);
}
