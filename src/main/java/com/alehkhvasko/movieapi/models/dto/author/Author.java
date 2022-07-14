package com.alehkhvasko.movieapi.models.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Author {
    private int id;
    @NotEmpty
    private String name;
    @Past
    @NotEmpty
    private String DOB;
    @NotEmpty
    private String state;
    //LocalDate today = LocalDate.now();
    //LocalDate birthday = LocalDate.of(1987, 09, 24);

    //Period period = Period.between(birthday, today);
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
