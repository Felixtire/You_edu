package com.mvpyouedu.YouEdu_api.controller.authUser;


import com.mvpyouedu.YouEdu_api.domain.dto.videos.DadosParaUpload;
import com.mvpyouedu.YouEdu_api.service.video.FileUpload;
import com.mvpyouedu.YouEdu_api.service.video.UploadService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/video")
public class PublicarVideoController {

    @Autowired
    private UploadService uploadService;
    @Autowired
    private FileUpload upload;


    @PostMapping("/upload")
    @Transactional
    public ResponseEntity publicarVideo(@ModelAttribute DadosParaUpload dadosParaUpload){

        var video =upload.saveVideo(dadosParaUpload);

        return ResponseEntity.ok("Vídeo adicionado com sucesso");


    }

}
