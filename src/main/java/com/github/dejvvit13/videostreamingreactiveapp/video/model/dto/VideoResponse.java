package com.github.dejvvit13.videostreamingreactiveapp.video.model.dto;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.document.Video;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public record VideoResponse(List<VideoDto> content) {
    public static VideoResponse createResponse(Page<Video> videos) {
        VideoResponse videoResponse = new VideoResponse(List.of());
        videos.stream().map(Video::toDto).collect(Collectors.toCollection(() -> videoResponse.content));
        return videoResponse;
    }

}
