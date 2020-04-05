package com.profile.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profile.apirest.model.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

}
