package com.alehkhvasko.movieapi.mapper;

import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MoviesMapper {
    public MovieEntity toMovieEntity(MovieDto movieDto) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(movieDto.name);
        movieEntity.setDescription(movieDto.getDescription());
        movieEntity.setCount(movieDto.getCount());
        return movieEntity;
    }
}
