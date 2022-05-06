package com.tntb.AdminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tntb.dao.CategoryDAO;
import com.tntb.dao.ContactDAO;
import com.tntb.dao.ProductDAO;
import com.tntb.model.CategoryModel;
import com.tntb.model.ContactModel;
import com.tntb.model.ProductModel;

@WebServlet(name = "logoutcontrol", urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		// 1.Khởi tạo DAO
		ProductDAO productDao = new ProductDAO();

		CategoryDAO categoryDao = new CategoryDAO();

		ContactDAO contactDao = new ContactDAO();

		// 2.Sử dụng đối tượng list để chứa danh sấch từ ProductDAO
		List<ProductModel> list = productDao.getTop6Product();
		List<ProductModel> list1 = productDao.getTop5BestSeller();
		List<CategoryModel> listCate = categoryDao.getAllCategory();
		List<ContactModel> listContact = contactDao.getAllContact();
		// 3.Thiết lập dữ liệu lên JSP
		req.setAttribute("list6product", list);
		req.setAttribute("list5bestseller", list1);
		req.setAttribute("listAllCate", listCate);
		req.setAttribute("listContact", listContact);
		HttpSession session = req.getSession();
		session.removeAttribute("account");
		req.getRequestDispatcher("/view/home.jsp").forward(req, resp);
	}
}
