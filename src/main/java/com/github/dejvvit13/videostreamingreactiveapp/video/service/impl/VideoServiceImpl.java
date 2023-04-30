package com.github.dejvvit13.videostreamingreactiveapp.video.service.impl;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoCreateDto;
import com.github.dejvvit13.videostreamingreactiveapp.video.repository.VideoRepository;
import com.github.dejvvit13.videostreamingreactiveapp.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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


    @Override
    public String saveVideo(final VideoCreateDto videoCreateDto) {
        String uuid = UUID.randomUUID().toString();
        storeVideoFile(videoCreateDto.file(), uuid);
        videoRepository.save(videoCreateDto.toVideo(uuid));
        return uuid;
    }

    private void storeVideoFile(final MultipartFile file, final String uuid) {
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
            Path path = Paths.get("src/main/resources/videos/" + uuid + ".mp4");
            Files.write(path, bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
