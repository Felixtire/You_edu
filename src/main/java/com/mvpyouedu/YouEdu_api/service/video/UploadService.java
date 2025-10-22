package com.mvpyouedu.YouEdu_api.service.video;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadService {

    private static final String UPLOAD_DIR = "/home/dev/uploads/";

    public String uploadFile(MultipartFile file) {

        String caminhoArquivo;
        try {
            File pasta = new File(UPLOAD_DIR);
            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            caminhoArquivo = UPLOAD_DIR + file.getOriginalFilename();

            file.transferTo(new File(caminhoArquivo));

        } catch (IOException e) {
            return "Erro ao fazer upload do arquivo: " + e.getMessage();
        }

        return "Caminho do arquivo: " + caminhoArquivo;
    }
}
