package com.tntb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.model.ContactModel;



public class ContactDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//Hiển thị thông tin liên hệ
	public List<ContactModel> getAllContact(){
		List<ContactModel> list = new ArrayList<ContactModel>();
		//Khi báo chuối truy vấn
		String sql = "select * from contact";
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
				list.add(new ContactModel(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)));
			}
		} catch (Exception e) {
			
		}		
		return list;
	}
	
	public static void main(String[] args) {
		ContactDAO dao = new ContactDAO();
		List<ContactModel> list = dao.getAllContact();
		System.out.print(list);
	}
}
