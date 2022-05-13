package com.tntb.AdminController.Product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.ProductDAO;
import com.tntb.model.ProductModel;

@WebServlet(urlPatterns= {"/admin-editproduct"})
public class ShowEditProductController extends HttpServlet {
	
	private static final long serialVersionUID = -6115306347110056344L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		//Thiáº¿t láº­p tiáº¿ng viá»‡t
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("pid"));
		
		ProductDAO productdao = new ProductDAO();
		ProductModel productmodel =productdao.getbyid(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/edit-product.jsp");
		request.setAttribute("product", productmodel);
		dispatcher.forward(request, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
