package com.example.BookStoreApiPractice.service;

import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {
     AuthorEntity saveAuthor(AuthorEntity author);

     List<AuthorEntity> findAll();

     Optional<AuthorEntity> findOne(Long id);
}
