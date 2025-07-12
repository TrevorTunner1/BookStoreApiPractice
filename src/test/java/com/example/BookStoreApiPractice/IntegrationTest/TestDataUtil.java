package com.example.BookStoreApiPractice.IntegrationTest;

import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import com.example.BookStoreApiPractice.domain.entites.entity.BookEntity;

public final class TestDataUtil {
        public static AuthorEntity createAuthorA(){
            return  AuthorEntity.builder()
                    .name("Rei")
                    .age(19)
                    .build();
        }

        public static AuthorEntity createAuthorB(){
            return AuthorEntity.builder()
                    .name("Hashirama")
                    .age(22)
                    .build();
        }

        //Test classes for the books ->

        public static BookEntity createBookA(AuthorEntity author){
            return  BookEntity.builder()
                    .isbn("105-222-rei")
                    .bookName("The summer rei died")
                    .yearPublished("2004")
                    .author(author)
                    .build();
        }

    public static BookEntity createBookB(AuthorEntity author){
        return  BookEntity.builder()
                .isbn("105-min-rei")
                .bookName("Living life with an akagami")
                .yearPublished("2025")
                .author(author)
                .build();
    }
}
