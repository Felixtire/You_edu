package com.mvpyouedu.YouEdu_api.domain.dto.videos;

import com.mvpyouedu.YouEdu_api.domain.enuns.Categoria;
import org.springframework.web.multipart.MultipartFile;

public record DadosParaUpload(Categoria categoria, String titulo, String descricao , MultipartFile file) {

}
