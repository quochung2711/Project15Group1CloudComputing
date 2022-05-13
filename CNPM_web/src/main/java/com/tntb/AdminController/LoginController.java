package com.tntb.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tntb.dao.LoginDAO;
import com.tntb.model.AccountModel;

@WebServlet(urlPatterns = { "/login2" })
public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/view/login/login2.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		LoginDAO logindao = new LoginDAO();
		AccountModel account = logindao.login(username, password);

		String alertMsg = "";
		if (username.isEmpty()) {
			alertMsg = "Vui lòng điền tên đăng nhập";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login/login2.jsp").forward(req, resp);
		}
		if (password.isEmpty()) {
			alertMsg = "Vui lòng điền mật khẩu";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login/login2.jsp").forward(req, resp);
		}
		if (account == null) {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login/login2.jsp").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("account", account);
			if (session != null && session.getAttribute("account") != null) {
				account = (AccountModel) session.getAttribute("account");
				if (account.getRoleid() == 1) {
					resp.sendRedirect("admin-home");
				} else if (account.getRoleid() == 0) {
					resp.sendRedirect("home");
				} else {
					resp.sendRedirect("home");

				}
			} else {
				resp.sendRedirect("login2");
			}
		}
	}
}
