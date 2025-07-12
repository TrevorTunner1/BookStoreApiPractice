package com.example.BookStoreApiPractice.controller;

import com.example.BookStoreApiPractice.domain.entites.dto.AuthorDto;
import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import com.example.BookStoreApiPractice.mapper.Mapper;
import com.example.BookStoreApiPractice.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

     Mapper<AuthorEntity,AuthorDto> authorMapper;

     AuthorService authorService;

    public AuthorController(Mapper<AuthorEntity, AuthorDto> authorMapper, AuthorService authorService) {
        this.authorMapper = authorMapper;
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    public ResponseEntity<AuthorDto> createAuthors(@RequestBody AuthorDto authorDto) {
        AuthorEntity author = authorMapper.from(authorDto);
        AuthorEntity savedAuthor = authorService.saveAuthor(author);
        AuthorDto response = authorMapper.to(savedAuthor);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
