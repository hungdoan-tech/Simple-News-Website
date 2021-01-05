package com.javacodingnews.dao;

import java.util.List;

import com.javacodingnews.model.NewsModel;

public interface INewsDAO {
	
	List<NewsModel> findByCategoryId(long categoryId);
	
	Long save(NewsModel news);
}
