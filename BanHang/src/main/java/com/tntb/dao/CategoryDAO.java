package com.tntb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.model.CategoryModel;


public class CategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public void insert(CategoryModel category) {
		String sql ="INSERT INTO `ProductDATABASE`.`catagory` (`namesp`, `des`) VALUES (?, ?);";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCname());
			ps.setString(2, category.getcDescription());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void edit(CategoryModel category) {
		String sql ="UPDATE `ProductDATABASE`.`catagory` SET  `namesp` = ?, `des` = ? WHERE (`catalogId` = ?);" ;
		
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, category.getCname());
			ps.setString(2, category.getcDescription());
			ps.setInt(3, category.getCatalogID());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql ="delete from ProductDATABASE.catagory where catalogId =?";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public CategoryModel getbyid(int id) {
		String sql = "SELECT * FROM ProductDATABASE.catagory where catalogId=?; ";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCatalogID(rs.getInt("catalogid"));
				category.setCname(rs.getString("namesp"));
				category.setcDescription(rs.getString("des"));
				return category;
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return null;
	}
	//Hiển thị tất cả các danh mục sản phẩm
	public List<CategoryModel> getAllCategory(){
		//Khai báo list để lưu danh sách danh mục
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		
		//Khi báo chuối truy vấn
		String sql = "select * from all_category";
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
				list.add(new CategoryModel(
							rs.getInt(1),
							rs.getString(2),
							rs.getString(3)));
			}
		} catch (Exception e) {
			
		}		
		return list;
	}
	public static void main(String[] args) {
		CategoryDAO dao = new CategoryDAO();
		List<CategoryModel> list = dao.getAllCategory();
		System.out.print(list);
	}
}
