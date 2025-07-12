package com.example.BookStoreApiPractice.service.impl;

import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import com.example.BookStoreApiPractice.repository.AuthorRepository;
import com.example.BookStoreApiPractice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository repository;

    @Override
    public AuthorEntity saveAuthor(AuthorEntity author) {
        return  repository.save(author);
    }
}
