package com.tutorial.movieinfoservice.resources;

import com.tutorial.movieinfoservice.models.Recommendation;
import com.tutorial.movieinfoservice.models.VideoRecommendations;
import com.tutorial.movieinfoservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private VideoRecommendations videoRecommendations;

    @GetMapping("/videos/{videoId}")
    public VideoRecommendations getVideoRecommendations(@PathVariable int videoId){

        // get all recommendations by video id
        List<Recommendation> recommendations = recommendationRepository.findAllByVideoId(videoId);

        // set video recommendations
        videoRecommendations.setRecommendations(recommendations);

        // return VideoRecommendations object
        return videoRecommendations;

    }

    @PutMapping("/{id}")
    public void updateRecommendation(@PathVariable int id, @RequestBody Recommendation recommendation) {

        System.out.println("Test");
        Optional<Recommendation> updatedRecommendation = recommendationRepository.findById(id);

        updatedRecommendation.get().setVideoId(recommendation.getVideoId());
        updatedRecommendation.get().setRating(recommendation.getRating());
        updatedRecommendation.get().setComment(recommendation.getComment());

        addRecommendation(updatedRecommendation.get(), updatedRecommendation.get().getVideoId());

    }

    @PostMapping("/videos/{videoId}")
    public void addRecommendation(@RequestBody Recommendation recommendation, @PathVariable int videoId) {

        recommendation.setVideoId(videoId);
        recommendationRepository.save(recommendation);

    }

}
