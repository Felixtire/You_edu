package com.mvpyouedu.YouEdu_api.domain.dto.videos;

import com.mvpyouedu.YouEdu_api.domain.enuns.Categoria;

public record DadodParaUpload(Categoria categoria, String titulo, String descricao) {
}
