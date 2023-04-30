package com.github.dejvvit13.videostreamingreactiveapp.video.service;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoCreateDto;

public interface VideoService {

    String saveVideo(VideoCreateDto videoCreateDto);
}
