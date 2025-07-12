package com.example.BookStoreApiPractice.service;

import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
     AuthorEntity saveAuthor(AuthorEntity author);
}
