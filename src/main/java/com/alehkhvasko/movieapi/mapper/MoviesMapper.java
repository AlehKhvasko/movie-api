package com.alehkhvasko.movieapi.mapper;

import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MoviesMapper {
    public MovieEntity toMovieEntity(MovieDto movieDto){
        return MovieEntity.builder()
                .name(movieDto.name)
                .description(movieDto.description)
                .build();
    }
}
