package com.alehkhvasko.movieapi.mapper;

import com.alehkhvasko.movieapi.models.dto.author.AuthorDto;
import com.alehkhvasko.movieapi.models.entity.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public AuthorEntity toAuthorEntity(AuthorDto authorDto){
        return AuthorEntity.builder()
                .name(authorDto.getName())
                //.dateOfBirth(authorDto.getDateOfBirth())
                .state(authorDto.getState())
                .build();
    }
}
