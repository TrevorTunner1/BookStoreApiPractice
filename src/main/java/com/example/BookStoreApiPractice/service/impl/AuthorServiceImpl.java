package com.example.BookStoreApiPractice.service.impl;

import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import com.example.BookStoreApiPractice.repository.AuthorRepository;
import com.example.BookStoreApiPractice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository repository;

    @Override
    public AuthorEntity saveAuthor(AuthorEntity author) {
        return  repository.save(author);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AuthorEntity> findOne(Long id) {
        return repository.findById(id);
    }


}
