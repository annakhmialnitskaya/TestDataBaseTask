package com.htp.persistence;

import java.util.List;

import com.htp.domain.Book;

public interface BaseDao {

	public static final String URL = "jdbc:mysql://localhost/htp";
	public static final String LOGIN = "anna";
	public static final String PASS = "Anna2017-";

	int create(Book book) throws BookDaoException;

	List<Book> findAll() throws BookDaoException;

	Book findById(int id) throws BookDaoException;

	boolean update(Book book) throws BookDaoException;

	boolean delete(int id) throws BookDaoException;

}
