package com.tntb.services;

import java.util.List;

import com.tntb.model.CartModel;

public interface CartService {
	void insert(CartModel cart);
	
	void edit(CartModel newcart);
	
	void delete(String id);
	
	CartModel get(String id);
	
	List<CartModel> getAll();
	
	List<CartModel> search(String keyword);
}
