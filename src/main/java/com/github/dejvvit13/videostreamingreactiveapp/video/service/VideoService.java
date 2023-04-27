package com.github.dejvvit13.videostreamingreactiveapp.video.service;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoCreateDto;
import reactor.core.publisher.Mono;

public interface VideoService {

    Mono<String> saveVideo(VideoCreateDto videoCreateDto);
}
