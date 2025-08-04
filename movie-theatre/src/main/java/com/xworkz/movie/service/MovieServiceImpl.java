package com.xworkz.movie.service;

import com.xworkz.movie.entity.MovieEntity;
import com.xworkz.movie.repository.MovieRepo;

import java.time.LocalDate;
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
}
