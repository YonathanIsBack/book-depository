package com.usery.bookdepository.builder;

import com.github.javafaker.Faker;
import com.usery.bookdepository.book.BookRepository;
import com.usery.bookdepository.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookBuilder {
    @Autowired
    private BookRepository bookRepository;
    private final String bookName = Faker.instance().lorem().characters(25);
    private final String publishYear = Faker.instance().number().digit();
    private final String author = Faker.instance().name().firstName();

    public Book build() {
        return new Book(bookName, publishYear, author);
    }

    public Book create() {
        return bookRepository.save(this.build());
    }

    public void cleanUp() {
        this.bookRepository.deleteAll();
    }
}
