package com.usery.bookdepository.book;

import com.usery.bookdepository.book.model.Book;
import com.usery.bookdepository.book.model.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBook() {
        return this.bookRepository.findAll();
    }

    public BookDTO getBookById(String id) {
        return new BookDTO(this.bookRepository.findBookById(Long.parseLong(id)));
    }
}
