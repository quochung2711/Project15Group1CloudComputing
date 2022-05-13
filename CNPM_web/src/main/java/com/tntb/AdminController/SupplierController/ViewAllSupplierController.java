package com.tntb.AdminController.SupplierController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.NccDAO;
import com.tntb.model.NCCModel;

@WebServlet(urlPatterns = { "/admin-home-supplie", "/admin-trang-chu-supplie" })
public class ViewAllSupplierController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7409128944655206286L;

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
		NccDAO ncdao = new NccDAO();
		List<NCCModel> listnews = ncdao.getAllNCC();
		// 3.Thiáº¿t láº­p dá»¯ liá»‡u lÃªn JSP
		req.setAttribute("listallncc", listnews);
		// 4.Tráº£ vá»� trang JSP nÃ o
		RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-NCC.jsp");
		rq.forward(req, response);
	}

	
}
