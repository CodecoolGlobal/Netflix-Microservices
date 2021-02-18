package com.tutorial.moviecatalogservice.resources;

import com.tutorial.moviecatalogservice.models.Recommendation;
import com.tutorial.moviecatalogservice.models.Video;
import com.tutorial.moviecatalogservice.models.VideoRecommendations;
import com.tutorial.moviecatalogservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping
    public List<Video> getVideos(){

        return videoRepository.findAll();

    }

    @GetMapping("/{videoId}")
    public Optional<Video> getVideo(@PathVariable int videoId){

        return videoRepository.findById(videoId);

    }


    @GetMapping("/{videoId}/recommendations")
    public List<Recommendation> getVideoRecommendations(@PathVariable int videoId){

        VideoRecommendations videoRecommendations = restTemplate.getForObject("http://video-recommendation-service/recommendations/videos/" + videoId, VideoRecommendations.class);
        List<Recommendation> recommendations = videoRecommendations.getRecommendations();


        return recommendations;

    }

    @PutMapping("/{videoId}")
    public void updateVideo(@PathVariable int videoId, @RequestBody Video video){

        Optional<Video> updatedVideo = getVideo(videoId);

        updatedVideo.get().setName(video.getName());
        updatedVideo.get().setUrl(video.getUrl());

        addVideo(updatedVideo.get());

    }

    @PutMapping("/{videoId}/recommendations/{id}")
    public void updateVideoRecommendation(@PathVariable String id, @RequestBody Recommendation recommendation){

        restTemplate.put("http://video-recommendation-service/recommendations/" + id, recommendation, Recommendation.class);

    }

    @PostMapping
    public void addVideo(@RequestBody Video video){

        videoRepository.save(video);
    }

    @PostMapping("/{videoId}/addRecommendation")
    public void addVideoRecommendation(@RequestBody Recommendation recommendation, @PathVariable int videoId){

        restTemplate.postForEntity("http://video-recommendation-service/recommendations/videos/" + videoId,recommendation,Recommendation.class);

    }

}
