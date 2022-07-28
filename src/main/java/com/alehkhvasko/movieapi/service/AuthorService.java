package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.mapper.AuthorMapper;
import com.alehkhvasko.movieapi.models.dto.author.AuthorDto;
import com.alehkhvasko.movieapi.models.entity.AuthorEntity;
import com.alehkhvasko.movieapi.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

    public AuthorEntity findById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cant find author with id: " + id));
    }

    public AuthorEntity addAuthor(AuthorDto authorDto) {
        return authorRepository.add(authorMapper.toAuthorEntity(authorDto));
    }
}
