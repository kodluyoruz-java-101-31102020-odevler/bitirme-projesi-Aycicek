CREATE DATABASE bookread_db;

CREATE TABLE authors (
  id int NOT NULL AUTO_INCREMENT,
  author_full_name varchar(60) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY author_full_name (author_full_name)
); 
CREATE TABLE read_book (
  id int NOT NULL AUTO_INCREMENT,
  book_name varchar(60) NOT NULL,
  author_id int NOT NULL,
  publisher varchar(20) NOT NULL,
  number_of_page int NOT NULL,
  how_many_star int NOT NULL,
  PRIMARY KEY (id),
  KEY author_id (author_id),
  CONSTRAINT read_book_ibfk_1 FOREIGN KEY (author_id) REFERENCES authors (id) ON DELETE CASCADE,
  CONSTRAINT CHK_how_many_star CHECK ((how_many_star >= 0) and (how_many_star <= 5))
);

