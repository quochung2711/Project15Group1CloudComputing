package com.tntb.AdminController.CategoryController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.CategoryDAO;
import com.tntb.model.CategoryModel;


@WebServlet(urlPatterns= {"/admin-home-category-updatecategory"})
public class EditCategoryController extends HttpServlet {
	
	private static final long serialVersionUID = -6115306347110056344L;
	private CategoryDAO categoryDao = new CategoryDAO();

	public void init() {

		categoryDao = new CategoryDAO();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("name");
		String desp = request.getParameter("decription");

		CategoryModel book = new CategoryModel(id, name, desp);
		categoryDao.edit(book);
		resp.sendRedirect("admin-home-category");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
