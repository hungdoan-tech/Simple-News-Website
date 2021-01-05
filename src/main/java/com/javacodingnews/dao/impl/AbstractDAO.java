package com.javacodingnews.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.javacodingnews.dao.IGenericDAO;
import com.javacodingnews.mapper.IRowMapper;

public class AbstractDAO<T> implements IGenericDAO<T> {
	
	@Override
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/newswebsite";
			String user = "root";
			String password = "Admin123*";
			return DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void setParams(PreparedStatement statement, Object... params) {
		int index = 1;
		try {
			for (Object param : params) {			
				if(param instanceof Long) {
					statement.setLong(index, (Long) param);
				}
				else if(param instanceof String) {
					statement.setString(index, (String) param);
				}
				else if(param instanceof Integer) {
					statement.setInt(index, (Integer) param);
				}
				else if(param instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) param);
				}
				index++;
			} 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public List<T> query(String sql, IRowMapper<T> rowMapper, Object... params) {
		List<T> listObjectModel = new ArrayList<T>(); 
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = this.getConnection();
			statement = connection.prepareStatement(sql);
			// set params 
			this.setParams(statement, params);
			// get result
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				T modelObject = rowMapper.mapRow(resultSet);
				listObjectModel.add(modelObject);				
			}
			return listObjectModel;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				
				if(statement != null) {
					statement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}				
		}
	}

	@Override
	public void update(String sql, Object... params) {	
		Connection connection = null;
		PreparedStatement statement = null;		
		try {						
			connection = this.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);			
			this.setParams(statement, params);			
			statement.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		} finally {
			
			try {
				if(statement != null) {
					statement.close();
				}
				
				if(connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}				
		}			
	}

	@Override
	public Long insert(String sql, Object... params) {
		ResultSet resultSet = null;		
		Connection connection = null;
		PreparedStatement statement = null;	
		Long id = null;
		try {						
			connection = this.getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);			
			this.setParams(statement, params);			
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return null;
		} finally {			
			try {	
				
				if(resultSet != null) {
					statement.close();
				}
				if(statement != null) {
					statement.close();
				}				
				if(connection != null) {
					connection.close();
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			} 								
		}			
	}

}
