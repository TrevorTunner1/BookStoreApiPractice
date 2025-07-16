package com.example.BookStoreApiPractice.controller;

import com.example.BookStoreApiPractice.domain.entites.dto.BookDto;
import com.example.BookStoreApiPractice.domain.entites.entity.BookEntity;
import com.example.BookStoreApiPractice.mapper.Mapper;
import com.example.BookStoreApiPractice.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

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

    @GetMapping("/books")
    public List<BookDto> findAllBooks(){
        List<BookEntity> book = bookService.findAll();
        return book.stream()
                .map(mapper::to)
                .collect(Collectors.toList());
    }
}
