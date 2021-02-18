package com.tutorial.moviecatalogservice.repository;

import com.tutorial.moviecatalogservice.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
}
