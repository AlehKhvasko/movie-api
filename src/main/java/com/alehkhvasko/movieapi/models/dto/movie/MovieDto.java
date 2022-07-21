package com.alehkhvasko.movieapi.models.dto.movie;

import com.alehkhvasko.movieapi.models.dto.author.AuthorDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.*;

@Data
@NoArgsConstructor
public class MovieDto {
    @NotBlank(message = "Name shouldn't be empty")
    public String name;
    @NotBlank(message = "Description shouldn't be empty")
    public String description;
    private List<AuthorDto> authorDtos = new ArrayList<>();

    public void addAuthor(AuthorDto authorDto){
        authorDtos.add(authorDto);
    }
}
