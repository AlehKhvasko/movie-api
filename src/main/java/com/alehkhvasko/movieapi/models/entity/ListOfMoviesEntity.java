package com.alehkhvasko.movieapi.models.entity;

import com.alehkhvasko.movieapi.models.dto.author.Author;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "list_of_movies")
public class ListOfMoviesEntity {
    @Id
    private Integer id ;
    public String name;
    public String description;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "author")
    private List<AuthorEntity> authors = new ArrayList<>();
}
