package com.javacodingnews.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.javacodingnews.dao.INewsDAO;
import com.javacodingnews.model.NewsModel;
import com.javacodingnews.paging.Pageable;
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
		news.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		news.setCreatedBy("");
		Long newsId = newsDAO.save(news);	
		NewsModel outputNews = newsDAO.findOneById(newsId);
		return outputNews;
	}

	@Override
	public NewsModel findOneById(Long id) {
		NewsModel outputNews = newsDAO.findOneById(id);
		return outputNews;
	}

	@Override
	public NewsModel edit(NewsModel news) {
		
		NewsModel oldNews = newsDAO.findOneById(news.getId());
		
		news.setCreatedDate(oldNews.getCreatedDate());
		news.setCreatedBy(oldNews.getCreatedBy());
		Long index = this.newsDAO.edit(news);
		
		return this.newsDAO.findOneById(index); 
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id : ids) {
			this.newsDAO.delete(id);
		}		
	}

	@Override
	public List<NewsModel> findAll() {
		return this.newsDAO.findAll();		
	}

	@Override
	public int getTotalItem() {		
		return this.newsDAO.getTotalItem();
	}

	@Override
	public List<NewsModel> findAll(Pageable pageable) {
		return this.newsDAO.findAll(pageable);		
	}
}
