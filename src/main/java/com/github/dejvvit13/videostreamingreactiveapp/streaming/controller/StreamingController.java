package com.github.dejvvit13.videostreamingreactiveapp.streaming.controller;

import com.github.dejvvit13.videostreamingreactiveapp.streaming.service.impl.StreamingServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/video")
@Slf4j
public class StreamingController {

    private final StreamingServiceImpl streamingServiceImpl;

    @GetMapping(value = "/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range){
        System.out.println("range: " + range);
        return streamingServiceImpl.getVideo(title, range);
    }


}
