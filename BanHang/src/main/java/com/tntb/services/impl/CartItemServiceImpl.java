package com.tntb.services.impl;

import java.util.List;

import com.tntb.dao.CartItemDao;
import com.tntb.dao.impl.CartItemDaoImpl;
import com.tntb.model.CartItemModel;
import com.tntb.services.CartItemService;

public class CartItemServiceImpl implements CartItemService{
	CartItemDao cartitemdao = new CartItemDaoImpl();
	@Override
	public void insert(CartItemModel cartitem) {
		cartitemdao.insert(cartitem);
	}

	@Override
	public void edit(CartItemModel cartitem) {
		CartItemModel olditem = cartitemdao.get(cartitem.getId());
		
		olditem.setCart(cartitem.getCart());
		olditem.setProduct(cartitem.getProduct());
		olditem.setQuantity(cartitem.getQuantity());
		olditem.setUnitPrice(cartitem.getUnitPrice());
		
		cartitemdao.edit(olditem);
	}

	@Override
	public void delete(String id) {
		cartitemdao.delete(id);
	}

	@Override
	public CartItemModel get(int id) {
		return cartitemdao.get(id);
	}

	@Override
	public List<CartItemModel> getAll() {
		// TODO Auto-generated method stub
		return cartitemdao.getAll();
	}

	@Override
	public List<CartItemModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItemModel> getAllCart() {
		// TODO Auto-generated method stub
		return cartitemdao.getAllCart();
	}

}
