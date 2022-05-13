package com.tntb.AdminController.CategoryController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.CategoryDAO;
import com.tntb.model.CategoryModel;
@WebServlet(urlPatterns= {"/admin-home-category-editcategory"})
public class ShowEditFormController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2669830615742805741L;

	private CategoryDAO categoryDao = new CategoryDAO();

	public void init() {

		categoryDao = new CategoryDAO();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Thiết lập tiếng việt
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("cid"));
		categoryDao = new CategoryDAO();

		CategoryModel categorymodel = categoryDao.getbyid(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/edit-category.jsp");
		request.setAttribute("category", categorymodel);
		dispatcher.forward(request, response);
	}

	

}
