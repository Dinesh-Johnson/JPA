package com.xworkz.demo.runner;

import com.xworkz.demo.entity.AlbumEntity;
import com.xworkz.demo.repository.AlbumRepository;
import com.xworkz.demo.repository.AlbumRepositoryImpl;
import com.xworkz.demo.service.AlbumService;
import com.xworkz.demo.service.AlbumServiceImpl;

import java.time.LocalDate;

public class AlbumRunner {
    public static void main(String[] args) {

        AlbumRepository repo = new AlbumRepositoryImpl();
        AlbumService service = new AlbumServiceImpl(repo);

        AlbumEntity album = new AlbumEntity();
        album.setTitle("Echoes");
        album.setArtist("Pink Floyd");
        album.setGenre("Progressive Rock");
        album.setReleaseDate(LocalDate.of(2001, 11, 5));
        album.setPrice(499.99);
        album.setRating(4.8f);

//        boolean saved = service.validateAndSave(album);
//        System.out.println("Album saved: " + saved);

        //service.getByTitle("Echoes").ifPresent(a -> System.out.println("Found: " + a.getArtist()));
        service.findByAllAlbums();
        service.findByGenre("Progressive Rock");
    }
}
