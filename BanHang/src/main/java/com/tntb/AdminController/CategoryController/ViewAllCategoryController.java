package com.tntb.AdminController.CategoryController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.CategoryDAO;
import com.tntb.model.CategoryModel;
@WebServlet(urlPatterns= {"/admin-home-category","/admin-trang-chu-category"})
public class ViewAllCategoryController extends HttpServlet {

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
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		// Thiết lập tiếng việt
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		categoryDao = new CategoryDAO();
		List<CategoryModel> listCate = categoryDao.getAllCategory();
		req.setAttribute("listAllCate", listCate);
		RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-category.jsp");
		rq.forward(req, response);
	}

	
}
