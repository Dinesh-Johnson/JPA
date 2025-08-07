package com.xworkz.movie.repository;

import com.xworkz.movie.entity.MovieEntity;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public interface MovieRepo {

    boolean save(MovieEntity entity);

    Optional<MovieEntity> findByTitle(String title);

    Optional<MovieEntity> findByLanguage(String language);

    Optional<MovieEntity> findByReleaseDate(LocalDate releaseDate);

    List<MovieEntity> findAllMovies();

    Optional<MovieEntity> findByDirector(String director);

    Optional<MovieEntity> findByMovieId(Integer movieId);

    List<MovieEntity> findByBudget(Double budget);

    int updateBudgetByDirector(String director, Double budget);

    public int updateImdbRatingByTitle(String title, Float imdbRating);

    int updateLanguageById(Integer movieId, String language);

    List<Object[]>getMovieNamesDirectorAndLanguage();

}
