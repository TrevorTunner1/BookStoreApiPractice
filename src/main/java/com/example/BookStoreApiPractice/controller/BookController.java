package com.example.BookStoreApiPractice.controller;

import com.example.BookStoreApiPractice.domain.entites.dto.BookDto;
import com.example.BookStoreApiPractice.domain.entites.entity.BookEntity;
import com.example.BookStoreApiPractice.mapper.Mapper;
import com.example.BookStoreApiPractice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    BookService bookService;

    Mapper<BookEntity,BookDto> mapper;

    public BookController(BookService bookService, Mapper<BookEntity, BookDto> mapper) {
        this.bookService = bookService;
        this.mapper = mapper;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook (@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto) throws Exception {
        BookEntity book = mapper.from(bookDto);
        BookDto savedBook = bookService.upsertBook(isbn, bookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }
}
