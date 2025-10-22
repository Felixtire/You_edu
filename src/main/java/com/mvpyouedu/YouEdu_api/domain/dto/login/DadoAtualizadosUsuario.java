package com.mvpyouedu.YouEdu_api.domain.dto.login;

import com.mvpyouedu.YouEdu_api.domain.usuario.UsuarioEntity;

public record DadoAtualizadosUsuario(String nome, String login , String senha) {

    public DadoAtualizadosUsuario(UsuarioEntity usuario){
        this(usuario.getNome(),usuario.getLogin(),usuario.getSenha());
    }

}
