package com.xworkz.demo.service;

import com.xworkz.demo.entity.AlbumEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AlbumService {

    boolean validateAndSave(AlbumEntity entity);

    Optional<AlbumEntity> getByTitle(String title);

    Optional<AlbumEntity> getByArtist(String artist);

    Optional<AlbumEntity> getByReleaseDate(LocalDate date);

    List<AlbumEntity> findByAllAlbums();

    Optional<AlbumEntity> findByGenre(String genre);

    Optional<AlbumEntity> findById(Integer albumId);

    int updatePriceByArtist(String artist, Double price);

    int updateGenreByTitle(String title, String genre);

    int updateRatingById(Integer albumId, Float rating);

    List<Object[]> getTitleArtistAndGenre();

    List<String[]> getNameAndArtist();

}

