package com.example.BookStoreApiPractice.IntegrationTest;

import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import com.example.BookStoreApiPractice.domain.entites.entity.BookEntity;
import com.example.BookStoreApiPractice.repository.AuthorRepository;
import com.example.BookStoreApiPractice.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class BookEntityIntegrationTest {

    @Autowired
    private BookRepository underTest;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testThatBooksCanBeCreatedAndRecalled() {
        AuthorEntity author = authorRepository.save(TestDataUtil.createAuthorA());
        BookEntity book = TestDataUtil.createBookA(author);
        underTest.save(book);

        Optional<BookEntity> result = underTest.findById(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatAllBooksCanBeCreatedAndRecalled() {
        AuthorEntity authorA = authorRepository.save(TestDataUtil.createAuthorA());
        BookEntity bookA = TestDataUtil.createBookA(authorA);
        underTest.save(bookA);

        AuthorEntity authorB = authorRepository.save(TestDataUtil.createAuthorB());
        BookEntity bookB = TestDataUtil.createBookB(authorB);
        underTest.save(bookB);

        Iterable<BookEntity> result = underTest.findAll();
        assertThat(result).hasSize(2).containsExactly(bookA, bookB);
    }

    @Test
    public void testThatBooksCanBeUpdated(){
        AuthorEntity authorA = authorRepository.save(TestDataUtil.createAuthorA());
        BookEntity bookA = TestDataUtil.createBookA(authorA);
        bookA.setBookName("Updated");
        underTest.save(bookA);

        Optional<BookEntity> result = underTest.findById(bookA.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(bookA);
    }

    @Test
    public void testThatBooksCanBeDeleted(){
        AuthorEntity authorA = authorRepository.save(TestDataUtil.createAuthorA());
        BookEntity bookA = TestDataUtil.createBookA(authorA);

        underTest.save(bookA);
        underTest.deleteById(bookA.getIsbn());

        Optional<BookEntity> result =underTest.findById(bookA.getIsbn());
        assertThat(result).isEmpty();
    }
}

