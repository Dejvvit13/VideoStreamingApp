package com.github.dejvvit13.videostreamingreactiveapp.video.service.impl;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.document.Video;
import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoResponse;
import com.github.dejvvit13.videostreamingreactiveapp.video.repository.VideoRepository;
import com.github.dejvvit13.videostreamingreactiveapp.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;


    public VideoResponse getVideos() {
        return new VideoResponse(videoRepository.findAll().stream().map(Video::toDto).collect(Collectors.toList()));
    }

}
