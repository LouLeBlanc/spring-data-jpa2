/**
 * @author Louis LeBlanc
 * For Homework Assignment 2
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

package edu.brandeis.rseg105.data_jpa2.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.brandeis.rseg105.data_jpa2.domain.Book;
import edu.brandeis.rseg105.data_jpa2.service.PublishingService;

/**
 * @author Louis LeBlanc
 *
 *	Find all books - not authors or categories.
 */
public class FindAllBooks {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooks.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-annotation.xml");
		ctx.refresh();

		PublishingService publishingService = ctx.getBean(PublishingService.class);

		List<Book> books = publishingService.findAll();

		logger.info("================================");
		logger.info("Listing books without authors and category names: ");
		listBooks(books);
		logger.info("================================");

		ctx.close();
	}

	public static void listBooks(List<Book> books) {
		books.forEach(book -> {
			logger.info(book.toString());
				logger.info("-----------------");
			});
	}

}
