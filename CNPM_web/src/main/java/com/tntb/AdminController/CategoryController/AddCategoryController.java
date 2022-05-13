package com.tntb.AdminController.CategoryController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.CategoryDAO;
import com.tntb.model.CategoryModel;


@WebServlet(urlPatterns= {"/admin-home-category-insert"})
public class AddCategoryController extends HttpServlet {
	
	private static final long serialVersionUID = -6115306347110056344L;
	private CategoryDAO categoryDao = new CategoryDAO();

	public void init() {

		categoryDao = new CategoryDAO();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiáº¿t láº­p tiáº¿ng viá»‡t
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("namesp");
		String description = req.getParameter("des");

		CategoryModel categorymodel = new CategoryModel(name, description);
		categoryDao.insert(categorymodel);
		resp.sendRedirect("admin-home-category");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
