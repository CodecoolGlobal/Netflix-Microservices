package com.tutorial.movieinfoservice.models;

import java.util.List;

public class VideoRecommendations {
    private List<Recommendation> recommendations;

    public VideoRecommendations() {
    }

    public VideoRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }
}
