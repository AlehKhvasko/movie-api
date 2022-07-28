package com.alehkhvasko.movieapi.repository;

import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class MovieRepository {
    private List<MovieEntity> movieList = new ArrayList<>();

    public void add(MovieEntity movieEntity){
        movieList.add(movieEntity);
    }

    public void delete(MovieEntity movieEntity){
        movieList.removeIf(t->t.getCount().equals(movieEntity.getCount()));
    }

    public void updateMovieList(List<MovieEntity> movieList){
        movieList.addAll(movieList);
    }

    public List<MovieEntity> getAllMovies(){
        return Collections.unmodifiableList(movieList);
    }
}
