package com.harman.harman.controller;


import com.harman.harman.model.VideoDetail;
import com.harman.harman.service.VideoDetailService;
import com.harman.harman.wrapper.EngagementStatsWrapper;
import com.harman.harman.wrapper.VideoDetailWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/video")
public class VideoDetailController {


    @Autowired
    private VideoDetailService videoService;

    @PostMapping
    public ResponseEntity<String> publishVideo(@RequestBody VideoDetail video) {
        videoService.publishVideo(video);
        return ResponseEntity.accepted().body("Video published successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoDetail> updateMetadata(@PathVariable Integer id, @RequestBody VideoDetail video) {
        return ResponseEntity.ok(videoService.updateMetadata(id, video));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delistVideo(@PathVariable Integer id) {
        videoService.delistVideo(id);
        return ResponseEntity.accepted().body("Video delisted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDetail> loadVideo(@PathVariable Integer id) {
        return ResponseEntity.ok(videoService.loadVideo(id));
    }

    @PostMapping("/play/{id}")
    public ResponseEntity<String> playVideo(@PathVariable Integer id) {
        return ResponseEntity.ok(videoService.playVideo(id));
    }

    @GetMapping
    public ResponseEntity<List<VideoDetailWrapper>> listVideos() {
        return ResponseEntity.ok(videoService.listVideos());
    }

    @GetMapping("/search")
    public ResponseEntity<List<VideoDetailWrapper>> searchVideos(  @RequestParam(required = false, name = "directorName") String directorName,
                                                            @RequestParam(required = false, name = "title") String title,
                                                            @RequestParam(required = false, name = "Cast") String Cast,
                                                            @RequestParam(required = false, name = "genre") String genre){
        return ResponseEntity.ok(videoService.searchVideos(directorName, title, Cast, genre));
    }

    @GetMapping("/engagement/{id}")
    public ResponseEntity<EngagementStatsWrapper> getEngagementStats(@PathVariable Integer id) {
        return ResponseEntity.ok(videoService.getEngagementStats(id));
    }
}
