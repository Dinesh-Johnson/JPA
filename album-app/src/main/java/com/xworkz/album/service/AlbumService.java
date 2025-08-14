package com.xworkz.album.service;

import com.xworkz.album.dto.AlbumDTO;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface AlbumService {

    boolean validation(AlbumDTO dto);

    List<AlbumDTO> getAllAlbum();

    AlbumDTO fetchDataByID(Integer id);
}
