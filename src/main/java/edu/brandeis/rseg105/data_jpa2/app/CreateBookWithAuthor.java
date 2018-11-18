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

import edu.brandeis.rseg105.data_jpa2.domain.Author;
import edu.brandeis.rseg105.data_jpa2.domain.Book;
import edu.brandeis.rseg105.data_jpa2.domain.Category;
import edu.brandeis.rseg105.data_jpa2.service.PublishingService;

/**
 * 
 * @author Louis LeBlanc
 *
 * Create a new Book with Author.
 *  Link to existing Category and save to the database.
 */
public class CreateBookWithAuthor {
	private static Logger logger = LoggerFactory.getLogger(CreateBookWithAuthor.class);

	public static void main(String[] args) {
		Author newAuthor = new Author();
		newAuthor.setFirstName("Joshua");
		newAuthor.setLastName("Bloch");
		newAuthor.setDescription("Professor, Carnegie Mellon University");

		Category existingCategory = new Category();
		existingCategory.setId(3L);
		existingCategory.setName("Java");

		Book newBook = new Book();
		newBook.setIsbn("9780134685997");
		newBook.setTitle("Effective Java");
		newBook.setPrice((float) 54.99);
		newBook.addAuthor(newAuthor);
		newBook.setCategory(existingCategory);

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-annotation.xml");
		ctx.refresh();

		PublishingService publishingService = ctx.getBean(PublishingService.class);

		logger.info("================================");
		logger.info("Adding book " + newBook.getTitle() + ":");

		publishingService.save(newBook);
		// List all books with authors and category.
		// We're displaying from the service layer to avoid a
		// LazyInstantiationException without having to declare "FetchType.Eager
		logger.info("================================");
		logger.info("Listing all books with authors and category names:");
		publishingService.findAllWithAuthorAndCategory();
		logger.info("================================");

		ctx.close();
	}
}
