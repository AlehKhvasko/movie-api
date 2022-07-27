package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.mapper.MoviesMapper;
import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.repository.MovieRepository;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceTest {
    private List<MovieEntity> movieEntities;
    private List<MovieDto> moviesDto;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    public void setUp() {
        movieEntities = List.of(
                new MovieEntity("Avatar", "The story of an ex-Marine (Sam Worthington)"),
                new MovieEntity("The Notebook", "The love story of Allie and Noah.")
                );
        movieEntities.get(0).setCount(1);
        movieEntities.get(1).setCount(2);
        moviesDto = List.of(
                new MovieDto("Avatar ", "The story of an ex-Marine (Sam Worthington)"),
                new MovieDto("The Notebook 2", "The love story of Allie and Noah.")
        );
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllMovies_should_return_listOfMovies() {
        when(movieRepository.getAllMovies()).thenReturn(movieEntities);
        List<MovieEntity> result = movieService.getAllMovies();

        assertEquals(result.get(0), movieEntities.get(0));
    }

    @Test
    void addMovieDto_should_be_called_one_time_if_not_in_db() {
        doNothing().when(movieRepository).add(movieEntities.get(0));
        movieService.addMovieDto(moviesDto.get(0));
        MovieEntity movieEntity = MoviesMapper.toMovieEntity(moviesDto.get(0));
        verify(movieRepository, times(1)).getAllMovies();
        verify(movieRepository, times(1)).add(movieEntity);
    }

    @Test
    void findMovieByCountNumber() {
        when(movieRepository.getAllMovies()).thenReturn(movieEntities);
        List<MovieEntity> result = movieService.getAllMovies();
        MovieEntity movieEntity = movieService.findMovieByCountNumber(1).get();

        assertEquals(movieEntity, result.get(0));
    }

    @Test
    void deleteMovie() {
    }

    @Test
    void getByCountId() {
    }

    @Test
    void addMovieById() {
    }

    @Test
    void updateMovie() {
    }
}