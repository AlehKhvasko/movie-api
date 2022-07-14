package com.alehkhvasko.movieapi.models.dto.movie;

import com.alehkhvasko.movieapi.models.dto.author.Author;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Data
public class Movie {
    @Positive
    private Integer id ;
    @NotBlank
    public String name;
    @NotBlank
    public String description;
    @NonNull
    private List<Author> authors = new ArrayList<>();

    public Movie(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Movie(String name, String description) {
        this.id = new Random().nextInt();
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
