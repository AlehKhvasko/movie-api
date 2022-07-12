package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.models.Movie;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private  List<Movie> movies = List.of(new Movie(
            1L,
            "The Hurt Locker",
            "Kathryn Bigelow’s career hit a second stride with the release of her gripping Iraq War drama," +
                    " “The Hurt Locker.” The film follows a bomb disposal team from one job to the next. Instead of traditional character development," +
                    " the story coasts by on a wave of sustained and almost unbearable tension. "),
            new Movie(
                    2L,
                    "Mad Max: Fury Road",
                    "Director George Miller resurrected his classic “Mad Max” franchise in 2015," +
                            " with Tom Hardy taking on the lead role, formerly played by Mel Gibson. However," +
                            " most fans would argue it's Charlize Theron's Furiosa who steals the show in this dazzling" +
                            " adventure movie, which sees her and Mad Max escaping the clutches of an evil warlord." +
                            " As one might expect, the explosive action goes down in a post-apocalyptic wasteland" +
                            " inhabited by all sorts of depraved humans. The film took home six of the 10 Academy" +
                            " Awards for which it was nominated."));

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovie(Long id) {
        Movie movie = movies.stream().filter(m->m.getId().equals(id)).findFirst().get();
        return Optional.of(movie).orElseThrow(EmptyStackException::new);
    }


}
