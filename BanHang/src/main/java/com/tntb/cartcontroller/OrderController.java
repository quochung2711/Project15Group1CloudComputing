package com.tntb.cartcontroller;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tntb.model.AccountModel;
import com.tntb.model.CartItemModel;
import com.tntb.model.CartModel;
import com.tntb.services.CartItemService;
import com.tntb.services.CartService;
import com.tntb.services.UserService;
import com.tntb.services.impl.CartItemServiceImpl;
import com.tntb.services.impl.CartServiceImpl;
import com.tntb.services.impl.UserServiceImpl;
import com.tntb.until.RandomUUID;



@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/member/order")
public class OrderController extends HttpServlet {
	UserService userService = new UserServiceImpl();
	CartService cartService = new CartServiceImpl();
	CartItemService cartItemService = new CartItemServiceImpl();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
    Date date = new Date();  
	long time = date.getTime();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("account");
		AccountModel buyer = (AccountModel) obj;
		CartModel cart = new CartModel();
		cart.setBuyer(buyer);
		cart.setBuyDate(date);
		cart.setId(RandomUUID.getRandomID());
		cartService.insert(cart);

		Object objCart = session.getAttribute("cart");
		if (objCart != null) {
			// ep ve dung kieu cua no khi them vao o phan them vao gio hang controller
			@SuppressWarnings("unchecked")
			Map<Integer, CartItemModel> map = (Map<Integer, CartItemModel>) objCart;

			for (CartItemModel cartItem : map.values()) {
				cartItem.setCart(cart);
				cartItem.setId(RandomUUID.getRandomID());
				
				cartItemService.insert(cartItem);
				
			}

		}
		session.removeAttribute("cart");
		/* resp.sendRedirect(req.getContextPath() + "/home"); */
		RequestDispatcher rq = req.getRequestDispatcher("/view/order-success.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}