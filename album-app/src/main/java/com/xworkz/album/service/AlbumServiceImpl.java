package com.xworkz.album.service;

import com.xworkz.album.dto.AlbumDTO;
import com.xworkz.album.entity.AlbumEntity;
import com.xworkz.album.repo.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        entity.setRating(dto.getRating());

        return repo.save(entity);
    }
}
