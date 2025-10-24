package com.mvpyouedu.YouEdu_api.service.video;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UploadServiceTest {

    @Mock
    private MultipartFile multipartFile;

    @Mock
    private File file ;

    @InjectMocks
    private UploadService service;

    @Test
    @DisplayName("DEVE RETORNAR UMA STRING COM O CAMINHO DO VIDEO")
    void cenario1(){

        when(multipartFile.getOriginalFilename()).thenReturn("video.mp4");

        String resultado = service.uploadFile(multipartFile);

        assertTrue(resultado.contains("/home/dev/uploads/video.mp4"));

    }





}