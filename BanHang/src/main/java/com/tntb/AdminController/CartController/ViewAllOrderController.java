package com.tntb.AdminController.CartController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.OrderListDao;
import com.tntb.model.OrderlListModel;

@WebServlet(urlPatterns= {"/admin-home-cart","/admin-trang-chu-cart"})
public class ViewAllOrderController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8075228469638707845L;
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
		OrderListDao sv = new OrderListDao();
		List<OrderlListModel> listallcart = sv.getAll();
		
		req.setAttribute("listcart", listallcart);
		
		RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-cartitem.jsp");
		rq.forward(req, response);
	}
	
	 
}
