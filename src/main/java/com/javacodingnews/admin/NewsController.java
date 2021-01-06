package com.javacodingnews.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javacodingnews.constant.SystemConstant;
import com.javacodingnews.model.NewsModel;
import com.javacodingnews.paging.Pageable;
import com.javacodingnews.paging.RequestPage;
import com.javacodingnews.service.INewsService;
import com.javacodingnews.sorting.Sorter;
import com.javacodingnews.utils.FormUtils;

/**
 * Servlet implementation class NewsController
 */
@WebServlet("/admin-news")
public class NewsController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@Inject
	private INewsService newsService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsModel model = FormUtils.toModel(NewsModel.class, request);		
		
		//mapping query param to an object
		Pageable pageable = new RequestPage(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		
		//set total item
		model.setTotalItem(this.newsService.getTotalItem());
		
		//set total page
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		
		//set listResult
		model.setListResult(this.newsService.findAll(pageable));
		
		//set attribute
		request.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = request.getRequestDispatcher("views/admin/news/list.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
