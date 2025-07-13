package com.example.BookStoreApiPractice.service.impl;

import com.example.BookStoreApiPractice.domain.entites.dto.AuthorDto;
import com.example.BookStoreApiPractice.domain.entites.dto.BookDto;
import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import com.example.BookStoreApiPractice.domain.entites.entity.BookEntity;
import com.example.BookStoreApiPractice.exception.ResourceNotFoundException;
import com.example.BookStoreApiPractice.mapper.Mapper;
import com.example.BookStoreApiPractice.repository.AuthorRepository;
import com.example.BookStoreApiPractice.repository.BookRepository;
import com.example.BookStoreApiPractice.service.BookService;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class  BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    private Mapper<BookEntity, BookDto> mapper;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, Mapper<BookEntity, BookDto> mapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }

    @Override
    public BookDto upsertBook(String isbn, BookDto dto) throws ResourceNotFoundException {
        BookEntity book = bookRepository.findById(isbn).orElse(null);

        if (book == null) {
            book = new BookEntity();
            book.setIsbn(isbn); // ISBN comes from path
        }

        book.setBookName(dto.getBookName());
        book.setYearPublished(dto.getYearPublished());

        AuthorEntity author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with ID: " + dto.getAuthorId()));

        book.setAuthor(author);

        BookEntity saved = bookRepository.save(book);
        return mapper.to(saved);
    }

}
