package com.xworkz.movie.service;

import com.xworkz.movie.entity.MovieEntity;
import com.xworkz.movie.repository.MovieRepo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MovieServiceImpl implements MovieService {

    private MovieRepo repository;

    public MovieServiceImpl(MovieRepo repository) {
        this.repository = repository;
    }

    @Override
    public boolean validateAndSave(MovieEntity entity) {
        if (entity != null && entity.getTitle() != null && entity.getLanguage() != null) {
            System.out.println("Valid data, proceeding to save...");
            return repository.save(entity);
        }
        System.out.println("Invalid data, not saved.");
        return false;
    }

    @Override
    public Optional<MovieEntity> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public Optional<MovieEntity> findByLanguage(String language) {
        return repository.findByLanguage(language);
    }

    @Override
    public Optional<MovieEntity> findByReleaseDate(LocalDate releaseDate) {
        return repository.findByReleaseDate(releaseDate);
    }

    @Override
    public List<MovieEntity> findAllMovies() {
        return repository.findAllMovies();
    }

    @Override
    public Optional<MovieEntity> findByDirector(String director) {
        return repository.findByDirector(director);
    }

    @Override
    public Optional<MovieEntity> findByMovieId(Integer movieId) {
        return repository.findByMovieId(movieId);
    }

    @Override
    public List<MovieEntity> findByBudget(Double budget) {
        return repository.findByBudget(budget);
    }

    @Override
    public void updateBudgetByDirector(String director, Double budget) {
        repository.updateBudgetByDirector(director, budget);
    }

    @Override
    public int updateImdbRatingByTitle(String title, Float imdbRating) {
        return repository.updateImdbRatingByTitle(title,imdbRating);
    }

    @Override
    public int updateLanguageById(Integer movieId, String language) {
        return repository.updateLanguageById(movieId,language);
    }
}
