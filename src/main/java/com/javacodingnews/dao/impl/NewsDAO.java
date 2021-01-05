package com.javacodingnews.dao.impl;

import java.util.List;

import javax.annotation.ManagedBean;

import com.javacodingnews.dao.INewsDAO;
import com.javacodingnews.mapper.NewsMapper;
import com.javacodingnews.model.NewsModel;

@ManagedBean
public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO{

	@Override
	public List<NewsModel> findByCategoryId(long categoryId) {
		
		String sql = "Select * from news where categoryid = ?";
		NewsMapper newsMapper = new NewsMapper();
		Object[] objects = {categoryId};
		List<NewsModel> newsList = this.query(sql, newsMapper, objects);
		return newsList;
	}

	@Override
	public Long save(NewsModel news) {
		String sql = "insert into news (title, content, shortdescription, categoryid) values (?,?,?,?)";
		return this.insert(sql, news.getTitle(), news.getContent(), news.getShortDescription(), news.getCategoryId());
	}
}
