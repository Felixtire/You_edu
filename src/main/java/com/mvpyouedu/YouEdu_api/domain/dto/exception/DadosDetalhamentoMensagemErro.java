package com.mvpyouedu.YouEdu_api.domain.dto.exception;

public record DadosDetalhamentoMensagemErro(String message) {

    public DadosDetalhamentoMensagemErro(Error e){
        this(e.getMessage());
    }
}
