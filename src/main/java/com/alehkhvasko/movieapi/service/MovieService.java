package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.models.dto.author.Author;
import com.alehkhvasko.movieapi.models.dto.movie.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    public List<Movie> movies = new ArrayList<Movie>();

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovie(Integer id) {
        return movies.stream().filter(m -> m.getId().equals(id)).findFirst().get();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
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

    public void addAuthor(Author author, Integer id) {
        Movie movieById = getMovie(id);
/*        if (Optional.of(movieById).isEmpty()){
             new ResponseEntity<Author>(HttpStatus.BAD_REQUEST);
        }*/
        movieById.addAuthor(author);
    }
}
