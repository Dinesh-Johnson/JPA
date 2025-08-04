package com.xworkz.demo.service;

import com.xworkz.demo.entity.AlbumEntity;

import java.time.LocalDate;
import java.util.Optional;

public interface AlbumService {

    boolean validateAndSave(AlbumEntity entity);

    Optional<AlbumEntity> getByTitle(String title);

    Optional<AlbumEntity> getByArtist(String artist);

    Optional<AlbumEntity> getByReleaseDate(LocalDate date);
}

