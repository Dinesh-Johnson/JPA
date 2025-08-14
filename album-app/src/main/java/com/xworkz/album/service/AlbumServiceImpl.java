package com.xworkz.album.service;

import com.xworkz.album.dto.AlbumDTO;
import com.xworkz.album.entity.AlbumEntity;
import com.xworkz.album.repo.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumRepo repo;

    @Override
    public boolean validation(AlbumDTO dto) {

        if (dto!=null){
            System.out.println("Dto is Not Null");
        }else {
            System.out.println("Dto is Null");
            return false;
        }
        if (dto.getArtist()!=null){
            System.out.println("Artist is not null");
        }else {
            System.out.println("Artist is Null");
            return false;
        }
        if (dto.getPrice()>0){
            System.out.println("Price is Good..");
        }else {
            System.out.println("Price is Bad..");
            return false;
        }
        if (dto.getGenre()!=null){
            System.out.println("Genre is not Null");
        }else {
            System.out.println("Genre is NUll");
            return false;
        }
        if (dto.getReleaseDate()!=null){
            System.out.println("Date is Valid.");
        }else {
            System.out.println("Date is Invalid...");
            return false;
        }
        if (dto.getRating()!=null){
            System.out.println("Rating is not Null");
        }else {
            System.out.println("Rating is null");
            return false;
        }
        if (dto.getTitle()!=null){
            System.out.println("Title is Valid");
        }else {
            System.out.println("title is Invalid");
            return false;
        }

        AlbumEntity entity= new AlbumEntity();
        entity.setGenre(dto.getGenre());
        entity.setRating(dto.getRating());
        entity.setPrice(dto.getPrice());
        entity.setReleaseDate(dto.getReleaseDate());
        entity.setTitle(dto.getTitle());
        entity.setArtist(dto.getArtist());

        return repo.save(entity);
    }

    @Override
    public List<AlbumDTO> getAllAlbum() {
        List<AlbumDTO> dtos =null;
        List<AlbumEntity> entities = repo.getAllAlbum();
        System.out.println("Serivice MEthod.....");
        dtos = entities.stream().map(e->{
            AlbumDTO dto = new AlbumDTO();
            dto.setAlbumId(e.getAlbumId());
            dto.setRating(e.getRating());
            dto.setTitle(e.getTitle());
            dto.setPrice(e.getPrice());
            dto.setGenre(e.getGenre());
            dto.setArtist(e.getArtist());
            dto.setReleaseDate(e.getReleaseDate());

            return dto;
        }).collect(Collectors.toList());

        return dtos;
    }

    @Override
    public AlbumDTO fetchDataByID(Integer id) {
        AlbumEntity e = repo.fetchDataByID(id);
        AlbumDTO dto = new AlbumDTO();
        dto.setAlbumId(e.getAlbumId());
        dto.setRating(e.getRating());
        dto.setTitle(e.getTitle());
        dto.setPrice(e.getPrice());
        dto.setGenre(e.getGenre());
        dto.setArtist(e.getArtist());
        dto.setReleaseDate(e.getReleaseDate());
        return dto;
    }
}
