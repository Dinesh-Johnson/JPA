package com.xworkz.demo.entity;


import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Data
@Entity
@Table(name = "album_table")
@NamedQuery(name = "findByAlbumTitle", query = "SELECT a FROM AlbumEntity a WHERE a.title = :title")
@NamedQuery(name = "findByArtist", query = "SELECT a FROM AlbumEntity a WHERE a.artist = :artist")
@NamedQuery(name = "findByReleaseDate", query = "SELECT a FROM AlbumEntity a WHERE a.releaseDate = :releaseDate")
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Integer albumId;

    @Column(name = "title")
    private String title;

    @Column(name = "artist")
    private String artist;

    @Column(name = "genre")
    private String genre;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "rating")
    private Float rating;

}
