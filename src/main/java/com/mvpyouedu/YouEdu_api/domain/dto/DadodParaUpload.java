package com.mvpyouedu.YouEdu_api.domain.dto;

import com.mvpyouedu.YouEdu_api.domain.videos.Categoria;

public record DadodParaUpload(Categoria categoria, String titulo, String descricao) {
}
