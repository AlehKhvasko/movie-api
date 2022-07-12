package com.alehkhvasko.movieapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Movie {
    private Integer id;
    public String name;
    public String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && Objects.equals(description, movie.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
