package com.github.dejvvit13.videostreamingreactiveapp.streaming.controller;

import com.github.dejvvit13.videostreamingreactiveapp.streaming.service.impl.StreamingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/video")
public class StreamingController {

    private final StreamingServiceImpl streamingServiceImpl;

    @GetMapping(value = "/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader String range){
        return streamingServiceImpl.getVideo(title, range);
    }


}
