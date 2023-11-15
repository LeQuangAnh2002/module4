package com.example.repository;

import com.example.model.Image;

public interface ImageRepository extends Repository<Image>{
    void updateLike(int id);
}
