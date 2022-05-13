package com.tntb.AdminController.NewsController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.NewsDAO;


@WebServlet(urlPatterns= {"/admin-home-news-insertnews"})
public class AddNewController extends HttpServlet {
	
	private static final long serialVersionUID = -6115306347110056344L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String imagenew = req.getParameter("image");
		String titlenew = req.getParameter("title");
		String briefnew = req.getParameter("brief");
		String contentnew = req.getParameter("content");			
		NewsDAO ndao = new NewsDAO();
		ndao.insertnew(imagenew,titlenew,briefnew,contentnew);
		
		resp.sendRedirect("admin-home-news");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
