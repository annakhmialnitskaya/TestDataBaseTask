package com.htp.service;

import com.htp.domain.Book;
import com.htp.domain.Catalog;

public interface BookService {

	Catalog viewCatalog() throws BookServiceException;

	void printBookByBrief(String brief) throws BookServiceException;

	void create(Book book) throws BookServiceException;

	void printBookById(int id) throws BookServiceException;

	void update(Book book) throws BookServiceException;

	void delete(int id) throws BookServiceException;

}
