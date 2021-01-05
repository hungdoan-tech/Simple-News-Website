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
		Long newsId = newsDAO.save(news);	
		NewsModel outputNews = newsDAO.findOneById(newsId);
		return outputNews;
	}

	@Override
	public NewsModel findOneById(Long id) {
		NewsModel outputNews = newsDAO.findOneById(id);
		return outputNews;
	}
}
