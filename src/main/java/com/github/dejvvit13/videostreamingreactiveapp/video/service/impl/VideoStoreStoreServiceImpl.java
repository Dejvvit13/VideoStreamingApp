package com.github.dejvvit13.videostreamingreactiveapp.video.service.impl;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoCreateDto;
import com.github.dejvvit13.videostreamingreactiveapp.video.repository.VideoRepository;
import com.github.dejvvit13.videostreamingreactiveapp.video.service.VideoStoreService;
import lombok.RequiredArgsConstructor;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoStoreStoreServiceImpl implements VideoStoreService {

    private final VideoRepository videoRepository;
    private final String videoDirectory = "src/main/resources/videos/";


    @Override
    public String saveVideo(final VideoCreateDto videoCreateDto) {
        String uuid = UUID.randomUUID().toString();
        storeVideoFile(videoCreateDto.file(), uuid);
        storeVideoFrame(uuid);
        videoRepository.save(videoCreateDto.toVideo(uuid));
        return uuid;
    }

    private void storeVideoFrame(final String uuid) {
        FFmpegFrameGrabber g = new FFmpegFrameGrabber(videoDirectory + uuid + "/" + uuid + ".mp4");
        try {
            g.start();
            Java2DFrameConverter converter = new Java2DFrameConverter();
            Frame frame = g.grabImage();
            BufferedImage bi = converter.convert(frame);
            ImageIO.write(bi, "png", new File(videoDirectory + uuid + "/" + uuid + ".png"));
            g.stop();
        } catch (FrameGrabber.Exception | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void storeVideoFile(final MultipartFile file, final String uuid) {
        byte[] bytes;
        try {
            bytes = file.getBytes();
            createAndStoreFile(uuid, bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createAndStoreFile(final String uuid, final byte[] bytes) throws IOException {
        if (createDirectory(uuid)) {
            Path path = Paths.get(videoDirectory + uuid + "/" + uuid + ".mp4");
            Files.write(path, bytes);
        }
    }

    private boolean createDirectory(String uuid) {
        try {
            Files.createDirectories(Paths.get(videoDirectory + uuid));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
