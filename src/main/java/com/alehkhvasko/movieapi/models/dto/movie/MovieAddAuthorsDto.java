package com.alehkhvasko.movieapi.models.dto.movie;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class MovieAddAuthorsDto {
    @NotNull
    private Long movieId;
    @NotNull
    private List<Long> authorIds;

    public MovieAddAuthorsDto() {
    }
}

