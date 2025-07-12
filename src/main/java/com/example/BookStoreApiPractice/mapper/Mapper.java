package com.example.BookStoreApiPractice.mapper;

public interface Mapper<A,B>{

    B to(A a);

    A from(B b);
}
