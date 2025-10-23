package com.mvpyouedu.YouEdu_api.repository;

import com.mvpyouedu.YouEdu_api.domain.feed.CurtidasModel;
import com.mvpyouedu.YouEdu_api.domain.videos.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurtidasRepository extends JpaRepository<CurtidasModel, VideoEntity> {
    Optional<CurtidasModel> findByVideoId(VideoEntity videoId);
}
