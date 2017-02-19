package com.htp.domain;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

	private List<Book> books;

	public Catalog() {
		books = new ArrayList<Book>();
	}

	public Catalog(List<Book> books) {
		if (books != null) {
			this.books = books;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (Book book : books) {
			builder.append("book: ");
			builder.append(book.toString());
			builder.append("\n");

		}
		return builder.toString();
	}

}
