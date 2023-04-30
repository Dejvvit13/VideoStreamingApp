package com.github.dejvvit13.videostreamingreactiveapp.video.model.document;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Video {

    private @Id String uuid;
    private String title;
    private String description;
    private String url;

    public VideoDto toDto() {
        return new VideoDto(uuid, title, description, url);
    }

}
