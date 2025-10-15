package com.mvpyouedu.YouEdu_api.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record DadoParaAlterarSenha(
        @NotBlank
        String senha) {
}
