package com.karthi.spring.LibraryManagement;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
	String title;
    String isbn;
    boolean isAvailable = true;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(int id, String title, String isbn, boolean isAvailable, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.isAvailable = isAvailable;
		this.author = author;
	}


    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public Book() {
		super();
	}


	

	

}
