package com.alehkhvasko.movieapi.repository;

import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    private final Set<MovieEntity> movieList = new HashSet<>();

    public void save(MovieEntity movieEntity) {
        movieList.add(movieEntity);
    }

    public void delete(MovieEntity movieEntity) {
        movieList.removeIf(t -> t.getCount().equals(movieEntity.getCount()));
    }

    public void updateMovieList(List<MovieEntity> movieList) {
        this.movieList.addAll(movieList);
    }

    public Set<MovieEntity> getAllMovies() {
        return Collections.unmodifiableSet(movieList);
    }

    public Optional<MovieEntity> findById(Long id) {
        return movieList.stream()
                .filter(movieEntity -> movieEntity.getId().equals(id))
                .findFirst();
    }
}
