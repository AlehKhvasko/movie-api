package com.alehkhvasko.movieapi.service;

import com.alehkhvasko.movieapi.mapper.AuthorMapper;
import com.alehkhvasko.movieapi.models.dto.author.AuthorDto;
import com.alehkhvasko.movieapi.models.entity.AuthorEntity;
import com.alehkhvasko.movieapi.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper){
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.getAllAuthors();
    }

/*    public AuthorDto getAuthor(Long id) {
        return authorDtos.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }*/

    public AuthorEntity addAuthor(AuthorDto authorDto) {
        return authorRepository.add(authorMapper.toAuthorEntity(authorDto));
    }
}
