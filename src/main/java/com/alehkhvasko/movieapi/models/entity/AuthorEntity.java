package com.alehkhvasko.movieapi.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    private Integer id;
    @Column(length = 150)
    private String name;
    @Column(length = 50)
    private String DOB;

    @ManyToOne
    @JoinColumn(
            name = "list_of_movies",
            foreignKey = @ForeignKey(name = "fk_author")
    )
    private ListOfMoviesEntity listOfMoviesEntity;
}
