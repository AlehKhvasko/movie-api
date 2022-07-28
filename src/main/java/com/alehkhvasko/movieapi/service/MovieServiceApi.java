package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.mapper.MoviesMapper;
import com.alehkhvasko.movieapi.models.dto.movie.MovieAddAuthorsDto;
import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.AuthorEntity;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("MovieServiceApi")
@RequiredArgsConstructor
public class MovieServiceApi implements MovieService {
    private final MovieRepository movieRepository;
    private final MoviesMapper moviesMapper;
    private final AuthorService authorService;

    @Override
    public Set<MovieEntity> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public MovieEntity add(MovieDto movieDto) {
        MovieEntity movieEntity = moviesMapper.toMovieEntity(movieDto);
        movieRepository.save(movieEntity);
        return movieEntity;
    }

    @Override
    public MovieEntity addAuthors(MovieAddAuthorsDto movieAddAuthorsDto) {
        MovieEntity movieEntity = findById(movieAddAuthorsDto.getMovieId());

        List<AuthorEntity> authorEntities = new ArrayList<>();
        for (Long id : movieAddAuthorsDto.getAuthorIds()) {
            authorEntities.add(authorService.findById(id));
        }

        movieEntity.addAuthors(authorEntities);

        movieRepository.save(movieEntity);

        return movieEntity;
    }

    @Override
    public MovieEntity findById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cant find movie with id: " + id));
    }

    @Override
    public void deleteMovie(MovieEntity movieEntity) {

    }

    @Override
    public void updateMovie(MovieDto movieDto) {

    }
}
