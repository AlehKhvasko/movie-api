package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.Movie;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
