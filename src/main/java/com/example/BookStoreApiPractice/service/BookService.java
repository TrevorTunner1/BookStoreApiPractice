package com.example.BookStoreApiPractice.service;

import com.example.BookStoreApiPractice.domain.entites.dto.BookDto;
import com.example.BookStoreApiPractice.domain.entites.entity.BookEntity;

import java.util.List;


public interface BookService {

    BookDto upsertBook(String isbn, BookDto book) throws Exception;

    List<BookEntity> findAll();
}
