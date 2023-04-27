package com.github.dejvvit13.videostreamingreactiveapp.video.controller;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoCreateDto;
import com.github.dejvvit13.videostreamingreactiveapp.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping("/api/v1/video")
@RestController
public class VideoController {

    private final VideoService videoService;


    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Mono<String> saveVideo(@ModelAttribute VideoCreateDto videoCreateDto) {
         return videoService.saveVideo(videoCreateDto);
    }


}
