package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.Movie;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/")
    public String homePage(){
        return "Welcome to movies api";
    }

    @RequestMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @RequestMapping("/movies/{id}")
    public Movie getMovie(@PathVariable Long id){
        return movieService.getMovie(id);
    }

    @RequestMapping(method = RequestMethod.POST, name = "/movies")
    public void addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
    }

    @RequestMapping(method = RequestMethod.PUT, name = "/movies/{id}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable Long id){
        movieService.updateMovie(movie, id);
    }


}
