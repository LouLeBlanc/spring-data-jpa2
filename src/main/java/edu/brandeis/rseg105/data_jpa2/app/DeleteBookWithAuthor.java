/**
 * @author Louis LeBlanc
 * For Homework Assignment 2
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

package edu.brandeis.rseg105.data_jpa2.app;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.brandeis.rseg105.data_jpa2.domain.Author;
import edu.brandeis.rseg105.data_jpa2.domain.Book;
import edu.brandeis.rseg105.data_jpa2.service.PublishingService;

/**
 *
 * @author Louis LeBlanc
 *
 * Delete a record from the database
 */
public class DeleteBookWithAuthor {
	private static Logger logger = LoggerFactory.getLogger(DeleteBookWithAuthor.class);

	public static void main(String[] args) {
		/*
		 * This ID will only be valid the first time this application is run.
		 * The CreateBookWithAuthor app can be run again, but it will increment
		 * the ID given to the new record.
		 *
		 */
		Long bookId = 8L;

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-annotation.xml");
		ctx.refresh();

		PublishingService publishingService = ctx.getBean(PublishingService.class);

		Book deleteBook = publishingService.findBookWithAuthorAndCategoryById(bookId);
		logger.info("================================");

		if (deleteBook != null) {
			logger.info("Removing book:");
			logger.info(deleteBook.toString());
			logger.info(deleteBook.getCategory().toString());
			Set<Author> authors = deleteBook.getAuthors();
			authors.forEach(author -> { logger.info(author.toString()); });

			publishingService.delete(deleteBook);
		}

		logger.info("================================");
		logger.info("Listing all books with authors and category names:");
		// List all books with authors and category.
		// We're displaying from the service layer to avoid a
		// LazyInstantiationException without having to declare "FetchType.Eager
		publishingService.findAllWithAuthorAndCategory();
		logger.info("================================");

		ctx.close();
	}
}
