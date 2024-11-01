package com.karthi.spring.LibraryManagement;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    @ManyToOne
    Book book;

    @ManyToOne
    User user;

     LocalDateTime loanDate;
     LocalDateTime dueDate;
	public Loan(int id, Book book, User user, LocalDateTime loanDate, LocalDateTime dueDate) {
		super();
		this.id = id;
		this.book = book;
		this.user = user;
		this.loanDate = loanDate;
		this.dueDate = dueDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDateTime getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(LocalDateTime loanDate) {
		this.loanDate = loanDate;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}
	public Loan() {
		super();
	}
}
