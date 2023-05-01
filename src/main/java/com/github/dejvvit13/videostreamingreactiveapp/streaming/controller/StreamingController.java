package com.github.dejvvit13.videostreamingreactiveapp.streaming.controller;

import com.github.dejvvit13.videostreamingreactiveapp.streaming.service.impl.StreamingServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/streaming")
@Slf4j
public class StreamingController {

    private final StreamingServiceImpl streamingServiceImpl;

    @GetMapping(value = "/videos/{uuid}", produces = "video/mp4")
    public Resource getVideo(@PathVariable String uuid, @RequestHeader(value = "Range",required =false) String range){
        System.out.println("range: " + range);
        return streamingServiceImpl.getVideo(uuid);
    }
    @GetMapping(value = "/images/{uuid}", produces = "image/png")
    public Resource getImage(@PathVariable String uuid){
        return streamingServiceImpl.getImage(uuid);
    }


}
