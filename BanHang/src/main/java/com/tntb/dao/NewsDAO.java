package com.tntb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.model.NewsModel;

public class NewsDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/* Delete news */
	public void deletenews(String id) {
		String sql ="exec delete_new ?";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Insert news */
	public void insertnew(String image, String title, String brief, String content) {
		String sql ="exec insert_new ?,?,?,?";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);

			
			ps.setString(1,image);
			ps.setString(2, title);
			ps.setString(3, brief);
			ps.setString(4,content);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	/* Update news */
	public void updatenew(String nid, String image, String title, String brief, String content) {
		String sql ="exec update_new ?,?,?,?,?";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);

			ps.setString(1, nid);
			ps.setString(2,image);
			ps.setString(3, title);
			ps.setString(4, brief);
			ps.setString(5,content);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	//Hiển thị tất cả tin tức
	public List<NewsModel> getAllNews(){
		
				List<NewsModel> list = new ArrayList<NewsModel>();
				
				//Khi báo chuỗi truy vấn
				String sql = "select * from all_news";
				
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
						list.add(new NewsModel(rs.getInt(1),
								rs.getInt(2),
								rs.getString(3),
								rs.getString(4),
								rs.getString(5),
								rs.getString(6),
								rs.getTimestamp(7),
								rs.getTimestamp(8)));
					}
				} catch (Exception e) {
					
				}
				return list;
	}
	//Hiển thị tin tức theo ID 
	public NewsModel getNewsById(String id) {
		
		String sql = "select * from f_getNewsById(?)";
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
				return new NewsModel(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getTimestamp(7),
						rs.getTimestamp(8));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}
	public static void main(String[] args) {
		NewsDAO dao = new NewsDAO();
		NewsModel list = dao.getNewsById("1");
		System.out.print(list);
	}
}
