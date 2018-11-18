/**
 * @author Louis LeBlanc
 * For Homework Assignment 2
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

package edu.brandeis.rseg105.data_jpa2.service;

import java.util.List;

import edu.brandeis.rseg105.data_jpa2.domain.Book;

public interface PublishingService {
	
	List<Book> findAll();

	List<Book> findAllWithAuthorAndCategory();

	Book findBookWithAuthorAndCategoryById(Long id);

	Book save(Book book);
	
	void delete(Book book);

}
