package com.tntb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.model.IncomeModel;
import com.tntb.model.ProductBuyModel;


public class IncomeDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<IncomeModel> getAll(){
		List<IncomeModel> list = new ArrayList<IncomeModel>();
		
		//Khi báo chuối truy vấn
		String sql = "select * from doanhthutheongay";
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
				list.add(new IncomeModel(rs.getDate(1),rs.getInt(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
	public List<ProductBuyModel> getspnhieunhat(){
		List<ProductBuyModel> list = new ArrayList<ProductBuyModel>();
		
		//Khi báo chuối truy vấn
		String sql = "select * from soluong";
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
				list.add(new ProductBuyModel(rs.getString(1),rs.getInt(2))
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
}
