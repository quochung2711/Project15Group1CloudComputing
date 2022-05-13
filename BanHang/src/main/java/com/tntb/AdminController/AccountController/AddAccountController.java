package com.tntb.AdminController.AccountController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.model.AccountModel;
import com.tntb.services.UserService;
import com.tntb.services.impl.UserServiceImpl;

@WebServlet(urlPatterns= {"/admin-home-account-insert"})
public class AddAccountController extends HttpServlet  {

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
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		// Thiết lập tiếng việt
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");

		
		service = new UserServiceImpl();
	
		
		AccountModel user = new AccountModel(fullname, phone, username, password, email, 2);
		service.insert(user);
		response.sendRedirect("admin-home-account");
	}
	
	
}
