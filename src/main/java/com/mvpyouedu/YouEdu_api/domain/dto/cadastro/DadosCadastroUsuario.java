package com.mvpyouedu.YouEdu_api.domain.dto.cadastro;

import com.mvpyouedu.YouEdu_api.domain.enuns.TipoUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(

        @NotNull
        TipoUsuario tipo,

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String senha




) {
}
