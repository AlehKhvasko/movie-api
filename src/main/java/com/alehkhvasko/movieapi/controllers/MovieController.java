package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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

    @GetMapping("/movies/{id}")
    public MovieEntity getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) Integer count) {
        MovieEntity movieEntity;
        if (movieService.findMovieByCountNumber(count).isEmpty()) {
            movieEntity = new MovieEntity();
        } else {
            movieEntity = movieService.getByCountMovie(count);
        }
        model.addAttribute("movies", movieEntity);
        return "form";
        // int index = getGradeIndex(id);
        //model.addAttribute("grade", index == Constants.NOT_FOUND ? new Grade()
        //         : studentGrades.get(index));
        // return "form";
    }

    @GetMapping("/delete/{count}")
    public String handleDeleteUser(@PathVariable Integer count) {
        movieService.deleteMovie(movieService.getByCountMovie(count));
        return "redirect:/movies";
    }

    @GetMapping("/handleSubmit")
    public String addMovie(@Valid @ModelAttribute("movies") MovieDto movieDto,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movies", movieDto);
            return "form";
        }
        movieService.addOrUpdateMovie(movieDto, movieDto.count);
        return "redirect:/movies";
    }

}
