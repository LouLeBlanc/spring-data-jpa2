/**
 * @author Louis LeBlanc
 * For Homework Assignment 2
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */
package edu.brandeis.rseg105.data_jpa2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import edu.brandeis.rseg105.data_jpa2.domain.Book;

@Service("springJpaPublishingService")
@Transactional
public class PublishingServiceImpl implements PublishingService {

	private static Logger logger = LoggerFactory.getLogger(PublishingServiceImpl.class);

	@Autowired
	private PublishingRepository pubRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return Lists.newArrayList(pubRepo.findAll());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Book> findAllWithAuthorAndCategory() {
		List<Book> books = Lists.newArrayList(pubRepo.findAll());

		// Output here to avoid a LazyInstantiationException.
		books.forEach(b -> {
			logger.info(b.toString());
			logger.info(b.getCategory().toString());
			b.getAuthors().forEach(a -> logger.info(a.toString()));
			logger.info("-----------------");
		});

		return books;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Book findBookWithAuthorAndCategoryById(Long id) {
		Book book = pubRepo.findBookWithAuthorAndCategoryById(id);

		// Output here to avoid a LazyInstantiationException.
		logger.info(book.toString());
		logger.info(book.getCategory().toString());
		book.getAuthors().forEach(author -> { logger.info(author.toString()); });

		return book;
	}

	@Override
	public Book save(Book book) {
		logger.info("Inserting new book");
		pubRepo.save(book);
		logger.info("Book saved with id: " + book.getId());
		return book;
	}

	@Override
	public void delete(Book book) {
		pubRepo.delete(book);
		logger.info("Book deleted with id: " + book.getId());
	}

}
