package com.tntb.AdminController.Product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.ProductDAO;
import com.tntb.model.ProductModel;

@WebServlet(urlPatterns= {"/admin-updateproduct"})
public class UpdateProductController extends HttpServlet{

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
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		// Thiết lập tiếng việt
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("pid"));
		int id2 = Integer.parseInt(req.getParameter("cateid"));
		int id3 = Integer.parseInt(req.getParameter("spid"));
		String fullname = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));
		String phone = req.getParameter("content");
		int discount = Integer.parseInt(req.getParameter("discount"));
		String image = req.getParameter("image");
		int amount = Integer.parseInt(req.getParameter("amount"));
		int sl = Integer.parseInt(req.getParameter("sl"));

		ProductModel product = new ProductModel(id, id2, id3, fullname, price, phone, discount, image, amount, sl);
		prd.edit(product);
		response.sendRedirect("admin-home-product");
	}
	
}
