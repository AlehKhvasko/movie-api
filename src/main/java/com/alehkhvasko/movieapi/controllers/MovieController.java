package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movie.html";
    }
    //TODO not updating, creates new movie
    @GetMapping("/movies/{id}")
    public MovieEntity getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) Integer count) {
        model.addAttribute("movies", movieService.addMovieById(count));
        return "form";
    }

    @GetMapping("/delete/{count}")
    public String handleDeleteUser(@PathVariable Integer count) {
        movieService.deleteMovie(movieService.getByCountId(count));
        return "redirect:/movies";
    }

    @GetMapping("/handleSubmit")
    public String addMovie(@Valid @ModelAttribute("movies") MovieDto movieDto,
                           BindingResult result, Model model) {
       if (result.hasErrors()) {
            model.addAttribute("movies", movieDto);
            return "form";
        }
        movieService.addMovieDto(movieDto);
        return "redirect:/movies";
    }
}
