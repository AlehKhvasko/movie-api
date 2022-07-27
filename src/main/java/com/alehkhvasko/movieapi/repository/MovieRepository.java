package com.alehkhvasko.movieapi.repository;

import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class MovieRepository {
    private List<MovieEntity> movieList = new ArrayList<>();

    public void add(MovieEntity movieEntity){
        movieList.add(movieEntity);
    }

    public void delete(MovieEntity movieEntity){
        movieList.removeIf(t->t.getCount().equals(movieEntity.getCount()));
    }

    public Optional<MovieEntity> get(Integer count){
        return movieList.stream()
                .filter(movieEntity -> movieEntity.getCount().equals(count))
                .findFirst();
    }

    public void updateMovieList(List<MovieEntity> movieList){
        movieList.addAll(movieList);
    }

    public List<MovieEntity> getAllMovies(){
        return Collections.unmodifiableList(movieList);
    }
}
