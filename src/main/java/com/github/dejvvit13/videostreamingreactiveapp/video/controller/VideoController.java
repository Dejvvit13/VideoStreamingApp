package com.github.dejvvit13.videostreamingreactiveapp.video.controller;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoCreateDto;
import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoResponse;
import com.github.dejvvit13.videostreamingreactiveapp.video.service.VideoService;
import com.github.dejvvit13.videostreamingreactiveapp.video.service.VideoStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/videos")
@RestController
public class VideoController {

    private final VideoStoreService videoStoreService;
    private final VideoService videoService;


    @GetMapping
    public VideoResponse getVideos() {
        return videoService.getVideos();
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String saveVideo(@ModelAttribute VideoCreateDto videoCreateDto) {
         return videoStoreService.saveVideo(videoCreateDto);
    }


}
