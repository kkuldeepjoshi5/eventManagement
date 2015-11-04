package com.eventManagment.DAO.Impl;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.eventManagment.Entity.Event;
import com.eventManagment.Utility.Message;

public abstract class AbstractDAOImpl<E> {

	@Autowired
	private DataSource dataSource;
	
	private Connection connection;
	protected CallableStatement stmt;
	private ResultSet resultSet;
	private Message message=new Message();
	
	protected abstract CallableStatement createQuery(String string, E e);
	protected abstract E mapper(ResultSet resultSet);
	protected abstract void saveImage(E e) throws IOException;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		try {
			connection=dataSource.getConnection();
			System.out.println("connection"+getConnection());
		}catch(SQLException sqlException) {
			
		}
	}
	public Connection getConnection() {
		if(connection == null) {
			try {
				connection=dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}


	

	
	public Message insert(E e)  {
		
		message.setMessageString("fail to insert data...");
	
		stmt = createQuery("insert", e);
	
		try {
			if (stmt.executeUpdate() > 0) {
				/*try {
					saveImage(e);
				} catch (IOException e1) {
					
					message.setMessageString(e1.getMessage());
				}*/
				message.setMessageString("data successfully inserted!!!");
			}else{
				message.setMessageString("database error...");
			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			message.setMessageString(sqlException.getMessage());
		}

		return message;
	}

	

	
	public Message delete(Long eventId) {
		message.setMessageString("fail to delete data...");
		Event event=new Event();
		event.setEventId(eventId);
		stmt = createQuery("delete", (E) event);
		try {
			if (stmt.executeUpdate() > 0) {
				message.setMessageString("data successfully deleted!!!");
			}
		} catch (SQLException sqlException) {
			message.setMessageString(sqlException.getMessage());
		}
		return message;
	}

	public List<E> getAll() {

		List<E> list = null;
		stmt = createQuery("getAll", null);
		try {
			resultSet = stmt.executeQuery();

			list = new LinkedList<E>();
			while (resultSet.next()) {

				list.add(mapper(resultSet));

			}

		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return list;
	}



	public E getById(Long eventId) {
		Event event =new Event();
		E e=null;
		event.setEventId(eventId);
		stmt = createQuery("getById", (E) event);
		try {
			resultSet = stmt.executeQuery();
				e = mapper(resultSet);
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}

		return e;
	}

	public Message update(E e) {
		message.setMessageString("fail to update data...");
		stmt = createQuery("update", e);
		try {
			if (stmt.executeUpdate() > 0) {
				message.setMessageString("data successfully updated!!!");
			}
		} catch (SQLException sqlException) {
			message.setMessageString(sqlException.getMessage());
		}
		return message;
	}



}
