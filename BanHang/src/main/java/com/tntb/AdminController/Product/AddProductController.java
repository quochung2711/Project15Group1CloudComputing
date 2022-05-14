package com.tntb.AdminController.Product;

import java.io.IOException;
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
		
		String cateid = req.getParameter("cateid");
		String supid = req.getParameter("spid");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String content = req.getParameter("content");
		String discount = req.getParameter("discount");
		String image = req.getParameter("image");
		String amount = req.getParameter("amount");
		String sl = req.getParameter("sl");

		prd = new ProductDAO();
		ProductModel product = new ProductModel(Integer.parseInt(cateid), Integer.parseInt(supid), name, Integer.parseInt(price), content, Integer.parseInt(discount), image, Integer.parseInt(amount), Integer.parseInt(sl));
		prd.insert(product);
		response.sendRedirect("admin-home-product");

	}

}
