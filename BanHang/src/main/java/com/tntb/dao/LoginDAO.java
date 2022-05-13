package com.tntb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.model.AccountModel;


public class LoginDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public AccountModel login(String username, String password) {
		String sql="select * from ProductDATABASE.users where username = ? and passworduser = ?";

		try {
			new DBConnect();
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs =ps.executeQuery();
			
			while(rs.next()) {
				return new AccountModel(
						rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7));
			}
			return null;
		}catch(Exception e) {
			
		}
	return null;
	}
	public List<AccountModel> getAllUser(){
		//Khai báo list để lưu danh sách danh mục
		List<AccountModel> list = new ArrayList<AccountModel>();
		
		//Khi báo chuối truy vấn
		String sql = "select * from all_account";
		try {
			// Mở kết nối database
			new DBConnect();
			conn = DBConnect.getConnect();
			
			//Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			
			//chạy query và nhận kết quả
			rs = ps.executeQuery();
			
			//Lấy ResultSet đổ vào list
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
	public static void main(String[] args) {
		LoginDAO dao = new LoginDAO();
		List<AccountModel> list = dao.getAllUser();
		System.out.print(list);
	}
}
