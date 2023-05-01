package com.github.dejvvit13.videostreamingreactiveapp.video.service;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoCreateDto;

public interface VideoStoreService {

    String saveVideo(VideoCreateDto videoCreateDto);
}
