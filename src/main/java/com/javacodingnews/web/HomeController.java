package com.javacodingnews.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javacodingnews.model.UserModel;
import com.javacodingnews.service.IUserService;
import com.javacodingnews.utils.FormUtils;
import com.javacodingnews.utils.SessionUtil;


/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Inject
	private IUserService userService;
	
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		if(action != null){
			if(action.equals("login")) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);				
			} else if(action.equals("logout")) {
				SessionUtil.getInstance().removeValue(request, "USERMODEL");
				response.sendRedirect(request.getContextPath() + "/trang-chu");
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		if(action != null){
			if(action.equals("login")) {
				UserModel model = FormUtils.toModel(UserModel.class, request);
				model = this.userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
				if(model != null) {
					SessionUtil.getInstance().putValue(request, "USERMODEL", model);
					if(model.getRole().getCode().equals("USER")) {
						response.sendRedirect(request.getContextPath() + "/trang-chu");
					}
					else if(model.getRole().getCode().equals("ADMIN")){
						response.sendRedirect(request.getContextPath() + "/admin-home");
					}
				}				
			}
		}
		else {
			response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
		}
	}
}
