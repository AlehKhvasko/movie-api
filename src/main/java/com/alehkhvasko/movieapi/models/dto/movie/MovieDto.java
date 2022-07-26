package com.alehkhvasko.movieapi.models.dto.movie;

import com.alehkhvasko.movieapi.models.dto.author.AuthorDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.*;

@Data
public class MovieDto {
    public Integer count = 0;
    @Size(min = 3, message = "Should be at least 3 symbols")
    public String name;
    @Size(min = 3, message = "Should be at least 3 symbols")
    public String description;
    private List<AuthorDto> authorDtos = new ArrayList<>();

    public MovieDto() {
    }

    public MovieDto(String name, String description, List<AuthorDto> authorDtos) {
        this.name = name;
        this.description = description;
        this.authorDtos = authorDtos;
    }

    public MovieDto(String name, String description){
        this.name=name;
        this.description=description;
    }

    public void addAuthor(AuthorDto authorDto){
        authorDtos.add(authorDto);
    }
}
