package com.mvpyouedu.YouEdu_api.controller.feed;

import com.mvpyouedu.YouEdu_api.domain.feed.FeedService;
import com.mvpyouedu.YouEdu_api.domain.videos.VideoEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed")
public class FeedController {
    @Autowired
    private FeedService feed;

    @GetMapping
    public ResponseEntity<List<VideoEntity>> feed(){

        return ResponseEntity.ok().body(feed.listarVideos());

    }
    @PostMapping("/curtir/{id}")
    @Transactional
    public ResponseEntity curtirVideo(@PathVariable Long id){

        feed.curtirVideo(id);

        return ResponseEntity.ok("Vídeo curtido com sucesso");

    }
}
