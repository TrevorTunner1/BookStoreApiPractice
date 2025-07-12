package com.example.BookStoreApiPractice.repository;

import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {
}
