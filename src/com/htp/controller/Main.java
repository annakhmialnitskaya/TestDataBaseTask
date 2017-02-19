package com.htp.controller;

import com.htp.domain.Book;
import com.htp.domain.Catalog;
import com.htp.service.BookService;
import com.htp.service.BookServiceException;
import com.htp.service.BookServiceImpl;

public class Main {

	public static void main(String[] args) {
		chooseItem(6);
		chooseItem(1);
		
	}

	private static BookService service = new BookServiceImpl();

	private static void chooseItem(int item) {
		Book book;
		switch (item) {
		case 1:
			Catalog catalog = new Catalog();
			try {
				Catalog newCatalog = service.viewCatalog();
				catalog = newCatalog;
			} catch (BookServiceException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(catalog);
			break;
		case 2:
			book = new Book(21, "А.С.Пушкин", "Руслан и Людмила");
			try {
				service.create(book);
			} catch (BookServiceException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			try {
				service.delete(21);
			} catch (BookServiceException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			try {
				service.printBookByBrief("Тень горы");
			} catch (BookServiceException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			try {
				service.printBookById(5);
			} catch (BookServiceException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 6:
			book = new Book(20, "Г.Д.Робертс", "Тень горы 2");
			try {
				service.update(book);
			} catch (BookServiceException e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			System.out.println("Incorrect parameter!");
		}
	}
}
