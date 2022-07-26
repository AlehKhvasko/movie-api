package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.mapper.MoviesMapper;
import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MoviesMapper moviesMapper;
    public Integer count = 0;

    public MovieService(MovieRepository movieRepository, MoviesMapper moviesMapper) {
        this.movieRepository = movieRepository;
        this.moviesMapper = moviesMapper;
    }

    public MovieEntity getMovie(Long id) {
        return movieRepository.get(Math.toIntExact(id))
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<MovieEntity> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public void addMovie(MovieDto movieDto) {
        ++count;
        movieDto.setCount(count);
        MovieEntity movieEntity = MoviesMapper.toMovieEntity(movieDto);
        movieRepository.add(movieEntity);
    }

    public Optional<MovieEntity> findMovieByCountNumber(Integer count) {
        for (int i = 0; i < getAllMovies().size(); i++) {
            if (getAllMovies().get(i).getCount().equals(count)) {
                return Optional.of(getAllMovies().get(i));
            }
        }
        return Optional.empty();
    }

    public void addOrUpdateMovie(MovieDto movieDto, Integer count) {
        List<MovieEntity> movieEntities = getAllMovies();
        if (findMovieByCountNumber(count).isEmpty()) {
            addMovie(movieDto);
        } else {
            for (MovieEntity foundMovieDto : movieEntities) {
                if (foundMovieDto.getCount().equals(count)) {
                    foundMovieDto.setName(movieDto.getName());
                    foundMovieDto.setDescription(movieDto.getDescription());
                    return;
                }
            }
        }

    }

    public void deleteMovie(MovieEntity movieEntity) {
        movieRepository.delete(movieEntity);
    }

    public MovieEntity getByCountMovie(Integer count) {
        List<MovieEntity> movies = getAllMovies();
        return movies.get(count - 1);
    }
}
/*
    public void addAuthor(AuthorDto authorDto, Integer id) {
        //MovieDto movieDtoById = getMovie(id);
       if (Optional.of(movieDtoById).isEmpty()){
             new ResponseEntity<AuthorDto>(HttpStatus.BAD_REQUEST);
       /
        // movieDtoById.addAuthor(authorDto);
    } }
*/
