package com.tntb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.dao.CartDao;
import com.tntb.model.AccountModel;
import com.tntb.model.CartModel;
import com.tntb.services.UserService;
import com.tntb.services.impl.UserServiceImpl;

public class CartDaoImpl extends DBConnect implements CartDao{
	UserService user = new UserServiceImpl();

	@Override
	public void insert(CartModel cart) {
		String sql = "INSERT INTO cart(id, u_id, buydate) values (?,?,?)";
		try {
			Connection conn = super.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cart.getId());
			ps.setInt(2, cart.getBuyer().getId());
			ps.setDate(3, new Date(cart.getBuyDate().getTime()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(CartModel newcart) {
		String sql ="Update cart set u_id=?, buydate =? where id=?";
		try {
			Connection conn = super.getConnect();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newcart.getBuyer().getId());
			ps.setDate(2, new Date(newcart.getBuyDate().getTime()));
			ps.setString(3, newcart.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		String sql ="DELETE FROM cart where id =?";
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
	public CartModel get(String id) {
		String sql ="select cart.id, cart.buydate, users.email, users.username, users.id as user_id" 
	+ "From cart inner join users" + 
				"on cart.u_id = users.id where users.id=?";
		try {
			Connection con = super.getConnect();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs  = ps.executeQuery();
			while(rs.next()) {
				AccountModel us = user.getbyid(rs.getInt("user_id"));
				
				CartModel cart = new CartModel();
				cart.setId(rs.getString("u_id"));
				cart.setBuyDate(rs.getDate("buydate"));
				cart.setBuyer(us);
				return cart;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	

	@Override
	public List<CartModel> getAll() {
		List<CartModel> cartlist = new ArrayList<CartModel>();
		String sql="select cart.id, cart.buydate, users.email, users.username, users.id as user_id"
				+ "From cart inner join users"
				+ "on cart.u_id = users.id";
		try {
			Connection con = super.getConnect();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				AccountModel us = user.getbyid(rs.getInt("x"));
				CartModel cart = new CartModel();
				cart.setId(rs.getString("u_id"));
				cart.setBuyDate(rs.getDate("buydate"));
				cart.setBuyer(us);
				cartlist.add(cart);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cartlist;
	}

	@Override
	public List<CartModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
