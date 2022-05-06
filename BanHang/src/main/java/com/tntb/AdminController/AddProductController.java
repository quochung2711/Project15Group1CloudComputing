package com.tntb.AdminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.CategoryDAO;
import com.tntb.dao.NccDAO;
import com.tntb.model.CategoryModel;
import com.tntb.model.NCCModel;



@WebServlet(urlPatterns= {"/admin-addPro"})
public class AddProductController extends HttpServlet {
	
	private static final long serialVersionUID = -6115306347110056344L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
			
		NccDAO ncdao = new NccDAO();
		
		
		CategoryDAO categoryDao = new CategoryDAO();
		
		List<CategoryModel> listCate = categoryDao.getAllCategory();
		List<NCCModel> listnews = ncdao.getAllNCC();
		
		req.setAttribute("listAllCate", listCate);
		req.setAttribute("listallncc", listnews);
		RequestDispatcher rq = req.getRequestDispatcher("/view/admin/add-product.jsp");
		rq.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
