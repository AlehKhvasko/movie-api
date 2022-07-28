package com.alehkhvasko.movieapi.repository;

import com.alehkhvasko.movieapi.models.entity.AuthorEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorRepository {
    private final List<AuthorEntity> authorList = new ArrayList<>();

    public AuthorEntity add(AuthorEntity authorEntity){
        authorList.add(authorEntity);
        return authorEntity;
    }

    public Optional<AuthorEntity> findById(Long id){
        return authorList.stream()
                .filter(authorEntity -> authorEntity.getId().equals(id))
                .findFirst();
    }

    public List<AuthorEntity> getAllAuthors(){
        return Collections.unmodifiableList(authorList);
    }
}
