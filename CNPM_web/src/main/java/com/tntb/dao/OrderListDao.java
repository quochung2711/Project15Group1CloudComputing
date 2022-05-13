package com.tntb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.model.OrderlListModel;


public class OrderListDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<OrderlListModel> getAll(){
		List<OrderlListModel> list = new ArrayList<OrderlListModel>();
		
		//Khi báo chuối truy vấn
		String sql = "select * from thongtin_dathangmoi";
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
				list.add(new OrderlListModel(
						rs.getString(1), 
						rs.getString(2),
						 rs.getInt(3),
						 rs.getInt(4),
						 rs.getString(5),
						 rs.getString(6),
						 rs.getInt(7),
						
						 rs.getInt(8),
						 rs.getDate(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
	
	
}
