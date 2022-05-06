package com.tntb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tntb.connection.DBConnect;
import com.tntb.model.ProductModel;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	public ProductModel getbyid(int id)
	{
		ProductModel product = null;
		String sql = "SELECT * FROM product where productid = ?;";
		try {
			new DBConnect();
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				
				int id2 = rs.getInt("catalogId");
				int id3 = rs.getInt("supplierId");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String content = rs.getString("content");
				int discount = rs.getInt("discount");
				String image = rs.getString("image_link");
				int amount = rs.getInt("amount");
				int sl = rs.getInt("sl");
				product = new ProductModel(id, id2, id3, name, price, content, discount, image, amount, sl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
		
	}
	public void insert(ProductModel productmodel){
		//Khai báo list để lưu danh sách danh mục
		
		
	
		  String sql = "exec insert_proc ?,?,?,?,?,?,?,?,?";
	
		try {
			// Mở kết nối database
			new DBConnect();
			conn = DBConnect.getConnect();
			
			//Ném câu query qua sql
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, productmodel.getCategotyID());
			ps.setInt(2, productmodel.getSuplierID());
			ps.setString(3, productmodel.getPname());
			ps.setInt(4, productmodel.getPprice());
			ps.setString(5, productmodel.getPcontent());
			ps.setInt(6, productmodel.getDiscount());
			ps.setString(7, productmodel.getPimage());
			ps.setInt(8, productmodel.getAmount());
			ps.setInt(9, productmodel.getSl());
			
			//chạy query và nhận kết quả
			ps.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public void delete(int id) {
		String sql ="exec delete_product ?";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void edit(ProductModel productmodel) {
		String sql ="exec update_proc ?,?,?,?,?,?,?,?,?,?";
		try {
			conn = DBConnect.getConnect();
			ps = conn.prepareStatement(sql);

			ps.setInt(1, productmodel.getpID());
			ps.setInt(2, productmodel.getCategotyID());
			ps.setInt(3, productmodel.getSuplierID());
			ps.setString(4, productmodel.getPname());
			ps.setInt(5, productmodel.getPprice());
			ps.setString(6, productmodel.getPcontent());
			ps.setInt(7, productmodel.getDiscount());
			ps.setString(8, productmodel.getPimage());
			ps.setInt(9, productmodel.getAmount());
			ps.setInt(10, productmodel.getSl());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	//Chức năng tìm kiếm
	public List<ProductModel> searchByProductName(String txtSearch){
		//Khai báo list lưu ds sp
		List<ProductModel> list = new ArrayList<ProductModel>();
		
		
		String sql = "select * from f_searchProduct(?)";
		
		try {
			new DBConnect();
			//Má»Ÿ káº¿t ná»‘i database
			conn = DBConnect.getConnect();
			
			//NÃ©m cÃ¢u query qua sql
			ps = conn.prepareStatement(sql);
			
			//Set vá»‹ trÃ­ cá»§a product
			ps.setString(1,txtSearch);
			
			//cháº¡y query vÃ  nháº­n káº¿t quáº£
			rs = ps.executeQuery();
			
			//Láº¥y ResultSet Ä‘á»• vÃ o list
			while(rs.next()) {
				list.add(new ProductModel(rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getInt(9),
						rs.getInt(10)));
			}
		} catch (Exception e) {
			
		}
		return list;
		
		
	}
	
	//Hiá»ƒn thá»‹ táº¥t cáº£ sáº£n pháº£m theo category
	public List<ProductModel> getAllProductByCID(String cid){
		//Khai bÃ¡o list Ä‘á»ƒ lÆ°u danh sÃ¡ch sáº£n pháº©m
				List<ProductModel> list = new ArrayList<ProductModel>();
				
				//Khi bÃ¡o chuá»—i truy váº¥n
				String sql = "select * from f_productByCatalogID(?)";
				
				try {
					new DBConnect();
					//Má»Ÿ káº¿t ná»‘i database
					conn = DBConnect.getConnect();
					
					//NÃ©m cÃ¢u query qua sql
					ps = conn.prepareStatement(sql);
					
					//GÃ¡n giÃ¡ trá»‹ cho dáº¥u "?"
					ps.setString(1, cid);
					
					//cháº¡y query vÃ  nháº­n káº¿t quáº£
					rs = ps.executeQuery();
					
					//Láº¥y ResultSet Ä‘á»• vÃ o list
					while(rs.next()) {
						list.add(new ProductModel(rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getInt(5),
								rs.getString(6),
								rs.getInt(7),
								rs.getString(8),
								rs.getInt(9),
								rs.getInt(10)));
					}
				} catch (Exception e) {
					
				}
				return list;
	}
	
	//Hiá»ƒn thá»‹ táº¥t cáº£ sáº£n pháº©m
	public List<ProductModel> getAllProduct(){
		//Khai bÃ¡o list Ä‘á»ƒ lÆ°u danh sÃ¡ch sáº£n pháº©m
				List<ProductModel> list = new ArrayList<ProductModel>();
				
				//Khi bÃ¡o chuá»—i truy váº¥n
				String sql = "exec show_product";
				
				try {
					new DBConnect();
					//Má»Ÿ káº¿t ná»‘i database
					conn = DBConnect.getConnect();
					
					//NÃ©m cÃ¢u query qua sql
					ps = conn.prepareStatement(sql);
					
					//cháº¡y query vÃ  nháº­n káº¿t quáº£
					rs = ps.executeQuery();
					
					//Láº¥y ResultSet Ä‘á»• vÃ o list
					while(rs.next()) {
						list.add(new ProductModel(rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getInt(5),
								rs.getString(6),
								rs.getInt(7),
								rs.getString(8),
								rs.getInt(9),
								rs.getInt(10)));
					}
				} catch (Exception e) {
					
				}
				return list;
	}
	
	// Hiá»ƒn thá»‹ 6 sáº£n pháº©m bÃ¡n cháº¡y nháº¥t
	public List<ProductModel> getTop5BestSeller(){
		//Khai bÃ¡o list Ä‘á»ƒ lÆ°u danh sÃ¡ch sáº£n pháº©m
				List<ProductModel> list = new ArrayList<ProductModel>();
				
				//Khi bÃ¡o chuá»—i truy váº¥n
				String sql = "select * from Show_Top6sp_product";
				
				try {
					new DBConnect();
					//Má»Ÿ káº¿t ná»‘i database
					conn = DBConnect.getConnect();
					
					//NÃ©m cÃ¢u query qua sql
					ps = conn.prepareStatement(sql);
					
					//cháº¡y query vÃ  nháº­n káº¿t quáº£
					rs = ps.executeQuery();
					
					//Láº¥y ResultSet Ä‘á»• vÃ o list
					while(rs.next()) {
						list.add(new ProductModel(rs.getInt(1),
								rs.getInt(2),
								rs.getInt(3),
								rs.getString(4),
								rs.getInt(5),
								rs.getString(6),
								rs.getInt(7),
								rs.getString(8),
								rs.getInt(9),
								rs.getInt(10)));
					}
				} catch (Exception e) {
					
				}
				return list;
	}
	//Hiá»ƒn thá»‹ 6 sáº£n pháº©m má»›i nháº¥t
	public List<ProductModel> getTop6Product(){
		//Khai bÃ¡o list Ä‘á»ƒ lÆ°u danh sÃ¡ch sáº£n pháº©m
		List<ProductModel> list = new ArrayList<ProductModel>();
		
		//Khi bÃ¡o chuá»—i truy váº¥n
		String sql = "select * from show_Top6sp_newProduct";
		
		try {
			new DBConnect();
			//Má»Ÿ káº¿t ná»‘i database
			conn = DBConnect.getConnect();
			
			//NÃ©m cÃ¢u query qua sql
			ps = conn.prepareStatement(sql);
			
			//cháº¡y query vÃ  nháº­n káº¿t quáº£
			rs = ps.executeQuery();
			
			//Láº¥y ResultSet Ä‘á»• vÃ o list
			while(rs.next()) {
				list.add(new ProductModel(rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getInt(9),
						rs.getInt(10)));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
	
	
	//Lấy sản phẩm theo id product
	public ProductModel getProductByID(String id) {
		
		String sql = "select * from f_productDetail(?)";
		try {
			new DBConnect();
			//Má»Ÿ káº¿t ná»‘i database
			conn = DBConnect.getConnect();
			
			//NÃ©m cÃ¢u query qua sql
			ps = conn.prepareStatement(sql);
			
			//GÃ¡n giÃ¡ trá»‹ cho dáº¥u "?"
			ps.setString(1, id);
			//cháº¡y query vÃ  nháº­n káº¿t quáº£
			rs = ps.executeQuery();
			
			//Láº¥y ResultSet Ä‘á»• vÃ o list
			while(rs.next()) {
				return new ProductModel(rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getInt(9),
						rs.getInt(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		ProductModel list = dao.getProductByID("1");
		System.out.print(list);
	}
}
