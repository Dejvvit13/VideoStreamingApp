package com.github.dejvvit13.videostreamingreactiveapp.streaming.service;

import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;

public interface StreamingService {

    Mono<Resource> getVideo(final String title);

}
