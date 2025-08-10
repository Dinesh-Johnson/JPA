package com.xworkz.album.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "album_name")
@Data
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
    private String releaseDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "rating")
    private Float rating;

}
