package com.tntb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.dao.UserDao;
import com.tntb.model.AccountModel;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public void insert(AccountModel user) {
		String sql = "exec insert_users ?, ?, ?, ?, ?, ?";
		try {
			new DBConnect();
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getFullname());
			ps.setString(2, user.getPhone());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRoleid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(AccountModel user) {
		String sql = "exec update_users ?, ?, ?, ?, ?, ?, ?";
		try {
			new DBConnect();
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getEmail());
			ps.setInt(7, user.getRoleid());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "exec delete_users ?";
		try {
			new DBConnect();
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public AccountModel get(String username) {
		String sql = "SELECT * FROM users where username ='?';";

		try {
			new DBConnect();
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				AccountModel user = new AccountModel();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setRoleid(rs.getInt("roleid"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountModel getbyid(int id) {
		String sql = "select * from f_UserDetail(?);";

		try {
			new DBConnect();
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = new AccountModel();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setRoleid(rs.getInt("roleid"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AccountModel> getAll() {
		List<AccountModel> list = new ArrayList<AccountModel>();
		
		String sql ="select * from all_account";
		try {
			new DBConnect();
			conn = DBConnect.getConnect();
			ps =conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new AccountModel(rs.getInt(1), 
						rs.getString(2),
						 rs.getString(3),
						 rs.getString(4),
						 rs.getString(5),
						 rs.getString(6),
						 rs.getInt(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<AccountModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkExitEmail(String email) {
		boolean duplicate = false;
		String query = "select * from f_checkEmail(?)";

		try {
			new DBConnect();
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();

			if(rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return duplicate;
	}

	@Override
	public boolean checkExitUsername(String username) {
		boolean duplicate = false;
		String query = "SELECT * FROM users where username=?;";

		try {
			new DBConnect();
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();

			if(rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return duplicate;
	}

}
