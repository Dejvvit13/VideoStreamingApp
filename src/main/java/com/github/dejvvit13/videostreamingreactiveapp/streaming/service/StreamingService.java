package com.github.dejvvit13.videostreamingreactiveapp.streaming.service;

import org.springframework.core.io.Resource;

public interface StreamingService {

    Resource getVideo(final String title);

}
