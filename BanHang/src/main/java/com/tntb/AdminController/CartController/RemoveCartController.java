package com.tntb.AdminController.CartController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.services.CartItemService;
import com.tntb.services.impl.CartItemServiceImpl;

@WebServlet(urlPatterns= {"/admin-home-cart-remove"})
public class RemoveCartController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8075228469638707845L;
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
		CartItemService sv = new CartItemServiceImpl();
		String id = request.getParameter("cartid");
		sv.delete(id);
		response.sendRedirect("admin-home-cart");
	}
	
	 
}
