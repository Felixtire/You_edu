package com.mvpyouedu.YouEdu_api.controller.authUser;


import com.mvpyouedu.YouEdu_api.domain.dto.DadodParaUpload;
import com.mvpyouedu.YouEdu_api.service.UploadService;
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


    @PostMapping("/upload")
    @Transactional
    public ResponseEntity publicarVideo(@RequestParam("file") MultipartFile file, @RequestBody @Valid DadodParaUpload dadosUpload){



        String respostaUpload = uploadService.uploadFile(file);

        return ResponseEntity.ok(respostaUpload);





    }

}
