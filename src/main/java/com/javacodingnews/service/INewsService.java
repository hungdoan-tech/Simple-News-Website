package com.javacodingnews.service;

import java.util.List;

import com.javacodingnews.model.NewsModel;
import com.javacodingnews.paging.Pageable;

public interface INewsService {
	
	List<NewsModel> findAll();
	
	List<NewsModel> findAll(Pageable pageable);
	
	NewsModel findOneById(Long id);
	
	List<NewsModel> findByCategoryId(long categoryId);
	
	NewsModel save(NewsModel news);
	
	NewsModel edit(NewsModel news);
	
	void delete(Long[] ids);
	
	int getTotalItem();
}
