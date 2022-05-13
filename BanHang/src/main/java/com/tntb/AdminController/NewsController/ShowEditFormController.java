package com.tntb.AdminController.NewsController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.NewsDAO;
import com.tntb.model.NewsModel;

@WebServlet(urlPatterns= {"/admin-home-news-showeditnew"})
public class ShowEditFormController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9034286955578305602L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Thiết lập tiếng việt
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String nid = request.getParameter("nid");
		NewsDAO ndao = new NewsDAO();
		NewsModel listnews = ndao.getNewsById(nid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/edit-news.jsp");
		request.setAttribute("news", listnews);
		dispatcher.forward(request, response);
	}

	/*----------------NEWS-------------*/
	
}
