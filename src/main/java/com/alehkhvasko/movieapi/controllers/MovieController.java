package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movie.html";
    }

    @GetMapping("/{id}")
    public MovieEntity getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public void addMovie(@RequestBody @Valid MovieDto movieDto) {
        movieService.addMovie(movieDto);
    }

/*    @PutMapping("/{id}")
    public void updateMovie(@RequestBody @Valid MovieDto movieDto, @PathVariable Integer id) {
        movieService.updateMovie(movieDto, id);
    }*/

/*    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }*/


/*    @PostMapping("/{id}")
    public void addAuthor(@RequestBody @Valid AuthorDto authorDto, @PathVariable Integer id) {
        movieService.addAuthor(authorDto, id);
    }*/
}
