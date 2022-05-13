package com.tntb.AdminController.AccountController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.services.UserService;
import com.tntb.services.impl.UserServiceImpl;

@WebServlet(urlPatterns= {"/admin-home-account-delete"})
public class DeleteAccountController extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService service = new UserServiceImpl();
	public void init() {
		service = new UserServiceImpl();	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// Thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		service.delete(id);
		resp.sendRedirect("admin-home-account");

	}
	
	
}
