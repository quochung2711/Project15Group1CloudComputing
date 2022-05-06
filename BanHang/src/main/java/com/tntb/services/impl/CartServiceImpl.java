package com.tntb.services.impl;

import java.util.List;

import com.tntb.dao.CartDao;
import com.tntb.dao.impl.CartDaoImpl;
import com.tntb.model.CartModel;
import com.tntb.services.CartService;

public class CartServiceImpl implements CartService{
	CartDao cartdao = new CartDaoImpl();

	@Override
	public void insert(CartModel cart) {
		cartdao.insert(cart);
	}

	@Override
	public void edit(CartModel newcart) {
		CartModel oldcart = cartdao.get(newcart.getId());
		
		oldcart.setBuyDate(newcart.getBuyDate());
		oldcart.setBuyer(newcart.getBuyer());
		
		cartdao.edit(oldcart);
	}

	@Override
	public void delete(String id) {
		cartdao.delete(id);
		}

	@Override
	public CartModel get(String id) {
		return cartdao.get(id);
	}

	@Override
	public List<CartModel> getAll() {
		// TODO Auto-generated method stub
		return cartdao.getAll();
	}

	@Override
	public List<CartModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}
