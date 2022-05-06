package com.tntb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.model.NCCModel;

public class NccDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/* Delete ncc */
	public void deletencc(String id) {
		String sql ="exec delete_supplier ?";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Insert ncc */
	public void insertncc(String name, String phone, String address) {
		String sql ="exec insert_supplier ?,?,?";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);

			
			ps.setString(1,name);
			ps.setString(2, phone);
			ps.setString(3, address);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	/* Update news */
	public void updatencc(String nid, String name, String phone, String address) {
		String sql ="exec update_supplier ?, ?, ?, ?";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);

			ps.setString(1,nid);
			ps.setString(2,name);
			ps.setString(3, phone);
			ps.setString(4, address);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	/* Hiển thị tất cả NCC */
	public List<NCCModel> getAllNCC(){
		
				List<NCCModel> list = new ArrayList<NCCModel>();
				
				//Khi báo chuỗi truy vấn
				String sql = "select * from all_supplier";
				
				try {
					new DBConnect();
					//Mở kết nối database
					conn = DBConnect.getConnect();
					
					//Ném câu query qua sql
					ps = conn.prepareStatement(sql);
					
					//chạy query và nhận kết quả
					rs = ps.executeQuery();
					
					//Lấy ResultSet đổ vào list
					while(rs.next()) {
						list.add(new NCCModel(rs.getInt(1),
								rs.getString(2),
								rs.getString(3),
								rs.getString(4)));					}
				} catch (Exception e) {
					
				}
				return list;
	}
	//Hiển thị NCC theo ID 
		public NCCModel getNCCById(String id) {
			
			String sql = "select * from f_getSupplierById(?) ";
			try {
				new DBConnect();
				//Mở kết nối database
				conn = DBConnect.getConnect();
				
				//Ném câu query qua sql
				ps = conn.prepareStatement(sql);
				
				//Gán giá trị cho dấu "?"
				ps.setString(1, id);
				//chạy query và nhận kết quả
				rs = ps.executeQuery();
				
				//Lấy ResultSet đổ vào list
				while(rs.next()) {
					return new NCCModel(rs.getInt(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			return null;
		}
	
}
