package com.tntb.services;

import java.util.List;

import com.tntb.model.CartItemModel;

public interface CartItemService {
	void insert(CartItemModel cartitem);
	
	void edit(CartItemModel cartitem);
	
	void delete(String id);
	
	CartItemModel get(int id);
	
	List<CartItemModel> getAll();
	
	List<CartItemModel> search(String keyword);

	List<CartItemModel> getAllCart();
}
