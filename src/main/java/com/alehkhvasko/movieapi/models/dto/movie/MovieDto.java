package com.alehkhvasko.movieapi.models.dto.movie;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class MovieDto {
    public Integer count = 0;
    @Size(min = 3, message = "Should be at least 3 symbols")
    public String name;
    @Size(min = 3, message = "Should be at least 3 symbols")
    public String description;

    public MovieDto() {
    }

    public MovieDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
