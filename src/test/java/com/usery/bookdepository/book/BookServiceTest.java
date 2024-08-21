package com.usery.bookdepository.book;

import com.usery.bookdepository.book.model.Book;
import com.usery.bookdepository.book.model.BookDTO;
import com.usery.bookdepository.builder.BookBuilder;
import org.junit.jupiter.api.*;
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

    @AfterEach
    public void cleanUp() {
        this.bookBuilder.cleanUp();
    }

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

        @DisplayName("Expect to return empty list when no books was found")
        @Test
        void getAllBook_expectToReturnEmptyList_whenNoBooksWasFound() {
            List<Book> actualResult = bookService.getAllBook();

            Assertions.assertEquals(0, actualResult.size());
        }
    }

    @Nested
    @DisplayName("Get Book By Id")
    class GetBookById {
        @DisplayName("Expect to return a book with correct id")
        @Test
        void getBookById_expectToReturnABookWithCorrectId() {
            Book expectedResult = bookBuilder.create();
            bookBuilder.create();

            Book actualResult = bookService.getBookById("1");

            Assertions.assertEquals(expectedResult.toString(), actualResult.toString());
        }

        @DisplayName("Expect to return null when no book was found")
        @Test
        void getBookById_expectToReturnEmptyList_whenNoBooksWasFound() {
            Book actualResult = bookService.getBookById("1");

            Assertions.assertNull(actualResult);
        }
    }
}
