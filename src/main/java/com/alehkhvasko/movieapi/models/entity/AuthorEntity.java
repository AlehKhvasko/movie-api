package com.alehkhvasko.movieapi.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorEntity {
    private final Long id = new Random().nextLong();
    @Column(length = 150)
    private String name;
    @Column(length = 50)
    private String state;
    //private LocalDateTime dateOfBirth;
}
