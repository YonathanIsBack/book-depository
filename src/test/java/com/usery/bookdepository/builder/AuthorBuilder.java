package com.usery.bookdepository.builder;

import com.github.javafaker.Faker;
import com.usery.bookdepository.author.AuthorRepository;
import com.usery.bookdepository.author.model.Author;
import com.usery.bookdepository.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorBuilder {
    @Autowired
    private AuthorRepository authorRepository;
    private final String name = Faker.instance().name().fullName();

    public Author build() {
        return new Author(name);
    }

    public Author create() {
        return authorRepository.save(this.build());
    }

    public void cleanUp() {
        this.authorRepository.deleteAll();
    }
}
