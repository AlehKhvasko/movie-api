package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.dto.movie.MovieAddAuthorsDto;
import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("api/v1/movies")
public class ApiMovieController {
    private final MovieService movieService;

    public ApiMovieController(@Qualifier("MovieServiceApi") MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Set<MovieEntity> getAll() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public MovieEntity add(@Valid @RequestBody MovieDto movieDto) {
        return movieService.add(movieDto);
    }

    @PutMapping("/addAuthors")
    public MovieEntity addAuthors(@Valid @RequestBody MovieAddAuthorsDto movieAddAuthorsDto) {
        return movieService.addAuthors(movieAddAuthorsDto);
    }
}
