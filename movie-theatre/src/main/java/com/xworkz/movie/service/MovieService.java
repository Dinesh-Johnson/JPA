package com.xworkz.movie.service;

import com.xworkz.movie.entity.MovieEntity;

import java.time.LocalDate;
import java.util.Optional;

public interface MovieService {
    boolean validateAndSave(MovieEntity entity);

    Optional<MovieEntity> findByTitle(String title);

    Optional<MovieEntity> findByLanguage(String language);

    Optional<MovieEntity> findByReleaseDate(LocalDate releaseDate);
}
