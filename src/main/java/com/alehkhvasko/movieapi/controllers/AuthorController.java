package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.dto.author.Author;
import com.alehkhvasko.movieapi.models.dto.movie.Movie;
import com.alehkhvasko.movieapi.service.AuthorService;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllMovies() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getMovie(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }

    @PostMapping
    public void addMovie(@RequestBody Author author) {
        authorService.addAuthor(author);
    }
/*
    @PutMapping("/{id}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable Integer id) {
        movieService.updateMovie(movie, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }*/
}
