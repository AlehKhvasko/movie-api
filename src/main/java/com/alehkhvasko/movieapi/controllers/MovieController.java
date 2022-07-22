package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
        if (movieService.getMovieByCount(count).isEmpty()) {
            System.out.println(count);
            movieEntity = new MovieEntity();
        }

        else {
            movieEntity = movieService.getByCountMovie(count);
        }
        model.addAttribute("movie", movieEntity);
        return "form";
    }

    @GetMapping  (value = "/delete/{count}")
    public String handleDeleteUser(@PathVariable Integer count) {
        movieService.deleteMovie(movieService.getByCountMovie(count));
        return "redirect:/movies";
    }

    @GetMapping("/handleSubmit")
    public String addMovie(MovieDto movieDto) {
        movieService.addOrUpdateMovie(movieDto, movieDto.count);
        return "redirect:/movies";
    }


/*    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }*/


/*    @PostMapping("/{id}")
    public void addAuthor(@RequestBody @Valid AuthorDto authorDto, @PathVariable Integer id) {
        movieService.addAuthor(authorDto, id);
    }*/
}
