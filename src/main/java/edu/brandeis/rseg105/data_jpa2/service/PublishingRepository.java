/**
 * @author Louis LeBlanc
 * For Homework Assignment 2
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

package edu.brandeis.rseg105.data_jpa2.service;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.brandeis.rseg105.data_jpa2.domain.Book;

public interface PublishingRepository extends CrudRepository<Book, Long> {

	Book findBookWithAuthorAndCategoryById(Long id);

	@SuppressWarnings("unchecked")
	Book save(Book book);
	
	void delete(Book book);
}

