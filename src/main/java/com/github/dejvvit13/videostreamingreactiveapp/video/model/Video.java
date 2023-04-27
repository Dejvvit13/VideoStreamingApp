package com.github.dejvvit13.videostreamingreactiveapp.video.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@EqualsAndHashCode
public class Video {

    private @Id String id;
    private String title;
    private String description;

}
