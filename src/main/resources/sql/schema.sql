CREATE TABLE  category(
		id INT NOT NULL,
		name VARCHAR(100) NOT NULL,
		PRIMARY key ( ID )
	);

CREATE TABLE  book(
		id INT NOT NULL AUTO_INCREMENT,
		category_id INT NOT NULL,
		isbn VARCHAR(13) NOT NULL,
		title VARCHAR(500) NOT NULL,
		price DECIMAL(4,2) NOT NULL,
		version INT NOT NULL DEFAULT 0,
		UNIQUE uq_isbn_1 (isbn),
		PRIMARY KEY ( id ),
		CONSTRAINT FK_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id)
	);

CREATE TABLE  author(
		id INT NOT NULL AUTO_INCREMENT,
		first_name VARCHAR(60) NOT NULL,
		last_name VARCHAR(60) NOT NULL,
		description VARCHAR(1200) NOT NULL,
		version INT NOT NULL DEFAULT 0,
		UNIQUE UQ_AUTHOR_1 (first_name, last_name),
		PRIMARY KEY (id)
	);

CREATE TABLE author_book(
		author_id INT NOT NULL,
		book_id INT NOT NULL,
		PRIMARY KEY (book_id, author_id),
		CONSTRAINT FK_BOOK_AUTHOR_1 FOREIGN KEY (book_id) REFERENCES book (id) ON DELETE CASCADE,
		CONSTRAINT FK_BOOK_AUTHOR_2 FOREIGN KEY (author_id) REFERENCES author (id)
	);

