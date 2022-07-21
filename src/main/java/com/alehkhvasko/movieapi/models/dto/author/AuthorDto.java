package com.alehkhvasko.movieapi.models.dto.author;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AuthorDto {
    @Size(min = 3)
    private String name;
    @NotEmpty
    private String state;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //private LocalDateTime dateOfBirth;
}
