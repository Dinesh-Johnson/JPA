package com.xworkz.movie.repository;

import com.xworkz.movie.entity.MovieEntity;

import java.time.LocalDate;
import java.util.Optional;

public interface MovieRepo {

    boolean save(MovieEntity entity);

    Optional<MovieEntity> findByTitle(String title);

    Optional<MovieEntity> findByLanguage(String language);

    Optional<MovieEntity> findByReleaseDate(LocalDate releaseDate);
}
