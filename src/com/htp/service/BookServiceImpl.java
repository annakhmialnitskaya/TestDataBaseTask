package com.htp.service;

import java.util.List;

import com.htp.domain.Book;
import com.htp.domain.Catalog;
import com.htp.persistence.BookDao;
import com.htp.persistence.BookDaoException;
import com.htp.persistence.BookDaoImpl;

public class BookServiceImpl implements BookService {

	private BookDao dao = new BookDaoImpl();

	@Override
	public Catalog viewCatalog() throws BookServiceException {
		List<Book> books = null;
		try {
			books = dao.findAll();
		} catch (BookDaoException e) {
			throw new BookServiceException("Problem with DB: " + e.getMessage(), e);
		}
		return new Catalog(books);
	}

	@Override
	public void printBookByBrief(String brief) throws BookServiceException {
		try {
			System.out.println(dao.fetchByBrief(brief));
		} catch (BookDaoException e) {
			throw new BookServiceException("Problem with DB: " + e.getMessage(), e);
		}
	}

	@Override
	public void create(Book book) throws BookServiceException {
		try {
			int result = dao.create(book);
			if (result == 1) {
				System.out.println("New book was created!");
			}
		} catch (BookDaoException e) {
			throw new BookServiceException("Problem with DB: " + e.getMessage(), e);
		}
	}

	@Override
	public void printBookById(int id) throws BookServiceException {
		try {
			System.out.println(dao.findById(id));
		} catch (BookDaoException e) {
			throw new BookServiceException("Problem with DB: " + e.getMessage(), e);
		}
	}

	@Override
	public void update(Book book) throws BookServiceException {
		try {
			if (dao.update(book)) {
				System.out.println("Book was updated!");
			}
		} catch (BookDaoException e) {
			throw new BookServiceException("Problem with DB: " + e.getMessage(), e);
		}
	}

	@Override
	public void delete(int id) throws BookServiceException {
		try {
			if (dao.delete(id)) {
				System.out.println("Book was deleted!");
			}
		} catch (BookDaoException e) {
			throw new BookServiceException("Problem with DB: " + e.getMessage(), e);
		}
	}
}
