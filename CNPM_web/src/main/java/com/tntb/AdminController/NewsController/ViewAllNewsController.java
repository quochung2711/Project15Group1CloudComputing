package com.tntb.AdminController.NewsController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.NewsDAO;
import com.tntb.model.NewsModel;

@WebServlet(urlPatterns= {"/admin-home-news","/admin-trang-chu-news"})
public class ViewAllNewsController extends HttpServlet {

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
		NewsDAO ndao = new NewsDAO();
		List<NewsModel> listnews = ndao.getAllNews();
		// 3.Thiáº¿t láº­p dá»¯ liá»‡u lÃªn JSP
		req.setAttribute("listallnew", listnews);
		// 4.Tráº£ vá»� trang JSP nÃ o
		RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-news.jsp");
		rq.forward(req, response);
	}

}
