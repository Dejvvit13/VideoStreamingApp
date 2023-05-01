package com.github.dejvvit13.videostreamingreactiveapp.video.repository;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.document.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video,String> {




}
