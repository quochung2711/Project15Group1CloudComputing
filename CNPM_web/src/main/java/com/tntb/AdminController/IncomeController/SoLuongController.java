package com.tntb.AdminController.IncomeController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.IncomeDao;
import com.tntb.model.IncomeModel;
import com.tntb.model.ProductBuyModel;

@WebServlet(urlPatterns= {"/admin-home-income"})
public class SoLuongController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3002491710434603961L;
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
		List<IncomeModel> list = new ArrayList<IncomeModel>();
		List<ProductBuyModel> list1 = new ArrayList<ProductBuyModel>();
		IncomeDao income = new IncomeDao();
		list1 = income.getspnhieunhat();
		list = income.getAll();
		req.setAttribute("listincome", list);
		req.setAttribute("listproductmaxx", list1);
		RequestDispatcher dis = req.getRequestDispatcher("/view/admin/chartincome.jsp");
		dis.forward(req, response);
	}

}
