package com.tntb.AdminController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tntb.model.AccountModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/waiting"})
public class WaitingController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session != null && session.getAttribute("account")!= null) {
			AccountModel u = (AccountModel) session.getAttribute("account");
			if(u.getRoleid()==1) {
				req.getRequestDispatcher("/view/admin/home.jsp");
			}else if(u.getRoleid()==0) {
				req.getRequestDispatcher("/view/home.jsp");
			}else {
				req.getRequestDispatcher("/view/home.jsp");
				
			}
		}else {
			req.getRequestDispatcher("/view/login2.jsp");
		}
	}
}
