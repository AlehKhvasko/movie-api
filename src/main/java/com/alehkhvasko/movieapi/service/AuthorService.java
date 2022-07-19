package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.models.dto.author.Author;
import com.alehkhvasko.movieapi.models.dto.movie.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    public List<Author> authors = new ArrayList<>();

    public List<Author> getAllAuthors() {
        return authors;
    }

    public Author getAuthor(Long id) {
        return authors.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }
}
