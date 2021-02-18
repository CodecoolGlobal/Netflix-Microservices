package com.tutorial.moviecatalogservice.models;

public class Recommendation {

    private int id;
    private int rating;
    private String comment;
    private int videoId;

    public Recommendation() {
    }

    public Recommendation(int id, int rating, String comment, int videoId) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.videoId = videoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }
}
