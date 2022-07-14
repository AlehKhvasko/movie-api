package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.dto.movie.Movie;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("{id}")
    public Movie getMovie(@PathVariable Integer id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @PutMapping("{id}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable Integer id) {
        movieService.updateMovie(movie, id);
    }

    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }
}
