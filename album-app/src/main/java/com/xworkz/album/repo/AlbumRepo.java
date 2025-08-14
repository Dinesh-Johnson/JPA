package com.xworkz.album.repo;

import com.xworkz.album.entity.AlbumEntity;

import java.util.List;

public interface AlbumRepo {

    boolean save(AlbumEntity entity);

    List<AlbumEntity> getAllAlbum();

    AlbumEntity fetchDataByID(Integer id);
}
