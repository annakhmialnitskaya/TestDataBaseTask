package com.htp.domain;

public class Book extends Entity {

	private static final long serialVersionUID = 1649246390188481897L;

	private String author;
	private String brief;

	public Book(int id, String author, String brief) {
		super(id);
		this.author = author;
		this.brief = brief;
	}

	public Book() {
		super();

	}

	public Book(int id) {
		super(id);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return super.toString() + "Book [author=" + author + ", brief=" + brief + "]";
	}
}
