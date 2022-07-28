package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.models.dto.movie.MovieAddAuthorsDto;
import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;

import java.util.Set;

public interface MovieService {
    Set<MovieEntity> getAllMovies();

    MovieEntity add(MovieDto movieDto);

    void deleteMovie(MovieEntity movieEntity);

    MovieEntity addAuthors(MovieAddAuthorsDto movieAddAuthorsDto);

    void updateMovie(MovieDto movieDto);

    MovieEntity findById(Long id);

//    MovieEntity addMovieByCountId(Integer count);
//    Optional<MovieEntity> findMovieByCountNumber(Integer count);
//

//    @SneakyThrows

//    MovieEntity getByCountId(Integer count);

}
