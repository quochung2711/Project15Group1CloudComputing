package com.tntb.AdminController.NewsController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.NewsDAO;

@WebServlet(urlPatterns= {"/admin-home-news-editnews"})
public class EditNewsController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9034286955578305602L;

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
		String nid = req.getParameter("nid");
		String imagenew = req.getParameter("image");
		String titlenew = req.getParameter("title");
		String briefnew = req.getParameter("brief");
		String contentnew = req.getParameter("content");

		NewsDAO ndao = new NewsDAO();
		ndao.updatenew(nid, imagenew, titlenew, briefnew, contentnew);

		response.sendRedirect("admin-home-news");
	}

	
}
