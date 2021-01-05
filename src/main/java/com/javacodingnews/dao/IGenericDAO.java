package com.javacodingnews.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.javacodingnews.mapper.IRowMapper;

public interface IGenericDAO<T> {
	
	Connection getConnection();
	
	void setParams(PreparedStatement statement, Object... params);
	
	List<T> query(String sql, IRowMapper<T> rowMapper, Object... params);
	
	void update(String sql, Object... params);
	
	Long insert(String sql, Object... params);
}
