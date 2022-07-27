package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.mapper.MoviesMapper;
import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.repository.MovieRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MoviesMapper moviesMapper;
    private Integer count = 0;

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

    public void addMovieDto(MovieDto movieDto) {
        if (findMovieByCountNumber(movieDto.count).isPresent()){
            updateMovie(movieDto);
            return;
        }
        ++count;
        movieDto.setCount(count);
        MovieEntity movieEntity = MoviesMapper.toMovieEntity(movieDto);
        movieRepository.add(movieEntity);
    }

    public Optional<MovieEntity> findMovieByCountNumber(Integer count) {
        List<MovieEntity> movieEntityList = getAllMovies();
        for (int i = 0; i < movieEntityList.size(); i++) {
            if (movieEntityList.get(i).getCount().equals(count)) {
                return Optional.of(getAllMovies().get(i));
            }
        }
        return Optional.empty();
    }

    public void deleteMovie(MovieEntity movieEntity) {
        --count;
        movieRepository.delete(movieEntity);
    }

    @SneakyThrows
    public MovieEntity getByCountId(Integer count) {
        List<MovieEntity> movies = getAllMovies();
        if (movies.size() == 0){
            throw  new IllegalAccessException("No movies in Db");
        }
        return movies.get(count - 1);
    }

    public MovieEntity addMovieById(Integer count) {
        if (findMovieByCountNumber(count).isEmpty()) {
            return new MovieEntity();
        }
        return getByCountId(count);
    }

    public void updateMovie(MovieDto movieDto) {
        List<MovieEntity> movieEntities = getAllMovies();
            for (MovieEntity foundMovieDto : movieEntities) {
                if (foundMovieDto.getCount().equals(count)) {
                    foundMovieDto.setName(movieDto.getName());
                    foundMovieDto.setDescription(movieDto.getDescription());
            }
            movieRepository.updateMovieList(movieEntities);
        }
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
