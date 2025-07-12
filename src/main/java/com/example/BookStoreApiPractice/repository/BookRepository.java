package com.example.BookStoreApiPractice.repository;

import com.example.BookStoreApiPractice.domain.entites.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<BookEntity,String> {

}
