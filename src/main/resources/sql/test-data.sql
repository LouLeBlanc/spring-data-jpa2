SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table author_book;
TRUNCATE table author;
TRUNCATE table book;
TRUNCATE table category;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO category (id, name) VALUES (1, 'Classics');
INSERT INTO category (id, name) VALUES (2, 'Novels');
INSERT INTO category (id, name) VALUES (3, 'Java');
INSERT INTO category (id, name) VALUES (4, 'Education');


INSERT INTO book (category_id, isbn, title, price) VALUES (3, '9781484228074', 'Pro Spring 5', 49.99);
INSERT INTO book (category_id, isbn, title, price) VALUES (1, '9781402712173', 'The Adventures of Sherlock Holmes', 5.95);
INSERT INTO book (category_id, isbn, title, price) VALUES (1, '9781402726651', 'Oliver Twist', 4.95);
INSERT INTO book (category_id, isbn, title, price) VALUES (2, '9780439023528', 'The Hunger Games', 8.99);
INSERT INTO book (category_id, isbn, title, price) VALUES (2, '9780439023498', 'Catching Fire', 17.99);
INSERT INTO book (category_id, isbn, title, price) VALUES (4, '9780979107269', 'Life of Fred: Cats', 12.99);
INSERT INTO book (category_id, isbn, title, price) VALUES (4, '9780979107276', 'Life of Fred: Dogs', 12.99);

# INSERT INTO book (category_id, isbn, title, price) VALUES (3, '9780134685997', 'Effective Java', 54.99);


INSERT INTO author (first_name, last_name, description) VALUES ('Iuliana', 'Cosmina', "Software architect, Bearing Point Software");
INSERT INTO author (first_name, last_name, description) VALUES ('Rob', 'Harrop', "Software consultant");
INSERT INTO author (first_name, last_name, description) VALUES ('Chris', 'Schaefer', "Principle software developer, Pivotal Software");
INSERT INTO author (first_name, last_name, description) VALUES ('Clarence', 'Ho', "Senior Java architect, SkywideSoft Technology Limited");
INSERT INTO author (first_name, last_name, description) VALUES ('Sir Arthur Conan', 'Doyle', "19th century British writer");
INSERT INTO author (first_name, last_name, description) VALUES ('Charles', 'Dickens', "Popular Victorian author");
INSERT INTO author (first_name, last_name, description) VALUES ('Suzanne', 'Collins', "Popular author of young adult fiction");
INSERT INTO author (first_name, last_name, description) VALUES ('Stanley F.', 'Schmidt', "Math professor, educational writer");

# INSERT INTO author (first_name, last_name, description) VALUES ('Joshua', 'Bloch', "Professor, Carnegie Mellon University");


INSERT INTO author_book (author_id, book_id) VALUES (1, 1);
INSERT INTO author_book (author_id, book_id) VALUES (2, 1);
INSERT INTO author_book (author_id, book_id) VALUES (3, 1);
INSERT INTO author_book (author_id, book_id) VALUES (4, 1);
INSERT INTO author_book (author_id, book_id) VALUES (5, 2);
INSERT INTO author_book (author_id, book_id) VALUES (6, 3);
INSERT INTO author_book (author_id, book_id) VALUES (7, 4);
INSERT INTO author_book (author_id, book_id) VALUES (7, 5);
INSERT INTO author_book (author_id, book_id) VALUES (8, 6);
INSERT INTO author_book (author_id, book_id) VALUES (8, 7);

# INSERT INTO author_book (author_id, book_id) VALUES (9, 8);


