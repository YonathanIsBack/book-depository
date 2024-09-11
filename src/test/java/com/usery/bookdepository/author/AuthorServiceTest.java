package com.usery.bookdepository.author;

import com.usery.bookdepository.author.model.Author;
import com.usery.bookdepository.builder.AuthorBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DisplayName("Book Service Test")
public class AuthorServiceTest {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorBuilder authorBuilder;

    @Autowired
    private AuthorService authorService;

    @AfterEach
    public void cleanUp() {
        this.authorBuilder.cleanUp();
    }

    @Nested
    @DisplayName("Get All Author")
    class GetAllAuthor {
        @Test
        @DisplayName("expect to return list of author")
        public void getAllAuthor_expectToReturnListOfAuthor() {
            Author firstAuthor = authorBuilder.create();
            Author secondAuthor = authorBuilder.create();
            List<Author> expectedAuthors = Arrays.asList(firstAuthor, secondAuthor);

            List<Author> actualAuthors = authorService.getAllAuthor();

            assertEquals(expectedAuthors, actualAuthors);
        }
    }

}
