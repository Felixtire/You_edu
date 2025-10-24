package com.mvpyouedu.YouEdu_api.service.video;

import com.mvpyouedu.YouEdu_api.domain.dto.videos.DadosParaUpload;
import com.mvpyouedu.YouEdu_api.domain.enuns.Categoria;
import com.mvpyouedu.YouEdu_api.domain.videos.VideoEntity;
import com.mvpyouedu.YouEdu_api.repository.VideoRepository;
import jakarta.persistence.ManyToOne;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FileUploadTest {


    @Mock
    private VideoRepository videoRepository;

    @Mock
    private Categoria categoria;

    @Mock
    private UploadService service;

    @Mock
    private DadosParaUpload dadosParaUpload;

    @Mock
    private MultipartFile file;

    @InjectMocks
   private FileUpload fileUpload;

    @Test
    void deveriaSalvarVideo(){
        //Arrange
        when(dadosParaUpload.file()).thenReturn(file);
        when(dadosParaUpload.titulo()).thenReturn("Meu Titulo");
        when(dadosParaUpload.descricao()).thenReturn("Video mock");
        when(dadosParaUpload.categoria()).thenReturn(Categoria.ESPORTE);
        when(service.uploadFile(file)).thenReturn("/uploads/video.mp4");

        when(videoRepository.save(any(VideoEntity.class))).thenAnswer(invocation->invocation.getArgument(0));

        VideoEntity saved = fileUpload.saveVideo(dadosParaUpload);


        assertEquals("Meu Titulo",saved.getTitulo());
        assertEquals("Video mock",saved.getDescricao());
        assertEquals(Categoria.ESPORTE,saved.getCategoria());
        assertEquals("/uploads/video.mp4",saved.getUrl());

        verify(service,times(1)).uploadFile(file);
        ArgumentCaptor<VideoEntity> captor = ArgumentCaptor.forClass(VideoEntity.class);
        verify(videoRepository,times(1)).save(captor.capture());
        VideoEntity persisted = captor.getValue();
        assertEquals("Meu Titulo",persisted.getTitulo());
        assertEquals("/uploads/video.mp4",persisted.getUrl());



    }








}