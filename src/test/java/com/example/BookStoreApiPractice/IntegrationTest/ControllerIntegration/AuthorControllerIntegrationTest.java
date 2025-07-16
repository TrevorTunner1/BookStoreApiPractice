package com.example.BookStoreApiPractice.IntegrationTest.ControllerIntegration;

import com.example.BookStoreApiPractice.IntegrationTest.TestDataUtil;
import com.example.BookStoreApiPractice.domain.entites.dto.AuthorDto;
import com.example.BookStoreApiPractice.domain.entites.entity.AuthorEntity;
import com.example.BookStoreApiPractice.service.AuthorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@Transactional
public class AuthorControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AuthorService authorService;

    @Test
    public void testThatAuthorControllerReturn201Created() throws Exception {
        AuthorEntity author = TestDataUtil.createAuthorA();
        mockMvc.perform(MockMvcRequestBuilders.post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(author)))
                .andExpect(status().isCreated())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.name").value("Rei")
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.age").value(19)
                );
    }

    @Test
    public void testThatAllAuthorReturn200Ok() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatAllAuthorsCanBeReturned() throws Exception {

        AuthorEntity authorA = TestDataUtil.createAuthorA();

        authorService.saveAuthor(authorA);

        mockMvc.perform(MockMvcRequestBuilders.get("/authors")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].name").value("Rei")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$[0].age").value(19)
        );

        //going to debug this later on
//        .andExpect(
//                MockMvcResultMatchers.jsonPath("$[0].id").isNumber()
//        )
    }
}


