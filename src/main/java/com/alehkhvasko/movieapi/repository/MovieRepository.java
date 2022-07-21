package com.alehkhvasko.movieapi.repository;

import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.AuthorEntity;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import lombok.Data;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class MovieRepository {
    private List<MovieEntity> movieList = new ArrayList<>(List.of(
            new MovieEntity("Terminator", "Future")));

    public void add(MovieEntity movieEntity){
        movieList.add(movieEntity);
    }

    public Optional<MovieEntity> get(Long id){
        return movieList.stream()
                .filter(movieEntity -> movieEntity.getId().equals(id))
                .findFirst();
    }

    public List<MovieEntity> getAllMovies(){
        return Collections.unmodifiableList(movieList);
    }
}
