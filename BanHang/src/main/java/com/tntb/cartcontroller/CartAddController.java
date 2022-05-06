package com.tntb.cartcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tntb.dao.ProductDAO;
import com.tntb.model.CartItemModel;
import com.tntb.model.ProductModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/member/cart-add"})
public class CartAddController extends HttpServlet{
	ProductDAO prod = new ProductDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		String pid = req.getParameter("pid");
		String quality = req.getParameter("quantity");
		
		ProductModel product = new ProductModel();
		product = prod.getbyid(Integer.parseInt(pid));
		CartItemModel cartitem = new CartItemModel();
		cartitem.setQuantity(Integer.parseInt(quality));
		cartitem.setUnitPrice(product.getPprice());
		cartitem.setProduct(product);
		
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("cart");
		if(obj == null) {
			Map<Integer, CartItemModel> map = new HashMap<Integer, CartItemModel>();
			map.put(cartitem.getProduct().getpID(), cartitem);
			session.setAttribute("cart", map);
		}else {
			Map<Integer, CartItemModel> map  =  extracted(obj);
			CartItemModel existedCartitem = map.get(Integer.parseInt(pid));
			if(existedCartitem == null) {
				map.put(product.getpID(), cartitem);
				
			}else {
				existedCartitem.setQuantity(existedCartitem.getQuantity()+Integer.parseInt(quality));
			}
			session.setAttribute("cart", map);
		}
		resp.sendRedirect(req.getContextPath()+"/member/cart");
	}
	@SuppressWarnings("unchecked")
	private Map<Integer, CartItemModel> extracted(Object obj){
		return (Map<Integer, CartItemModel>) obj;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
