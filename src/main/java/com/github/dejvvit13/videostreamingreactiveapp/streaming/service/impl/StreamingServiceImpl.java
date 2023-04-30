package com.github.dejvvit13.videostreamingreactiveapp.streaming.service.impl;

import com.github.dejvvit13.videostreamingreactiveapp.configuration.files.VideoStoreLocation;
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
        return resourceLoader.getResource(String.format(VideoStoreLocation.FORMAT, uuid));
    }
}
