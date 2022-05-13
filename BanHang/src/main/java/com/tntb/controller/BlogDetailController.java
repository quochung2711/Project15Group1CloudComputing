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
import com.tntb.dao.NewsDAO;
import com.tntb.model.CategoryModel;
import com.tntb.model.NewsModel;


@WebServlet(urlPatterns= {"/blog-detail"})
public class BlogDetailController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//Lấy tham số từ JSP
		String nid = req.getParameter("nid");
		
		//1.Khởi tạo DAO	
		CategoryDAO categoryDao = new CategoryDAO();
		NewsDAO newsDao = new NewsDAO();
		//2.Sử dụng đối tượng list để chứa danh sấch từ ProductDAO
		List<CategoryModel> listCate = categoryDao.getAllCategory();
		NewsModel newDetail = newsDao.getNewsById(nid);
		
		//3.Thiết lập dữ liệu lên JSP
		
		req.setAttribute("newDetail", newDetail);
		req.setAttribute("listAllCate", listCate);
		
		//4.Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/view/blog-detail.jsp");
		rq.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}