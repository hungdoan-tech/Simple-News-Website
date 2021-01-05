package com.javacodingnews.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.javacodingnews.model.NewsModel;

public class NewsMapper implements IRowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		NewsModel news = new NewsModel();
		try {			
			news.setId(resultSet.getLong("id"));
			news.setTitle(resultSet.getString("title"));
			news.setShortDescription(resultSet.getString("shortdescription"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			return news;		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}	
}
