package com.htp.persistence;

import com.htp.domain.Book;

public interface BookDao extends BaseDao {

	public static final String FIND_ALL_BOOKS = "SELECT id,brief,author FROM book";
	public static final String CREATE_BOOK = "INSERT INTO book (`id`, `author`, `brief`) VALUES (?,?,? )";
	public static final String FIND_BOOK_BY_ID = "SELECT author,brief FROM book WHERE id=?";
	public static final String UPDATE_BOOK = "UPDATE book SET brief=?, author=? WHERE id = ?";
	public static final String DELETE_BOOK_BY_ID = "DELETE FROM book WHERE id =? ";
	public static final String FETCH_BOOK_BY_BRIEF = "SELECT id,author FROM book WHERE brief=?";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_AUTHOR = "author";
	public static final String COLUMN_BRIEF = "brief";

	Book fetchByBrief(String brief) throws BookDaoException;
}
