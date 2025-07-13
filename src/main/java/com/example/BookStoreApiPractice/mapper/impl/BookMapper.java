package com.example.BookStoreApiPractice.mapper.impl;

import com.example.BookStoreApiPractice.domain.entites.dto.BookDto;
import com.example.BookStoreApiPractice.domain.entites.entity.BookEntity;
import com.example.BookStoreApiPractice.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper implements Mapper<BookEntity, BookDto> {

    ModelMapper mapper;

    public BookMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BookDto to(BookEntity bookEntity) {
        return mapper.map(bookEntity,BookDto.class);
    }

    @Override
    public BookEntity from(BookDto bookDto) {
        return mapper.map(bookDto,BookEntity.class);
    }
}
