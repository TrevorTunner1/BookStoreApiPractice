package com.example.BookStoreApiPractice.mapper.impl;

import com.example.BookStoreApiPractice.domain.entites.dto.AuthorDto;
import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import com.example.BookStoreApiPractice.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> {

    @Autowired
    ModelMapper mapper;

    @Override
    public AuthorDto to(AuthorEntity author) {
        return mapper.map(author,AuthorDto.class);
    }

    @Override
    public AuthorEntity from(AuthorDto authorDto) {
        return mapper.map(authorDto,AuthorEntity.class);
    }
}
