package com.javacodingnews.service.impl;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.javacodingnews.dao.INewsDAO;
import com.javacodingnews.model.NewsModel;
import com.javacodingnews.service.INewsService;

@ManagedBean
public class NewsService implements INewsService{

	@Inject
	private INewsDAO newsDAO;
	
	@Override
	public List<NewsModel> findByCategoryId(long categoryId) {
		return newsDAO.findByCategoryId(categoryId);		
	}

	@Override
	public NewsModel save(NewsModel news) {
		Long id = newsDAO.save(news);
		return null;
	}
}
