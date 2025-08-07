package com.xworkz.movie.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movie_table")
@Setter
@NamedQuery(name = "findByTitle", query = "select m from MovieEntity m where m.title = :title")
@NamedQuery(name = "findByLanguage", query = "select m from MovieEntity m where m.language = :language")
@NamedQuery(name = "findByReleaseDate", query = "select m from MovieEntity m where m.releaseDate = :releaseDate")
@NamedQuery(name = "findAllMovies", query = "SELECT a from  MovieEntity a")
@NamedQuery(name = "findByDirector", query = "select a from MovieEntity a where a.director=:director")
@NamedQuery(name = "findById", query = "select a from MovieEntity a where a.movieId = :movieId")
@NamedQuery(name = "updateImdbRatingByTitle",
        query = "UPDATE MovieEntity m SET m.imdbRating = :imdbRating WHERE m.title = :title")
@NamedQuery(name = "updateBudgetByDirector",
        query = "UPDATE MovieEntity m SET m.budget = :budget WHERE m.director = :director")
@NamedQuery(name = "updateLanguageById",
        query = "UPDATE MovieEntity m SET m.language = :language WHERE m.movieId = :movieId")
@NamedQuery(name = "getMovieNamesDirectorAndLanguage",query = "select a.title,a.director,language from MovieEntity a")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "language")
    private String language;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "budget")
    private Double budget;

    @Column(name = "imdb_rating")
    private Float imdbRating;
}