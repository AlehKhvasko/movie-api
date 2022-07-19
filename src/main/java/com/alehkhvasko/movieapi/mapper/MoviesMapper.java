package com.alehkhvasko.movieapi.mapper;

import com.alehkhvasko.movieapi.models.dto.movie.Movie;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;

public class MoviesMapper {
    public MovieEntity movieEntity(Movie movie){
        return MovieEntity.builder()
                .name(movie.name)
                .description(movie.description)
                .build();
    }
}
