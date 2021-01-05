package com.javacodingnews.service;

import java.util.List;

import com.javacodingnews.model.NewsModel;

public interface INewsService {
	
	List<NewsModel> findAll();
	
	List<NewsModel> findAll(Integer offset, Integer limit);
	
	NewsModel findOneById(Long id);
	
	List<NewsModel> findByCategoryId(long categoryId);
	
	NewsModel save(NewsModel news);
	
	NewsModel edit(NewsModel news);
	
	void delete(Long[] ids);
	
	int getTotalItem();
}
