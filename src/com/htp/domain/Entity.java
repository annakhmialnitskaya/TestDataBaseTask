package com.htp.domain;

import java.io.Serializable;

public abstract class Entity implements Serializable {

	private static final long serialVersionUID = 3982293996691629959L;

	private int id;

	public Entity(int id) {
		super();
		this.id = id;
	}

	public Entity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + "]";
	}
}
