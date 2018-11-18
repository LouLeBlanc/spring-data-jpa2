/**
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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="book")
@SqlResultSetMapping(
		name="bookResult",
		entities=@EntityResult(entityClass=Book.class)
)
/**
 *
 * Book Entity Class.
 * The id and version fields are defined by the superclass.
 *
 */
public class Book implements Serializable {

	/**
	 * Implementing Serializable
	 */
	private static final long serialVersionUID = -1606836550546687511L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name="isbn")
	private String isbn;

	@Column(name="title")
	private String title;

	@Column(name="price")
	private float  price;

	@Version
	@Column(name = "version")
	private int version;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "author_book",
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors = new HashSet<>();

	/**
	 * @return the Book ID
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @return the authors
	 */
	public Set<Author> getAuthors() {
		return authors;
	}

	/**
	 * @return the category name
	 */
	public String getCategoryName() {
		return category.getName();
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	/**
	 * @param author
	 * @return true / false from Set.add() method.
	 */
	public boolean addAuthor(Author author) {
		return authors.add(author);
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Book - Id: " + this.id +
				", Category Id: " + this.category.getId() +
				", ISBN: " + this.isbn +
				", Title: " + this.title +
				", Price: " + this.price);
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Book book = (Book) o;
		if (isbn != null ? !isbn.equals(book.isbn) : book.title != null )
			return false;
		return title != null ? !title.equals(book.title) : book.title != null;
	}

	@Override public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
		return result;
	}

}
