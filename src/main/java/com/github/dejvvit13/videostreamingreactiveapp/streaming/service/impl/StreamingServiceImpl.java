package com.github.dejvvit13.videostreamingreactiveapp.streaming.service.impl;

import com.github.dejvvit13.videostreamingreactiveapp.streaming.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StreamingServiceImpl implements StreamingService {


    private final ResourceLoader resourceLoader;

    public Resource getVideo(final String uuid) {
        return resourceLoader.getResource(String.format("classpath:videos/%s/%s.mp4", uuid, uuid));
    }
    public Resource getImage(final String uuid) {
        return resourceLoader.getResource(String.format("classpath:videos/%s/%s.png", uuid, uuid));
    }
}
