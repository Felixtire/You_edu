package com.mvpyouedu.YouEdu_api.domain.feed;

import com.mvpyouedu.YouEdu_api.domain.videos.VideoEntity;
import com.mvpyouedu.YouEdu_api.repository.CurtidasRepository;
import com.mvpyouedu.YouEdu_api.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FeedService {

    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private CurtidasRepository curtidasRepository;


    public List<VideoEntity> listarVideos() {
        return videoRepository.findAll();
    }


    public Long curtirVideo(Long id) {
        // Verifica se o vídeo existe
        var video = videoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vídeo não existe"));

        // Procura se já existe curtida para esse vídeo
        var curtida = curtidasRepository.findByVideoId(video)
                .orElseGet(() -> {
                    var nova = new CurtidasModel();
                    nova.setVideoId(video);
                    nova.setCurtidas(0L); // começa com zero
                    return nova;
                });

        // Incrementa curtida
        curtida.setCurtidas(curtida.getCurtidas() + 1);

        // Salva no banco
        curtidasRepository.save(curtida);

        return curtida.getCurtidas();
    }


}
