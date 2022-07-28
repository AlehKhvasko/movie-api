package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.mapper.MoviesMapper;
import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.repository.MovieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class MovieServiceApiTest {

    @Autowired
    public MovieServiceApi movieServiceApi;
    @MockBean
    private MoviesMapper moviesMapper;
    @MockBean
    private MovieRepository movieRepository;

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(moviesMapper, movieRepository);
    }


    @Test
    void add() {
        MovieDto movieDtoMock = mock(MovieDto.class);

        movieServiceApi.add(movieDtoMock);

        verify(moviesMapper).toMovieEntity(movieDtoMock);
        verify(movieRepository).save(any());
    }


}