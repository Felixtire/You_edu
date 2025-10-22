package com.mvpyouedu.YouEdu_api.repository;

import com.mvpyouedu.YouEdu_api.domain.videos.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoEntity,Long> {
}
