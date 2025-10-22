package com.mvpyouedu.YouEdu_api.service.video;

import com.mvpyouedu.YouEdu_api.domain.dto.videos.DadosParaUpload;
import com.mvpyouedu.YouEdu_api.domain.videos.VideoEntity;
import com.mvpyouedu.YouEdu_api.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUpload {

    @Autowired
    private VideoRepository repository;
    @Autowired
    private UploadService service;


    public VideoEntity saveVideo(DadosParaUpload dados){

        MultipartFile file = dados.file();
        var path = service.uploadFile(file);

        var video = new VideoEntity();
        video.setTitulo(dados.titulo());
        video.setDescricao(dados.descricao());
        video.setCategoria(dados.categoria());
        video.setUrl(path);

        return repository.save(video);



    }
}
