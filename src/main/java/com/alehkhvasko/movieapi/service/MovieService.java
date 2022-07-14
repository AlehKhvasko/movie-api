package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.models.dto.movie.Movie;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    public List<Movie> movies = new ArrayList<>(List.of(
            new Movie(1, "The Hurt Locker","It won six Academy Awards"),
            new Movie(2, "Mad Max: Fury Road","The film took home six of the 10 Academy Awards for which it was nominated." ),
            new Movie(3, "The Truman Show","The film received three Oscar nominations, including for Best Screenplay – Written Directly for the Screen." )
    ));


    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovie(Integer id) {
        Movie movie = movies.stream().filter(m -> m.getId().equals(id)).findFirst().get();
        return Optional.of(movie).orElseThrow(EmptyStackException::new);
    }


    public void addMovie(Movie movie) {
        movies.add(movie);
        //TODO is it correct to inject mapper to service add
    }


    public void updateMovie(Movie movie, Integer id) {
        for (int i = 0; i < movies.size(); i++) {
            Movie foundMovie = movies.get(i);
            if (foundMovie.getId().equals(id)) {
                foundMovie.setName(movie.getName());
                foundMovie.setDescription(movie.getDescription());
                return;
            }
        }
    }

    public void deleteMovie(Integer id) {
        movies.removeIf(t->t.getId().equals(id));
    }
}
