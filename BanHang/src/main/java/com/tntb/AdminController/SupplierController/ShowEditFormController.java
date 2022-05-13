package com.tntb.AdminController.SupplierController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.NccDAO;
import com.tntb.model.NCCModel;

@WebServlet(urlPatterns= {"/admin-home-supplie-showeditNCC"})

public class ShowEditFormController extends HttpServlet{
	private static final long serialVersionUID = -6115306347110056344L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		//Thiáº¿t láº­p tiáº¿ng viá»‡t
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String nid = request.getParameter("nccid");
		NccDAO ncdao = new NccDAO();
		NCCModel ncc = ncdao.getNCCById(nid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/edit-NCC.jsp");
		request.setAttribute("ncc", ncc);
		dispatcher.forward(request, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
