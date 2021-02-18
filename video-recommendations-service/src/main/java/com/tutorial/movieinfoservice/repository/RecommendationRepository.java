package com.tutorial.movieinfoservice.repository;

import com.tutorial.movieinfoservice.models.Recommendation;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {

    List<Recommendation> findAllByVideoId(int videoId);

    Optional<Recommendation> findById(int id);
}
