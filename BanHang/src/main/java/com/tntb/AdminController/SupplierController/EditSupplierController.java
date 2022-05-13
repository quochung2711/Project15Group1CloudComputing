package com.tntb.AdminController.SupplierController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.NccDAO;

@WebServlet(urlPatterns= {"/admin-home-supplie-editNCC"})
public class EditSupplierController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5466292632768280332L;	
	

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
		String nccid = req.getParameter("nccid");
		String nccname = req.getParameter("name");
		String nccphone = req.getParameter("phone");
		String nccaddress = req.getParameter("address");

		NccDAO nccdao = new NccDAO();
		nccdao.updatencc(nccid, nccname, nccphone, nccaddress);

		response.sendRedirect("admin-home-supplie");
	}
	
}
