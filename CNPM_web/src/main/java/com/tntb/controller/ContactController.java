package com.tntb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tntb.dao.ContactDAO;
import com.tntb.model.ContactModel;



@WebServlet(urlPatterns= {"/contact"})
public class ContactController extends HttpServlet {
	
	private static final long serialVersionUID = -6115306347110056344L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Thiết lập tiếng việt
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//1.Khởi tạo DAO	
		ContactDAO contactDao = new ContactDAO();
		
		//2.Sử dụng đối tượng list để chứa danh sấch từ ProductDAO
		List<ContactModel> listContact = contactDao.getAllContact();
		//3.Thiết lập dữ liệu lên JSP
		req.setAttribute("listContact", listContact);
		//4.Trả về trang JSP nào
		RequestDispatcher rq = req.getRequestDispatcher("/view/contact.jsp");
		rq.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
