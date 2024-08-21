package com.usery.bookdepository.book;

import com.usery.bookdepository.book.model.Book;
import com.usery.bookdepository.builder.BookBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName("Book Service Test")
public class BookServiceTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookBuilder bookBuilder;

    @Autowired
    private BookService bookService;

    @Nested
    @DisplayName("Get All Book")
    class GetAllBook {
        @DisplayName("Expect to return list of books")
        @Test
        void getAllBook_expectToReturnListOfBooks() {
            bookBuilder.create();
            bookBuilder.create();

            List<Book> actualResult = bookService.getAllBook();

            Assertions.assertEquals(2, actualResult.size());
        }
    }
}
