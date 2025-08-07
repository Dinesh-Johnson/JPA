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
@NamedQuery(name = "findAllAlbums", query = "SELECT a FROM AlbumEntity a")
@NamedQuery(name = "findByGenre", query = "SELECT a FROM AlbumEntity a WHERE a.genre = :genre")
@NamedQuery(name = "findById", query = "SELECT a FROM AlbumEntity a WHERE a.albumId = :albumId")
@NamedQuery(name = "updatePriceByArtist",
        query = "UPDATE AlbumEntity a SET a.price = :price WHERE a.artist = :artist")
@NamedQuery(name = "updateGenreByTitle",
        query = "UPDATE AlbumEntity a SET a.genre = :genre WHERE a.title = :title")
@NamedQuery(name = "updateRatingById",
        query = "UPDATE AlbumEntity a SET a.rating = :rating WHERE a.albumId = :albumId")
@NamedQuery(name = "getTitleArtistAndGenre",query = "select a.title,a.artist,a.genre from AlbumEntity a")
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
