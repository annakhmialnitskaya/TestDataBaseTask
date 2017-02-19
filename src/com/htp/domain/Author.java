package com.htp.domain;

import java.util.Date;

public class Author extends Entity {

	private static final long serialVersionUID = -7578114899756713238L;

	private String name;
	private Date date;

	public Author(int id, String name, Date date) {
		super(id);
		this.name = name;
		this.date = date;
	}

	public Author() {
		super();

	}

	public Author(int id) {
		super(id);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
