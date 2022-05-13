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
import com.tntb.dao.ContactDAO;
import com.tntb.dao.ProductDAO;
import com.tntb.model.CategoryModel;
import com.tntb.model.ContactModel;
import com.tntb.model.ProductModel;



@WebServlet(urlPatterns= {"/home","/trang-chu"})
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = -6115306347110056344L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//1.Khởi tạo DAO
		ProductDAO productDao = new ProductDAO();
		
		CategoryDAO categoryDao = new CategoryDAO();
		
		ContactDAO contactDao = new ContactDAO();
		
		//2.Sử dụng đối tượng list để chứa danh sấch từ ProductDAO
		List<ProductModel> list = productDao.getTop6Product();
		List<ProductModel> list1 = productDao.getTop5BestSeller();
		List<CategoryModel> listCate = categoryDao.getAllCategory();
		List<ContactModel> listContact = contactDao.getAllContact();
		//3.Thiết lập dữ liệu lên JSP
		req.setAttribute("list6product", list);
		req.setAttribute("list5bestseller", list1);
		req.setAttribute("listAllCate", listCate);
		req.setAttribute("listContact", listContact);
		//4.Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/view/home.jsp");
		rq.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
