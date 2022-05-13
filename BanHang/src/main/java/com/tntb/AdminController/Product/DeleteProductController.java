package com.tntb.AdminController.Product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.ProductDAO;

@WebServlet(urlPatterns = { "/admin-deleteproduct" })
public class DeleteProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5466292632768280332L;
	private ProductDAO prd = new ProductDAO();

	public void init() {

		prd = new ProductDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// Thiết lập tiếng việt
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("pid"));
		prd.delete(id);
		response.sendRedirect("admin-home-product");

	}

}
