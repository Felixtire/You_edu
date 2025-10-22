package com.mvpyouedu.YouEdu_api.domain.dto.cadastro;

import com.mvpyouedu.YouEdu_api.domain.enuns.TipoUsuario;
import com.mvpyouedu.YouEdu_api.domain.usuario.UsuarioEntity;

public record DadosSaidaCadastroUsuario(String nome, String email, TipoUsuario tipoUsuario) {

    public DadosSaidaCadastroUsuario(UsuarioEntity usuario) {
        this(usuario.getNome(), usuario.getLogin(),usuario.getTipo());
    }
}
