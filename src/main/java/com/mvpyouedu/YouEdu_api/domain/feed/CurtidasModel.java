package com.mvpyouedu.YouEdu_api.domain.feed;

import com.mvpyouedu.YouEdu_api.domain.videos.VideoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "Curtidas")
@Entity(name = "curtida")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CurtidasModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "video_id",nullable = false)
    private VideoEntity videoId;

    private Long curtidas;
}
