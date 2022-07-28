package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.mapper.MoviesMapper;
import com.alehkhvasko.movieapi.models.dto.movie.MovieAddAuthorsDto;
import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.repository.MovieRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("MovieServiceImpl")
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MoviesMapper moviesMapper;
    private Integer count = 0;

    public MovieServiceImpl(MovieRepository movieRepository, MoviesMapper moviesMapper) {
        this.movieRepository = movieRepository;
        this.moviesMapper = moviesMapper;
    }

    public Set<MovieEntity> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public MovieEntity add(MovieDto movieDto) {
        if (findMovieByCountNumber(movieDto.count).isPresent()) {
            updateMovie(movieDto);
            return moviesMapper.toMovieEntity(movieDto);
        }
        ++count;
        movieDto.setCount(count);
        MovieEntity movieEntity = moviesMapper.toMovieEntity(movieDto);
        movieRepository.save(movieEntity);
        return movieEntity;
    }

    @Override
    public MovieEntity findById(Long id) {
        return null;
    }
    //    public MovieEntity addMovieByCountId(Integer count) {
//        if (findMovieByCountNumber(count).isEmpty()) {
//            return new MovieEntity();
//        }
//        return getByCountId(count);
//    }

    public Optional<MovieEntity> findMovieByCountNumber(Integer count) {
//        List<MovieEntity> movieEntityList = getAllMovies();
//        for (int i = 0; i < movieEntityList.size(); i++) {
//            if (movieEntityList.get(i).getCount().equals(count)) {
//                return Optional.of(getAllMovies().get(i));
//            }
//        }
        return Optional.empty();
    }

    public void deleteMovie(MovieEntity movieEntity) {
        --count;
        movieRepository.delete(movieEntity);
    }

    @SneakyThrows
    public MovieEntity getByCountId(Integer count) {
//        List<MovieEntity> movies = getAllMovies();
//        if (movies.size() == 0) {
//            throw new IllegalAccessException("No movies in Db");
//        }
//        return movies.get(count - 1);
        return MovieEntity.builder().build();
    }


    public void updateMovie(MovieDto movieDto) {
//        List<MovieEntity> movieEntities = getAllMovies();
//        for (MovieEntity foundMovieDto : movieEntities) {
//            if (foundMovieDto.getCount().equals(count)) {
//                foundMovieDto.setName(movieDto.getName());
//                foundMovieDto.setDescription(movieDto.getDescription());
//            }
//        }
//        movieRepository.updateMovieList(movieEntities);
    }

    @Override
    public MovieEntity addAuthors(MovieAddAuthorsDto movieAddAuthorsDto) {
        return null;
    }
}

