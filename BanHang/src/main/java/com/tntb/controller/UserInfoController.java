package com.tntb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.model.AccountModel;
import com.tntb.services.UserService;
import com.tntb.services.impl.UserServiceImpl;

@WebServlet(urlPatterns= {"/userinfo"})
public class UserInfoController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9190184684806901271L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		UserService service = new UserServiceImpl();

		AccountModel existingUser = service.getbyid(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/userinfo.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
