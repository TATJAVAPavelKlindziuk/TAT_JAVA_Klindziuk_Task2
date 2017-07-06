package com.klindziuk.offlinelibrary.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Book implements Serializable {
	private static final long serialVersionUID = 3496552795406068119L;
	private int id;
	private String name;
	private int year;
	private String author;
	private boolean isAvailable;
	private boolean isDeprecated;
	private Timestamp additionDate;

	public Book() {
	}
	
	public Book(String name,String author, int year) {
		this.name = name;
		this.year = year;
		this.author = author;
		this.isAvailable = true;
		this.isDeprecated = false;
		this.additionDate = new Timestamp(System.currentTimeMillis());
	}
		
	public Book(int id, String name, String author, int year, boolean isAvailable, boolean isDeprecated,Timestamp additionDate ) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.author = author;
		this.isAvailable = isAvailable;
		this.isDeprecated = isDeprecated;
		this.additionDate = additionDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	
	public Timestamp getAdditionDate() {
		return additionDate;
	}

	public void setAdditionDate() {
		this.additionDate = new Timestamp(System.currentTimeMillis());
	}

	public boolean isDeprecated() {
		return isDeprecated;
	}

	public void setDeprecated(boolean isDeprecated) {
		this.isDeprecated = isDeprecated;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", year=" + year + ", author=" + author + ", isAvailable="
				+ isAvailable + ", isDeprecated=" + isDeprecated +"]";
	}
}
