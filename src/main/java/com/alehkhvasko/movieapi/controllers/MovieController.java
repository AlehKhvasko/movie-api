package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.dto.author.Author;
import com.alehkhvasko.movieapi.models.dto.movie.Movie;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    //@ResponseBody
    public List<Movie> getAllMovies(Model model) {
       // ModelAndView mav = new ModelAndView("movie");
        //mav.addObject("movies", movieService.getAllMovies());
        //return mav;
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Integer id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    public void addMovie(@RequestBody @Valid Movie movie) {
        movieService.addMovie(movie);
    }

    @PutMapping("/{id}")
    public void updateMovie(@RequestBody @Valid Movie movie, @PathVariable Integer id) {
        movieService.updateMovie(movie, id);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }


    @PostMapping("/{id}")
    public void addAuthor(@RequestBody @Valid Author author, @PathVariable Integer id) {
        movieService.addAuthor(author, id);
    }
}
