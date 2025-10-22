package com.mvpyouedu.YouEdu_api.domain.dto.exception;

import org.springframework.validation.FieldError;

public record DadosDetalhamentoErro(String fild, String message) {

    public DadosDetalhamentoErro(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }
}
