package com.tntb.AdminController.SupplierController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.NccDAO;

@WebServlet(urlPatterns = { "/admin-home-supplie-insertNCC" })
public class AddSupplierController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5466292632768280332L;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// Thiết lập tiếng việt
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("nccname");
		String phone = req.getParameter("nccphone");
		String address = req.getParameter("nccaddress");

		NccDAO ncdao = new NccDAO();
		ncdao.insertncc(name, phone, address);

		response.sendRedirect("admin-home-supplie");

	}

}
