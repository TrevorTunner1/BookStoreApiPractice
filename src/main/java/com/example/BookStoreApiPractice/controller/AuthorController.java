package com.example.BookStoreApiPractice.controller;

import com.example.BookStoreApiPractice.domain.entites.dto.AuthorDto;
import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import com.example.BookStoreApiPractice.mapper.Mapper;
import com.example.BookStoreApiPractice.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/authors")
    public List<AuthorDto> findAllAuthors(){
        List<AuthorEntity> authors = authorService.findAll();
        return authors.stream()
                .map(authorMapper::to)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthor (@PathVariable("id") Long id){
        Optional<AuthorEntity> foundAuthor = authorService.findOne(id);
        return foundAuthor.map(author -> {
            AuthorDto getAuthor = authorMapper.to(author);
            return new ResponseEntity<>(getAuthor,HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
