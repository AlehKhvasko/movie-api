package com.alehkhvasko.movieapi;

import com.alehkhvasko.movieapi.controllers.MovieController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MovieApi {
    @Autowired
    public MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertNotNull(mockMvc);
    }

    @Test
    public void testShowMovieForm() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/?count=123");

        mockMvc.perform(request)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("form"))
                .andExpect(model().attributeExists("movies"));
    }

    @Test
    public void testSuccessfulSubmission() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/handleSubmit")
                .param("name", "Avatar")
                .param("description", "Fantasy");

        mockMvc.perform(request)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/movies"));
    }

    @Test
    public void testUnsuccessfulSubmission() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/handleSubmit")
                .param("name", " ")
                .param("description", " ");

        mockMvc.perform(request)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("form"))
                .andExpect(model().attributeExists("movies"));
    }

    @Test
    public void testGetMovies() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/movies");

        mockMvc.perform(request)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("movie"))
                .andExpect(model().attributeExists("movies"));
    }

}
