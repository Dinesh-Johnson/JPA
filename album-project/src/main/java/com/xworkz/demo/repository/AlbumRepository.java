package com.xworkz.demo.repository;


import com.xworkz.demo.entity.AlbumEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AlbumRepository {

    boolean save(AlbumEntity entity);

    Optional<AlbumEntity> findByTitle(String title);

    Optional<AlbumEntity> findByArtist(String artist);

    Optional<AlbumEntity> findByReleaseDate(LocalDate date);

    List<AlbumEntity> findByAllAlbums();

    Optional<AlbumEntity> findByGenre(String genre);
}