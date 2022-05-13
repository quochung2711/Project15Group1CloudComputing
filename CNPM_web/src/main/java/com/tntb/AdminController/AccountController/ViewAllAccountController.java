package com.tntb.AdminController.AccountController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.model.AccountModel;
import com.tntb.services.UserService;
import com.tntb.services.impl.UserServiceImpl;

@WebServlet(urlPatterns= {"/admin-home-account","/admin-trang-chu-account"})
public class ViewAllAccountController extends HttpServlet  {

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		service = new UserServiceImpl();
		List<AccountModel> listalluser = service.getAll();
		// 3.Thiết lập dữ liệu lên JSP
		req.setAttribute("listalluser", listalluser);
		// 4.Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-account.jsp");
		rq.forward(req, resp);
	}
	
	
}
