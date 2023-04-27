package com.github.dejvvit13.videostreamingreactiveapp.video.service.impl;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.document.Video;
import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoCreateDto;
import com.github.dejvvit13.videostreamingreactiveapp.video.repository.VideoRepository;
import com.github.dejvvit13.videostreamingreactiveapp.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final ResourceLoader resourceLoader;


    public Mono<String> saveVideo(VideoCreateDto videoCreateDto) {
        String uuid = UUID.randomUUID().toString();
        storeVideo(videoCreateDto.file(), uuid);
        return videoRepository.save(videoCreateDto.toVideo(uuid)).map(Video::getUuid);
    }

    private Mono<Void> storeVideo(FilePart file, String uuid) {
        Flux<DataBuffer> dataBufferFlux = file.content();
        Path path = Paths.get("src/main/resources/videos/" + uuid + ".mp4");
        return DataBufferUtils.write(dataBufferFlux, path);
    }
}
