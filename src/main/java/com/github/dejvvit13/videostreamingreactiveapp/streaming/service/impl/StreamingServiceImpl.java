package com.github.dejvvit13.videostreamingreactiveapp.streaming.service.impl;

import com.github.dejvvit13.videostreamingreactiveapp.configuration.VideoStoreLocation;
import com.github.dejvvit13.videostreamingreactiveapp.streaming.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class StreamingServiceImpl implements StreamingService {


    private final ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(final String title, final String range) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(String.format(VideoStoreLocation.FORMAT, title)));
    }
}
