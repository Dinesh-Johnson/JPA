package com.xworkz.demo.service;

import com.xworkz.demo.entity.AlbumEntity;
import com.xworkz.demo.repository.AlbumRepository;

import java.time.LocalDate;
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
}