package com.javacodingnews.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacodingnews.model.NewsModel;
import com.javacodingnews.service.INewsService;
import com.javacodingnews.utils.HttpUtils;

/**
 * Servlet implementation class NewsAPI
 */
@WebServlet("/api-admin-news")
public class NewsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private INewsService newsService;
	   
	/**
     * @see HttpServlet#HttpServlet()
     */
    public NewsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel requestNews =  HttpUtils.of(request.getReader()).toModel(NewsModel.class);
		NewsModel news = this.newsService.save(requestNews);		
		objectMapper.writeValue(response.getOutputStream(), news);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		NewsModel requestNews =  HttpUtils.of(request.getReader()).toModel(NewsModel.class);
		NewsModel news = this.newsService.save(requestNews);		
		objectMapper.writeValue(response.getOutputStream(), news);
		super.doPut(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
	
	
	private void saveOrUpdate() {
		
	}
}
