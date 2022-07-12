package com.alehkhvasko.movieapi.controllers;

import com.alehkhvasko.movieapi.models.Movie;
import com.alehkhvasko.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
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
    public Movie getMovie(@PathVariable Integer id){
        return movieService.getMovie(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/movies")
    public void addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/movies/{id}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable Integer id){
        movieService.updateMovie(movie, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/movies/{id}")
    public void deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
    }


}
