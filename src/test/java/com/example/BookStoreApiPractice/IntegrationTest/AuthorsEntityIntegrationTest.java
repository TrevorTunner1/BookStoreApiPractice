package com.example.BookStoreApiPractice.IntegrationTest;

import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import com.example.BookStoreApiPractice.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class AuthorsEntityIntegrationTest {
    
    @Autowired
    private AuthorRepository underTest;

    
    @Test
    public void testThatAuthorsCanBeCalledAndRecalled(){
        AuthorEntity author = TestDataUtil.createAuthorA();
        underTest.save(author);
        Optional<AuthorEntity> result = underTest.findById(author.getId());
         assertThat(result).isPresent();
         assertThat(result.get()).isEqualTo(author);
    }

   @Test
    public void testThatAllAuthorsCanBeSaveandCalled(){
        AuthorEntity authorA = TestDataUtil.createAuthorA();
        underTest.save(authorA);
        AuthorEntity authorB = TestDataUtil.createAuthorB();
        underTest.save(authorB);
        Iterable<AuthorEntity> result = underTest.findAll();
        Assertions.assertThat(result).hasSize(2).containsExactly(authorA,authorB);
    }

    @Test
    public void testThatAllAuthorsCanBeUpdated(){
        AuthorEntity authorA = TestDataUtil.createAuthorA();
        authorA.setName("will");
        underTest.save(authorA);
        Optional<AuthorEntity> result = underTest.findById(authorA.getId());
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get()).isEqualTo(authorA);
    }

    @Test
    public void testThatAuthorsCanBeDeleted(){
        AuthorEntity authorA = TestDataUtil.createAuthorA();
        underTest.save(authorA);
        underTest.deleteById(authorA.getId());
        Optional<AuthorEntity> result = underTest.findById(authorA.getId());
        Assertions.assertThat(result).isEmpty();
    }
}
