CREATE DATABASE book_depository;

USE book_depository;

CREATE TABLE author(
                       id INT PRIMARY KEY,
                       name VARCHAR(150)
);

CREATE TABLE publisher(
                          id INT PRIMARY KEY,
                          name VARCHAR(150)
);

CREATE TABLE book (
                      id INT PRIMARY KEY,
                      name VARCHAR(250),
                      author INT,
                      publisher INT,
                      published_date DATE,
                      FOREIGN KEY (author) REFERENCES author(id),
                      FOREIGN KEY (publisher) REFERENCES publisher(id)
);

CREATE TABLE book_stock (
                            id INT PRIMARY KEY,
                            book_id INT,
                            stock_code VARCHAR(15),
                            is_available VARCHAR(1),
                            FOREIGN KEY (book_id) REFERENCES book(id)
);

CREATE TABLE customer (
                          id INT PRIMARY KEY,
                          name VARCHAR(250)
);

CREATE TABLE user (
                      id INT PRIMARY KEY,
                      name VARCHAR(250),
                      username VARCHAR(20),
                      email VARCHAR(100),
                      password TEXT
);

CREATE TABLE book_lending (
                              transaction_id VARCHAR(10) PRIMARY KEY,
                              customer_id INT,
                              transaction_date DATE,
                              return_date DATE,
                              appointed_user INT,
                              status VARCHAR(25),
                              FOREIGN KEY (customer_id) REFERENCES customer(id),
                              FOREIGN KEY (appointed_user) REFERENCES user(id)
);

CREATE TABLE book_lending_dtl (
                                  id int,
                                  transaction_id VARCHAR(10),
                                  book_id INT,
                                  book_stock_id INT,
                                  FOREIGN KEY (transaction_id) REFERENCES book_lending(transaction_id),
                                  FOREIGN KEY (book_id) REFERENCES book(id),
                                  FOREIGN KEY (book_stock_id) REFERENCES book_stock(id)
);