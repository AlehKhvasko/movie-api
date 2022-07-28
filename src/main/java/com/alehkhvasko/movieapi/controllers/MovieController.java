package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.service.MovieService;
import com.alehkhvasko.movieapi.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping
public class MovieController {

    private final MovieService movieServiceImpl;

    public MovieController(@Qualifier("MovieServiceImpl") MovieServiceImpl movieServiceImpl) {
        this.movieServiceImpl = movieServiceImpl;
    }

    @GetMapping("/movies")
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieServiceImpl.getAllMovies());
        return "movie";
    }

//    @GetMapping("/")
//    public String getForm(Model model, @RequestParam(required = false) Integer id) {
//        model.addAttribute("movies", movieServiceImpl.addMovieByCountId(id));
//        return "form";
//    }
//
//    @GetMapping("/delete/{count}")
//    public String handleDeleteUser(@PathVariable Integer count) {
//        movieServiceImpl.deleteMovie(movieServiceImpl.getByCountId(count));
//        return "redirect:/movies";
//    }

    @GetMapping("/handleSubmit")
    public String addMovie(@Valid @ModelAttribute("movies") MovieDto movieDto,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movies", movieDto);
            return "form";
        }
        movieServiceImpl.add(movieDto);
        return "redirect:/movies";
    }
}
