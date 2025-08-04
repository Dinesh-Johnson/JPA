package com.xworkz.movie.runner;

import com.xworkz.movie.entity.MovieEntity;
import com.xworkz.movie.repository.MovieRepo;
import com.xworkz.movie.repository.MovieRepoImpl;
import com.xworkz.movie.service.MovieService;
import com.xworkz.movie.service.MovieServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class MovieRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

        MovieRepo repository = new MovieRepoImpl(emf);
        MovieService service = new MovieServiceImpl(repository);

        MovieEntity entity = new MovieEntity();
        entity.setTitle("Dune: Part Two");
        entity.setDirector("Denis Villeneuve");
        entity.setLanguage("English");
        entity.setReleaseDate(LocalDate.of(2024, 3, 1));
        entity.setBudget(190.0);
        entity.setImdbRating(8.8f);

        boolean saved = service.validateAndSave(entity);
        System.out.println("Saved: " + saved);
//
//        service.findByTitle("Dune: Part Two").ifPresent(e -> System.out.println("Found by title: " + e));
//        service.findByLanguage("English").ifPresent(e -> System.out.println("Found by language: " + e));
//        service.findByReleaseDate(LocalDate.of(2024, 3, 1)).ifPresent(e -> System.out.println("Found by date: " + e));
//
        service.findAllMovies();
        service.findByDirector("Denis Villeneuve");
//        emf.close();
    }
}
