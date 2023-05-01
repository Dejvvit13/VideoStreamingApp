package com.github.dejvvit13.videostreamingreactiveapp.video.model.document;

import com.github.dejvvit13.videostreamingreactiveapp.video.model.dto.VideoDto;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

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
    private String videoUrl;
    private String imageUrl;
    @CreatedDate
    private LocalDateTime createdAt;

    public VideoDto toDto() {
        return new VideoDto(uuid, title, description, videoUrl, imageUrl);
    }

}
