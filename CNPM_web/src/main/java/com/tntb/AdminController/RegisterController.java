package com.tntb.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tntb.services.UserService;
import com.tntb.services.impl.UserServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			resp.sendRedirect("admin-home");
			return;
		}
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect("home");
					return;
				}
			}
		}
		req.getRequestDispatcher("/view/login/register.jsp").forward(req, resp);
	}
	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String fullname = req.getParameter("fullname");
		String phone = req.getParameter("phone");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");

		UserService service = new UserServiceImpl();
		String alertMsg = "";
			
		if(fullname.isEmpty()) {
			alertMsg="Tên đầy đủ không được rỗng";
			req.setAttribute("alert",alertMsg);
			req.getRequestDispatcher("/view/login/register.jsp").forward(req, resp);
		}
		if(phone.isEmpty()) {
			alertMsg="Số điện thoại không được rỗng";
			req.setAttribute("alert",alertMsg);
			req.getRequestDispatcher("/view/login/register.jsp").forward(req, resp);
		}
		if(username.isEmpty()) {
			alertMsg="Tên đăng nhập không được rỗng";
			req.setAttribute("alert",alertMsg);
			req.getRequestDispatcher("/view/login/register.jsp").forward(req, resp);
		}		
		if(password.isEmpty()) {
			alertMsg="Mật khẩu được rỗng";
			req.setAttribute("alert",alertMsg);
			req.getRequestDispatcher("/view/login/register.jsp").forward(req, resp);
		}
		if(email.isEmpty()) {
			alertMsg="Email không  được rỗng";
			req.setAttribute("alert",alertMsg);
			req.getRequestDispatcher("/view/login/register.jsp").forward(req, resp);
		}
		if(service.checkExitEmail(email)) {
			alertMsg="Email đã tồn tại";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login/register.jsp").forward(req, resp);
		}
		if(service.checkExitUsername(username)) {
			alertMsg="Tên đăng nhập đã tồn tại";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login/register.jsp").forward(req, resp);
		}
		
		
		boolean isSuccess = service.register(fullname, phone, username, password, email);
		
		if(isSuccess) {
			alertMsg="Tạo thành công";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login/register-success.jsp").forward(req, resp);
		}else {
			alertMsg="Hệ thống lỗi";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login/register.jsp").forward(req, resp);
		}
	}
}
