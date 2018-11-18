/*
 * @author Louis LeBlanc
 * For Homework Assignment 2
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

package edu.brandeis.rseg105.data_jpa2.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Louis LeBlanc
 * Category component
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

	/**
	 * Implementing Serializable
	 */
	private static final long serialVersionUID = -3541702319392637955L;

	@Id
	@Column(name="id")
	private Long			id;

	@Column(name="name")
	private String			name;

	@OneToMany(mappedBy = "category",
			orphanRemoval = true)
	private Set<Book> books = new HashSet<>();

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public boolean addBook(Book book) {
		book.setCategory(this);
		return books.add(book);
	}

	public void removeBook(Book book) {
		books.remove(book);
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category -- Id: " + this.id + ", Name: " + this.name;
	}

}
