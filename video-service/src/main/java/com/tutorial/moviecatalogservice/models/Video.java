package com.tutorial.moviecatalogservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Video {

    @Id
    @GeneratedValue
    private int videoId;
    private String name;
    private String url;

    public Video() {
    }

    public Video(int videoId, String name, String url) {
        this.videoId = videoId;
        this.name = name;
        this.url = url;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
