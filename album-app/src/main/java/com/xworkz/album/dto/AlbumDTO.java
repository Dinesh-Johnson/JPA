package com.xworkz.album.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class AlbumDTO {

    private String title;

    private String artist;

    private String genre;

    private String releaseDate;

    private Double price;

    private Float rating;

}
