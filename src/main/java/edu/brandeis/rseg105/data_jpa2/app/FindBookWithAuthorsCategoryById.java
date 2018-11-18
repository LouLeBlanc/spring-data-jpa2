/**
 * @author Louis LeBlanc
 * For Homework Assignment 2
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

package edu.brandeis.rseg105.data_jpa2.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.brandeis.rseg105.data_jpa2.service.PublishingService;

/**
 * @author Louis LeBlanc
 *
 * Find a book with authors and category by Book ID.
 */
public class FindBookWithAuthorsCategoryById {
	private static Logger logger = LoggerFactory.getLogger(FindBookWithAuthorsCategoryById.class);

	public static void main(String[] args) {
		Long bookID = 1L;

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-annotation.xml");
		ctx.refresh();

		PublishingService publishingService = ctx.getBean(PublishingService.class);

		logger.info("================================");
		logger.info("Listing book with authors and category by book's ID: ");

		// We'll display from the service layer to avoid a
		// LazyInstantiationException without having to declare "FetchType.Eager
		publishingService.findBookWithAuthorAndCategoryById(bookID);

		logger.info("================================");

		ctx.close();
	}
}
