package com.mvpyouedu.YouEdu_api.infra.exception;

import com.mvpyouedu.YouEdu_api.domain.dto.exception.DadosDetalhamentoErro;
import com.mvpyouedu.YouEdu_api.domain.dto.exception.DadosDetalhamentoMensagemErro;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(EntityNotFoundException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException ex){
        var erro = ex.getFieldErrors();

        return ResponseEntity.badRequest().body((erro.stream().map(
                DadosDetalhamentoErro::new
        ).toList()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity error500(NullPointerException ex){
        var error = ex.getMessage();
        return ResponseEntity.internalServerError().body(new DadosDetalhamentoMensagemErro(error));
    }
}
