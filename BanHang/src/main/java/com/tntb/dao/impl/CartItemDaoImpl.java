package com.tntb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.dao.CartItemDao;
import com.tntb.dao.ProductDAO;
import com.tntb.dao.UserDao;
import com.tntb.model.AccountModel;
import com.tntb.model.CartItemModel;
import com.tntb.model.CartModel;
import com.tntb.model.ProductModel;
import com.tntb.services.CartService;
import com.tntb.services.impl.CartServiceImpl;

public class CartItemDaoImpl extends DBConnect implements CartItemDao{
	ProductDAO prdao = new ProductDAO();
	CartService cartsv = new CartServiceImpl();
	UserDao userdao = new UserDaoImpl();
	@Override
	public void insert(CartItemModel cartitem) {
		String sql = "INSERT INTO cartitem(id, quality, unitprice, pro_id, cart_id) values (?,?,?,?,?)";
		try {
			Connection conn = super.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cartitem.getId());
			ps.setInt(2, cartitem.getQuantity());
			ps.setInt(3, cartitem.getUnitPrice());
			ps.setInt(4, cartitem.getProduct().getpID());
			ps.setString(5, cartitem.getCart().getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CartItemModel cartitem) {
		String sql ="Update cartitem set quanlity=?, unitprice =?, pro_id=?, cart_id =? where id=?";
		try {
			Connection conn = super.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartitem.getQuantity());
			ps.setInt(2, cartitem.getUnitPrice());
			ps.setInt(3, cartitem.getProduct().getpID());
			ps.setString(4, cartitem.getCart().getId());
			ps.setString(5, cartitem.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		String sql ="delete from CartItem where CartItem.id=?";
		try {
			Connection conn = super.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CartItemModel get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItemModel get(String id) {
		String sql ="select CartItem.id, CartItem.quality, CartItem.unitprice, cart.u_id, cart.buydate, product.name, product.price"
				+ "from CartItem inner join cart on CartItem.cart_id = cart.id inner join product on product.productId = CartItem.pro_id"
				+ "where CartItem.id =?";
					try {
						Connection con = super.getConnect();
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, id);
						ResultSet rs  = ps.executeQuery();
						while(rs.next()) {
							AccountModel us = userdao.getbyid(rs.getInt("cart.u_id"));
							
							CartModel cart = new CartModel();
							cart.setBuyer(us);
							cart.setBuyDate(rs.getDate("cart.buydate"));
							ProductModel proc = new ProductModel();
							proc.setPname(rs.getString("product.name"));
							proc.setPprice(rs.getInt("product.price"));
							CartItemModel cartitem = new CartItemModel();
							cartitem.setCart(cart);
							cartitem.setProduct(proc);
							cartitem.setQuantity(rs.getInt("CartItem.quality"));
							cartitem.setUnitPrice(rs.getInt("CartItem.unitprice"));
							cart.setBuyer(us);
							return cartitem;
							
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
	}

	@Override
	public List<CartItemModel> getAll() {
		List<CartItemModel> cartitemlist = new ArrayList<CartItemModel>();
		String sql="select CartItem.id, CartItem.quality, CartItem.unitprice, CartItem.pro_id, cart.id, cart.u_id, cart.buydate, product.name, product.price from CartItem inner join cart on CartItem.cart_id = cart.id inner join product on product.productId = CartItem.pro_id";
		try {
			Connection con = super.getConnect();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AccountModel us = userdao.getbyid(rs.getInt("cart.u_id"));
				CartModel cart = new CartModel();
				cart.setBuyer(us);
				cart.setBuyDate(rs.getDate("cart.buydate"));
				ProductModel proc = new ProductModel();
				proc.setPname(rs.getString("product.name"));
				proc.setPprice(rs.getInt("product.price"));
				CartItemModel cartitem = new CartItemModel();
				cartitem.setCart(cart);
				cartitem.setProduct(proc);
				cartitem.setQuantity(rs.getInt("CartItem.quality"));
				cartitem.setUnitPrice(rs.getInt("CartItem.unitprice"));
				cart.setBuyer(us);
				cartitemlist.add(cartitem);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartitemlist;
	}
	
	@Override
	public List<CartItemModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItemModel> getAllCart() {
		List<CartItemModel> cartitemlist = new ArrayList<CartItemModel>();
		String sql="select * from CartItem";
		try {
			Connection con = super.getConnect();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CartModel cart = new CartModel();
				cart.setId(rs.getString("cart_id"));
				ProductModel proc = new ProductModel();
				proc.setpID(rs.getInt("pro_id"));
				CartItemModel cartitem = new CartItemModel();
				cartitem.setId(rs.getString("id"));
				cartitem.setQuantity(rs.getInt("quality"));
				cartitem.setUnitPrice(rs.getInt("unitprice"));
				cartitem.setProduct(proc);
				cartitem.setCart(cart);
				cartitemlist.add(cartitem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartitemlist;
	}
	

}
