package com.javacodingnews.dao;

import java.util.List;

import com.javacodingnews.model.NewsModel;
import com.javacodingnews.paging.Pageable;

public interface INewsDAO {
	
	List<NewsModel> findAll();
	
	List<NewsModel> findAll(Pageable pageable);
	
	NewsModel findOneById(Long id);
	
	List<NewsModel> findByCategoryId(long categoryId);
	
	Long save(NewsModel news);
	
	Long edit(NewsModel news);
	
	void delete(Long id);
	
	int getTotalItem();
}
