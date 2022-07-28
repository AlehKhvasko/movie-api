//package com.alehkhvasko.movieapi.service;
//
//import com.alehkhvasko.movieapi.mapper.MoviesMapper;
//import com.alehkhvasko.movieapi.models.dto.movie.MovieDto;
//import com.alehkhvasko.movieapi.models.entity.MovieEntity;
//import com.alehkhvasko.movieapi.repository.MovieRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class MovieServiceImplTest {
//    private List<MovieEntity> movieEntities;
//    private List<MovieDto> moviesDto;
//
//    @Mock
//    private MovieRepository movieRepository;
//
//    @InjectMocks
//    private MovieServiceImpl movieServiceImpl;
//
//    @BeforeEach
//    public void setUp() {
//        movieEntities = List.of(
//                new MovieEntity("Avatar", "The story of an ex-Marine (Sam Worthington)"),
//                new MovieEntity("The Notebook", "The love story of Allie and Noah.")
//                );
//        movieEntities.get(0).setCount(1);
//        movieEntities.get(1).setCount(2);
//        moviesDto = List.of(
//                new MovieDto("Avatar ", "The story of an ex-Marine (Sam Worthington)"),
//                new MovieDto("The Notebook 2", "The love story of Allie and Noah.")
//        );
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void getAllMovies_should_return_listOfMovies() {
//        when(movieRepository.getAllMovies()).thenReturn(movieEntities);
//        List<MovieEntity> result = movieServiceImpl.getAllMovies();
//
//        assertEquals(result.get(0), movieEntities.get(0));
//    }
//
//    @Test
//    void addMovieDto_should_be_called_one_time_if_not_in_db() {
//        doNothing().when(movieRepository).add(movieEntities.get(0));
//        movieServiceImpl.addMovieDto(moviesDto.get(0));
//        MovieEntity movieEntity = MoviesMapper.toMovieEntity(moviesDto.get(0));
//        verify(movieRepository, times(1)).getAllMovies();
//        verify(movieRepository, times(1)).add(movieEntity);
//    }
//
//    @Test
//    void addMovieDto_should_add_movieEntity_if_not_in_db() {
//        //TODO How to test real addding to db & why it's in red color?
//
//    }
//
//    @Test
//    void findMovieByCountNumber_should_return_movieEntity_if_exist() {
//        when(movieRepository.getAllMovies()).thenReturn(movieEntities);
//        List<MovieEntity> result = movieServiceImpl.getAllMovies();
//        MovieEntity movieEntity = movieServiceImpl.findMovieByCountNumber(1).get();
//
//        assertEquals(movieEntity, result.get(0));
//    }
//
//    @Test
//    void deleteMovie_should_invoke_delete_if_exist() {
//        MovieEntity movieEntity = movieEntities.get(0);
//        doNothing().when(movieRepository)
//                .delete(movieEntity);
//        movieServiceImpl.deleteMovie(movieEntity);
//        verify(movieRepository, times(1))
//                .delete(movieEntity);
//    }
//
//    @Test
//    void getByCountId_should_return_movieEntity_if_exist() {
//        when(movieRepository.getAllMovies()).thenReturn(movieEntities);
//        MovieEntity movieEntity = movieEntities.get(0);
//        MovieEntity result = movieServiceImpl.getByCountId(1);
//        assertEquals(result, movieEntity );
//    }
//
//    @Test
//    void getByCountId_throw_IllegalAccessException_when_db_is_empty() {
//        when(movieRepository.getAllMovies()).thenReturn(new ArrayList<>());
//        IllegalAccessException thrown = Assertions.assertThrows(IllegalAccessException.class, () -> {
//            movieServiceImpl.getByCountId(1);
//        });
//
//        assertEquals("No movies in Db", thrown.getMessage());
//    }
//
//    @Test
//    void addMovieByCountId_should_return_movieEntity_if_exists() {
//        MovieEntity result = movieEntities.get(0);
//        when(movieRepository.getAllMovies()).thenReturn(movieEntities);
//        MovieEntity movieEntity = movieServiceImpl.addMovieByCountId(1);
//
//        assertEquals(movieEntity, result);
//    }
//
//    @Test
//    void addMovieByCountId_should_return_empty_movieEntity_if_doesnt_exist_in_db() {
//        MovieEntity result = new MovieEntity();
//        when(movieRepository.getAllMovies()).thenReturn(new ArrayList<>());
//        MovieEntity movieEntity = movieServiceImpl.addMovieByCountId(1);
//
//        assertEquals(movieEntity, result);
//    }
//
//    @Test
//    void updateMovie() {
//        MovieDto movieDto = moviesDto.get(0);
//        when(movieRepository.getAllMovies()).thenReturn(movieEntities);
//        doNothing().when(movieRepository).updateMovieList(movieEntities);
//        movieServiceImpl.updateMovie(movieDto);
//        verify(movieRepository, times(1))
//                .getAllMovies();
//        verify(movieRepository, times(1))
//                .updateMovieList(movieEntities);
//    }
//}