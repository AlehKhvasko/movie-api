package com.alehkhvasko.movieapi.repository;

import com.alehkhvasko.movieapi.models.entity.AuthorEntity;
import com.alehkhvasko.movieapi.models.entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorRepository {
    private List<AuthorEntity> authorList = new ArrayList<>();

    public AuthorEntity add(AuthorEntity authorEntity){
        authorList.add(authorEntity);
        return authorEntity;
    }

    public Optional<AuthorEntity> get(Long id){
        return authorList.stream()
                .filter(authorEntity -> authorEntity.getId().equals(id))
                .findFirst();
    }

    public List<AuthorEntity> getAllAuthors(){
        return Collections.unmodifiableList(authorList);
    }
}
