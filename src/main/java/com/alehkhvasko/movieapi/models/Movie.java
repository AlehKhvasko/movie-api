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

}
