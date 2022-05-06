package com.tntb.AdminController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tntb.dao.CategoryDAO;
import com.tntb.dao.IncomeDao;
import com.tntb.dao.NccDAO;
import com.tntb.dao.NewsDAO;
import com.tntb.dao.OrderListDao;
import com.tntb.dao.ProductDAO;
import com.tntb.model.AccountModel;
import com.tntb.model.CategoryModel;
import com.tntb.model.IncomeModel;
import com.tntb.model.NCCModel;
import com.tntb.model.NewsModel;
import com.tntb.model.OrderlListModel;
import com.tntb.model.ProductBuyModel;
import com.tntb.model.ProductModel;
import com.tntb.services.CartItemService;
import com.tntb.services.UserService;
import com.tntb.services.impl.CartItemServiceImpl;
import com.tntb.services.impl.UserServiceImpl;



@WebServlet("/")
public class ViewAccountController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService service = new UserServiceImpl();
	private CategoryDAO categoryDao = new CategoryDAO();
	private ProductDAO prd = new ProductDAO();
	public void init() {
		service = new UserServiceImpl();
		categoryDao = new CategoryDAO(); 
		prd = new ProductDAO();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Thiết lập tiếng việt
		response.setContentType("text/htm");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/admin-insertcategory":
            	inserCategory(request, response);
                break;
            case "/admin-deletecategory":
                deletecategory(request, response);
                break;
            case "/admin-editcategory":
            	showEditcategoryForm(request, response);
                break;
            case "/adminCRUD-cate":
            	listCategory(request, response);
                break;
            case "/admin-updatecategory":
            	updatecategory(request, response);
            	break;
            case "/admin-insertproduct":
            	inserProduct(request, response);
            	break;
            case "/admin-deleteproduct":
            	deleteProduct(request, response);
            	break;	
            case "/adminCRUD-product":
            	listProduct(request, response);
            	break;
            case "/admin-editproduct":
            	showEditProductForm(request, response);
            	break;
			case "/admin-new":
				showNewForm(request, response);
				break;
			case "/admin-insert":
				insertUser(request, response);
				break;
			case "/admin-delete":
				deleteUser(request, response);
				break;
			case "/admin-edit":
				showEditForm(request, response);
				break;
			case "/admin-update":
				updateUser(request, response);
				break;
			case "/admin-updateproduct":
				editproduct(request, response);
				break;
			case "/adminCRUD-cartlist":
				showCart(request, response);
				break;
			case "/admin/cart-remove":
				deleteCart(request, response);
				break;
			case "/admin-CRUDnews":
				listnews(request, response);
				break;
			case "/admin-editnews":
				editnew(request, response);
				break;
			case "/admin-deletenews":
				deletenew(request, response);
				break;
			case "/admin-insertnews":
				insertnew(request, response);
				break;
			case "/admin-showeditnew":
				showEditNews(request, response);
				break;
			
			case "/admin-CRUDNCC":
				listNCC(request, response);
				break;
			case "/admin-editNCC":
				editNCC(request, response);
				break;
			case "/admin-deleteNCC":
				deleteNCC(request, response);
				break;
			case "/admin-insertNCC":
				insertNCC(request, response);
				break;
			case "/admin-showeditNCC":
				showEditNCC(request, response);
				break;
			 case "/admin-income":
	                showincome(request, response);
	                break;
			 case "/admin-chart":
				 	doGetincome(request, response);
	                break;
			 case "/admin-thang":
				 	doGetincomethang(request, response);
	                break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	 
		 	 
		 private void showincome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 	resp.setContentType("text/htm");
				resp.setCharacterEncoding("UTF-8");
				resp.setCharacterEncoding("UTF-8");
				List<IncomeModel> list = new ArrayList<IncomeModel>();
				List<ProductBuyModel> list1 = new ArrayList<ProductBuyModel>();
				IncomeDao income = new IncomeDao();
				list1 = income.getspnhieunhat();
				list = income.getAll();
				req.setAttribute("listincome", list);
				req.setAttribute("listproductmaxx", list1);
				RequestDispatcher dis = req.getRequestDispatcher("/view/admin/chartincome.jsp");
				dis.forward(req, resp);
			
		
	}
		 private void doGetincome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				List<IncomeModel> list = new ArrayList<IncomeModel>();
				Gson gson = new Gson();
				IncomeDao income = new IncomeDao();
				list = income.getAll();
				resp.setContentType("application/json");
				gson.toJson(list);
				req.setAttribute("listdoanhthu", gson.toJson(list));
				req.getRequestDispatcher("/view/admin/a.jsp").forward(req, resp);
				
			}
		 private void doGetincomethang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
				req.getRequestDispatcher("/view/admin/a.jsp").forward(req, resp);
				
			}
		private void editproduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
				int id = Integer.parseInt(req.getParameter("pid"));
				int id2 = Integer.parseInt(req.getParameter("cateid"));
				int id3 = Integer.parseInt(req.getParameter("spid"));
				String fullname = req.getParameter("name");
				int price = Integer.parseInt(req.getParameter("price"));
				String phone = req.getParameter("content");
				int discount = Integer.parseInt(req.getParameter("discount"));
				String image = req.getParameter("image");
				int amount = Integer.parseInt(req.getParameter("amount"));
				int sl = Integer.parseInt(req.getParameter("sl"));

				ProductModel product = new ProductModel(id, id2, id3, fullname, price, phone, discount, image, amount, sl);
				prd.edit(product);
				resp.sendRedirect("adminCRUD-product");
				
			}

			private void showEditForm(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("uid"));
				UserService service = new UserServiceImpl();

				AccountModel existingUser = service.getbyid(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/edit-account.jsp");
				request.setAttribute("user", existingUser);
				dispatcher.forward(request, response);

			}

			private void showNewForm(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/view-account.jsp");
				dispatcher.forward(request, response);
			}

			private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
				String fullname = req.getParameter("fullname");
				String phone = req.getParameter("phone");
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String email = req.getParameter("email");
				String roleid = req.getParameter("roleid");
				
				UserService service = new UserServiceImpl();
			
				
				AccountModel user = new AccountModel(fullname, phone, username, password, email, Integer.parseInt(roleid));
				service.insert(user);
				resp.sendRedirect("adminlist");

			}
			private void showCart(HttpServletRequest req, HttpServletResponse resp)
					throws SQLException, IOException, ServletException {
				OrderListDao sv = new OrderListDao();
				List<OrderlListModel> listallcart = sv.getAll();
				
				req.setAttribute("listcart", listallcart);
				
				RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-cartitem.jsp");
				rq.forward(req, resp);
			}
			

			private void listUser(HttpServletRequest req, HttpServletResponse resp)
					throws SQLException, IOException, ServletException {
				UserService sv = new UserServiceImpl();
				List<AccountModel> listalluser = sv.getAll();
				// 3.Thiết lập dữ liệu lên JSP
				req.setAttribute("listalluser", listalluser);
				// 4.Trả về trang JSP nào
				RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-account.jsp");
				rq.forward(req, resp);
			}

			private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
				int id = Integer.parseInt(req.getParameter("uid"));
				String fullname = req.getParameter("fullname");
				String phone = req.getParameter("phone");
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String email = req.getParameter("email");
				String roleid = req.getParameter("roleid");

				AccountModel user = new AccountModel(id, fullname, phone, username, password, email, Integer.parseInt(roleid));
				service.edit(user);
				resp.sendRedirect("adminlist");
			}
			private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
				CartItemService sv = new CartItemServiceImpl();
				String id = request.getParameter("cartid");
				sv.delete(id);
				response.sendRedirect("adminCRUD-cartlist");

			}
			private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

				int id = Integer.parseInt(request.getParameter("id"));
				service.delete(id);
				response.sendRedirect("adminlist");

			}
			private void listProduct(HttpServletRequest req, HttpServletResponse resp)
					throws SQLException, IOException, ServletException {
				ProductDAO prd = new ProductDAO();
				List<ProductModel> listallpro = prd.getAllProduct();
				req.setAttribute("listallproduct", listallpro);
				RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-product.jsp");
				rq.forward(req, resp);
			}
			private void showEditProductForm(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, ServletException, IOException {
				int id = Integer.parseInt(request.getParameter("pid"));
				
				ProductDAO productdao = new ProductDAO();
				ProductModel productmodel =productdao.getbyid(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/edit-product.jsp");
				request.setAttribute("product", productmodel);
				dispatcher.forward(request, response);

			}
			private void inserProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
				String cateid = req.getParameter("cateid");
				String supid = req.getParameter("spid");
				String name = req.getParameter("name");
				String price = req.getParameter("price");
				String content = req.getParameter("content");
				String discount = req.getParameter("discount");
				String image = req.getParameter("image");
				String amount = req.getParameter("amount");
				String sl = req.getParameter("sl");

				ProductDAO prd = new ProductDAO();
				ProductModel product = new ProductModel(Integer.parseInt(cateid), Integer.parseInt(supid), name, Integer.parseInt(price), content, Integer.parseInt(discount), image, Integer.parseInt(amount), Integer.parseInt(sl));
				prd.insert(product);
				resp.sendRedirect("adminCRUD-product");

			}
			 private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
					    throws SQLException, IOException {
					        int id = Integer.parseInt(request.getParameter("pid"));
					        prd.delete(id);
					        response.sendRedirect("adminCRUD-product");

					    }
			 private void listCategory(HttpServletRequest req, HttpServletResponse resp)
						throws SQLException, IOException, ServletException {
					CategoryDAO categoryDao = new CategoryDAO();
					List<CategoryModel> listCate = categoryDao.getAllCategory();
					req.setAttribute("listAllCate", listCate);
					RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-category.jsp");
					rq.forward(req, resp);
				}
				private void showEditcategoryForm(HttpServletRequest request, HttpServletResponse response)
						throws SQLException, ServletException, IOException {
					int id = Integer.parseInt(request.getParameter("cid"));
					CategoryDAO cateDao = new CategoryDAO();

					CategoryModel categorymodel = cateDao.getbyid(id);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/edit-category.jsp");
					request.setAttribute("category", categorymodel);
					dispatcher.forward(request, response);

				}
				private void inserCategory(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
					String name = req.getParameter("name");
					String description = req.getParameter("description");

					
					CategoryModel categorymodel = new CategoryModel(name, description);
					categoryDao.insert(categorymodel);
					resp.sendRedirect("adminCRUD-cate");

				}
				private void updatecategory(HttpServletRequest request, HttpServletResponse response)
						    throws SQLException, IOException {
						        int id = Integer.parseInt(request.getParameter("cid"));
						        String name = request.getParameter("name");
						        String desp = request.getParameter("decription");

						        CategoryModel book = new CategoryModel(id, name, desp);
						        categoryDao.edit(book);
						        response.sendRedirect("adminCRUD-cate");
				}
				 private void deletecategory(HttpServletRequest request, HttpServletResponse response)
						    throws SQLException, IOException {
						        int id = Integer.parseInt(request.getParameter("cid"));
						        categoryDao.delete(id);
						        response.sendRedirect("adminCRUD-cate");

						    }
					/*----------------NEWS-------------*/
				 private void listnews(HttpServletRequest req, HttpServletResponse resp)
							throws SQLException, IOException, ServletException {
					 	NewsDAO ndao = new NewsDAO();
						List<NewsModel> listnews = ndao.getAllNews();
						// 3.Thiáº¿t láº­p dá»¯ liá»‡u lÃªn JSP
						req.setAttribute("listallnew", listnews);
						// 4.Tráº£ vá»� trang JSP nÃ o
						RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-news.jsp");
						rq.forward(req, resp);
					}
				 private void showEditNews(HttpServletRequest request, HttpServletResponse response)
							throws SQLException, ServletException, IOException {
						String nid = request.getParameter("nid");
						NewsDAO ndao = new NewsDAO();
						NewsModel listnews = ndao.getNewsById(nid);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/edit-news.jsp");
						request.setAttribute("news", listnews);
						dispatcher.forward(request, response);

					}
					private void insertnew(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
						
						String imagenew = req.getParameter("image");
						String titlenew = req.getParameter("title");
						String briefnew = req.getParameter("brief");
						String contentnew = req.getParameter("content");			
						NewsDAO ndao = new NewsDAO();
						ndao.insertnew(imagenew,titlenew,briefnew,contentnew);
						
						resp.sendRedirect("admin-CRUDnews");

					}
					 private void deletenew(HttpServletRequest request, HttpServletResponse response)
							    throws SQLException, IOException {
							        String id = request.getParameter("nid");
							        NewsDAO ndao = new NewsDAO();
							        ndao.deletenews(id);
							        response.sendRedirect("admin-CRUDnews");

							    }
		 
					 private void editnew(HttpServletRequest req, HttpServletResponse resp) throws IOException {
							String nid = req.getParameter("nid");
							String imagenew = req.getParameter("image");
							String titlenew = req.getParameter("title");
							String briefnew = req.getParameter("brief");
							String contentnew = req.getParameter("content");
							
							NewsDAO ndao = new NewsDAO();
							ndao.updatenew(nid,imagenew,titlenew,briefnew,contentnew);
							
							resp.sendRedirect("admin-CRUDnews");
							
						}
					 	
						/* -------NhÃ  cung cáº¥p------- */
					 private void listNCC(HttpServletRequest req, HttpServletResponse resp)
								throws SQLException, IOException, ServletException {
						 	NccDAO ncdao = new NccDAO();
							List<NCCModel> listnews = ncdao.getAllNCC();
							// 3.Thiáº¿t láº­p dá»¯ liá»‡u lÃªn JSP
							req.setAttribute("listallncc", listnews);
							// 4.Tráº£ vá»� trang JSP nÃ o
							RequestDispatcher rq = req.getRequestDispatcher("/view/admin/view-NCC.jsp");
							rq.forward(req, resp);
						}
					 private void showEditNCC(HttpServletRequest request, HttpServletResponse response)
								throws SQLException, ServletException, IOException {
							String nid = request.getParameter("nccid");
							NccDAO ncdao = new NccDAO();
							NCCModel ncc = ncdao.getNCCById(nid);
							RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/edit-NCC.jsp");
							request.setAttribute("ncc", ncc);
							dispatcher.forward(request, response);

						}
						private void insertNCC(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
							
							String name = req.getParameter("nccname");
							String phone = req.getParameter("nccphone");
							String address = req.getParameter("nccaddress");
									
							NccDAO ncdao = new NccDAO();
							ncdao.insertncc(name,phone,address);
							
							resp.sendRedirect("admin-CRUDNCC");

						}
						 private void deleteNCC(HttpServletRequest request, HttpServletResponse response)
								    throws SQLException, IOException {
								        String id = request.getParameter("nccid");
								        NccDAO nccdao = new NccDAO();
								        nccdao.deletencc(id);
								        response.sendRedirect("admin-CRUDNCC");

								    }
			 
						 private void editNCC(HttpServletRequest req, HttpServletResponse resp) throws IOException {
								String nccid = req.getParameter("nccid");
								String nccname = req.getParameter("name");
								String nccphone = req.getParameter("phone");
								String nccaddress = req.getParameter("address");
								
								NccDAO nccdao = new NccDAO();
								nccdao.updatencc(nccid,nccname,nccphone,nccaddress);
								
								resp.sendRedirect("admin-CRUDNCC");
								
							}
		 
		 
		 
		 
		 
		 
		 
		 
		 
}
