package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.dto.author.AuthorDto;
import com.alehkhvasko.movieapi.models.entity.AuthorEntity;
import com.alehkhvasko.movieapi.service.AuthorService;
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
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthors();
    }

/*    @GetMapping("/{id}")
    public AuthorDto getMovie(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }*/

    @PostMapping
    public AuthorEntity addAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.addAuthor(authorDto);
    }
/*
    @PutMapping("/{id}")
    public void updateMovie(@RequestBody MovieDto movie, @PathVariable Integer id) {
        movieService.updateMovie(movie, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }*/
}
