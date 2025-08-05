package com.xworkz.demo.service;

import com.xworkz.demo.entity.AlbumEntity;
import com.xworkz.demo.repository.AlbumRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository repo;

    public AlbumServiceImpl(AlbumRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean validateAndSave(AlbumEntity entity) {
        if (entity.getTitle() != null && entity.getArtist() != null && entity.getPrice() != null) {
            return repo.save(entity);
        }
        System.out.println("Validation failed");
        return false;
    }

    @Override
    public Optional<AlbumEntity> getByTitle(String title) {
        return repo.findByTitle(title);
    }

    @Override
    public Optional<AlbumEntity> getByArtist(String artist) {
        return repo.findByArtist(artist);
    }

    @Override
    public Optional<AlbumEntity> getByReleaseDate(LocalDate date) {
        return repo.findByReleaseDate(date);
    }

    @Override
    public List<AlbumEntity> findByAllAlbums() {


        return repo.findByAllAlbums();
    }

    @Override
    public Optional<AlbumEntity> findByGenre(String genre) {
        return repo.findByGenre(genre);
    }

    @Override
    public Optional<AlbumEntity> findById(Integer albumId) {
        return repo.findById(albumId);
    }

    @Override
    public int updatePriceByArtist(String artist, Double price) {
        return repo.updatePriceByArtist(artist,price);
    }

    @Override
    public int updateGenreByTitle(String title, String genre) {
        return repo.updateGenreByTitle(title, genre);
    }

    @Override
    public int updateRatingById(Integer albumId, Float rating) {
        return repo.updateRatingById(albumId, rating);
    }
}