package com.tntb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.CategoryDAO;
import com.tntb.dao.ProductDAO;
import com.tntb.model.CategoryModel;
import com.tntb.model.ProductModel;


@WebServlet(urlPatterns = {"/productdetail"})
public class ProductDetailController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//Lấy tham số từ JSP
		String pid = req.getParameter("pid");
		//1.Khởi tạo DAO
		ProductDAO productDao = new ProductDAO();
		
		CategoryDAO categoryDao = new CategoryDAO();
		
		//2.Sử dụng đối tượng list để chứa danh sấch từ ProductDAO
		
		List<CategoryModel> listCate = categoryDao.getAllCategory();
		List<ProductModel> list1 = productDao.getTop5BestSeller();
		ProductModel prodetail = productDao.getProductByID(pid);
		List<ProductModel> listTopNew = productDao.getTop6Product();
		//3.Thiết lập dữ liệu lên JSP
		
		req.setAttribute("listTopNew", listTopNew);
		req.setAttribute("listAllCate", listCate);
		req.setAttribute("list5bestseller", list1);
		req.setAttribute("prodetail", prodetail);
		//4.Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/view/productdetail.jsp");
		rq.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
