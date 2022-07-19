package com.alehkhvasko.movieapi.models.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Author {
    private Long id;
    @Size(min = 3)
    private String name;
    @NotEmpty
    private String state;

    public Author() {
        this.id = new Random().nextLong();
    }

    public Author(String name, String state){
        this.name = name;
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
