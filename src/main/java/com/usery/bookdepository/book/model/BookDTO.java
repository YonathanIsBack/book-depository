package com.usery.bookdepository.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String name;
    private String publishYear;
    private String author;

    public BookDTO(Book book) {
        this.name = book.getName();
        this.publishYear = book.getPublishYear();
        this.author = book.getAuthor();
    }
    public Book createBook() {
        return new Book(name, publishYear, author);
    }
}
