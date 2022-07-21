package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.mapper.MoviesMapper;
import com.alehkhvasko.movieapi.models.dto.author.AuthorDto;
import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import com.alehkhvasko.movieapi.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final MoviesMapper moviesMapper;

    public MovieService(MovieRepository movieRepository, MoviesMapper moviesMapper){
        this.movieRepository= movieRepository;
        this.moviesMapper = moviesMapper;
    }

    public MovieEntity getMovie(Long id) {
        return movieRepository.get(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<MovieEntity> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public void addMovie(MovieDto movieDto) {
        MovieEntity movieEntity = moviesMapper.toMovieEntity(movieDto);
        movieRepository.add(movieEntity);
    }

/*    public void updateMovie(MovieDto movieDto, Integer id) {
        for (int i = 0; i < movieDtos.size(); i++) {
            MovieDto foundMovieDto = movieDtos.get(i);
            if (foundMovieDto.getId().equals(id)) {
                foundMovieDto.setName(movieDto.getName());
                foundMovieDto.setDescription(movieDto.getDescription());
                return;
            }
        }
    }*/

/*    public void deleteMovie(Integer id) {
        movieDtos.removeIf(t->t.getId().equals(id));
    }*/

    public void addAuthor(AuthorDto authorDto, Integer id) {
        //MovieDto movieDtoById = getMovie(id);
/*        if (Optional.of(movieDtoById).isEmpty()){
             new ResponseEntity<AuthorDto>(HttpStatus.BAD_REQUEST);
        }*/
       // movieDtoById.addAuthor(authorDto);
    }
}
