package com.alehkhvasko.movieapi.models.dto.movie;

import com.alehkhvasko.movieapi.models.dto.author.Author;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.*;
import java.util.*;

@Data
public class Movie {
    private Integer id;
    @NotBlank(message = "Name shouldn't be empty")
    public String name;
    @NotBlank(message = "Description shouldn't be empty")
    public String description;
    private List<Author> authors = new ArrayList<>();

    public Movie(){
        this.id = new Random().nextInt();
    }

    public Movie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addAuthor(Author author){
        authors.add(author);
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
