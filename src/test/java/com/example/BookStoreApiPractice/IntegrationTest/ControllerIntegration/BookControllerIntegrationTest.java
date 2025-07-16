package com.example.BookStoreApiPractice.IntegrationTest.ControllerIntegration;

import com.example.BookStoreApiPractice.IntegrationTest.TestDataUtil;
import com.example.BookStoreApiPractice.domain.entites.dto.BookDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
public class BookControllerIntegrationTest {

    @Autowired
    private  MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;


    @Test
    public void testThatBooksCanReturn201Created() throws Exception {
        BookDto bookDto = TestDataUtil.createBookDtoA();
        String  createBookJson = mapper.writeValueAsString(bookDto);
        mockMvc.perform(MockMvcRequestBuilders.put("/books/"+ bookDto.getIsbn())
                .contentType(MediaType.APPLICATION_JSON)
                .content(createBookJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testThatBooksCanBePutInApi() throws Exception {
        BookDto bookDto = TestDataUtil.createBookDtoA();
        String  createBookJson = mapper.writeValueAsString(bookDto);
        mockMvc.perform(MockMvcRequestBuilders.put("/books/"+ bookDto.getIsbn())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createBookJson))
                .andExpect(status().isCreated())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.isbn").value("105-min-rei")
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.bookName").value("Living life with an akagami")
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.yearPublished").value("2025")
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.authorId").value(1L)
                );
    }

    @Test
    public void testThatListOfBooksCanReturn200ok() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


    @Test
    public void testThatListOfBBooksCanBeReturned() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$[0].isbn").value("105-222-rei")
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$[0].bookName").value("The summer rei died")
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$[0].yearPublished").value("2004")
                )
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$[0].authorId").value(1L)
                );
    }

}



