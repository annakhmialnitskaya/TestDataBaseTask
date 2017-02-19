package com.htp.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htp.domain.Book;

public class BookDaoImpl implements BookDao {

	@Override
	public int create(Book book) throws BookDaoException {
		int countModifiedRows = 0;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, LOGIN, PASS);
			PreparedStatement statement = conn.prepareStatement(CREATE_BOOK);
			statement.setInt(1, book.getId());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getBrief());
			countModifiedRows = statement.executeUpdate();
		} catch (SQLException e) {
			throw new BookDaoException("Exception in Dao layer!", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new BookDaoException("Exception in Dao layer!", e);
				}
			}
		}
		return countModifiedRows;
	}

	@Override
	public List<Book> findAll() throws BookDaoException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Book> books = null;

		try {
			conn = DriverManager.getConnection(URL, LOGIN, PASS);
			st = conn.createStatement();
			rs = st.executeQuery(FIND_ALL_BOOKS);
			books = new ArrayList<Book>();
			while (rs.next()) {
				int id = rs.getInt(COLUMN_ID);
				String author = rs.getString(COLUMN_AUTHOR);
				String brief = rs.getString(COLUMN_BRIEF);
				Book book = new Book(id, author, brief);
				books.add(book);
			}
		} catch (SQLException e) {
			throw new BookDaoException("Exception in Dao layer!", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new BookDaoException("Exception in Dao layer!", e);
				}
			}
		}
		return books;
	}

	@Override
	public Book findById(int id) throws BookDaoException {
		Book book = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, LOGIN, PASS);
			PreparedStatement statement = conn.prepareStatement(FIND_BOOK_BY_ID);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String brief = rs.getString(1);
				String author = rs.getString(2);
				book = new Book(id, author, brief);
			}
		} catch (SQLException e) {
			throw new BookDaoException("Exception with DB!", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new BookDaoException("Exception in Dao layer!", e);
				}
			}
		}
		return book;
	}

	@Override
	public boolean update(Book book) throws BookDaoException {
		int countModifiedRows;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, LOGIN, PASS);
			PreparedStatement statement = conn.prepareStatement(UPDATE_BOOK);			
			statement.setString(1, book.getBrief());
			statement.setString(2, book.getAuthor());
			statement.setInt(3, book.getId());
			countModifiedRows = statement.executeUpdate();
		} catch (SQLException e) {
			throw new BookDaoException("Exception with DB!", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new BookDaoException("Exception in Dao layer!", e);
				}
			}
		}
		return countModifiedRows == 1;
	}

	@Override
	public boolean delete(int id) throws BookDaoException {
		int countModifiedRows;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, LOGIN, PASS);
			PreparedStatement statement = conn.prepareStatement(DELETE_BOOK_BY_ID);
			statement.setInt(1, id);
			countModifiedRows = statement.executeUpdate();
		} catch (SQLException e) {
			throw new BookDaoException("Exception with DB!", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new BookDaoException("Exception in Dao layer!", e);
				}
			}
		}
		return countModifiedRows == 1;
	}

	@Override
	public Book fetchByBrief(String brief) throws BookDaoException {
		Book book = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, LOGIN, PASS);
			PreparedStatement statement = conn.prepareStatement(FETCH_BOOK_BY_BRIEF);
			statement.setString(1, brief);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(COLUMN_ID);
				String author = rs.getString(COLUMN_AUTHOR);
				book = new Book(id, author, brief);
			}
		} catch (SQLException e) {
			throw new BookDaoException("Exception with DB!", e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new BookDaoException("Exception in Dao layer!", e);
				}
			}
		}
		return book;
	}
}
