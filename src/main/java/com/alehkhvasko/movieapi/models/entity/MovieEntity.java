package com.alehkhvasko.movieapi.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {
    private final Long id = new Random().nextLong();
    private Integer count;
    private String name;
    private String description;

    private Set<AuthorEntity> authorEntityList = new HashSet<>();

    public MovieEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void addAuthor(AuthorEntity authorEntity) {
        authorEntityList.add(authorEntity);
    }

    public void addAuthors(List<AuthorEntity> authorEntityList) {
        this.authorEntityList.addAll(authorEntityList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieEntity that = (MovieEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
