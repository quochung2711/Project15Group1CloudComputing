package com.tntb.AdminController.Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.ProductDAO;
import com.tntb.model.ProductModel;

@WebServlet(urlPatterns = { "/admin-product-add" })
public class AddProductController extends HttpServlet {

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
		
		prd = new ProductDAO();
		List<ProductModel> listallpro = prd.getAllProduct();
		req.setAttribute("listallproduct", listallpro);
		RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-product.jsp");
		rq.forward(req, response);

	}

}
