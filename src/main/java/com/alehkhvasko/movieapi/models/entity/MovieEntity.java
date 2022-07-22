package com.alehkhvasko.movieapi.models.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {
    private Integer count;
    private final Long id= new Random().nextLong();
    private String name;
    private String description;

    public MovieEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //private List<AuthorEntity> authors = new ArrayList<>();
}
