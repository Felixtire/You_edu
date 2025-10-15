package com.mvpyouedu.YouEdu_api.domain.dto;

import com.mvpyouedu.YouEdu_api.domain.usuario.UsuarioEntity;

public record DadoAtualizadosUsuario(String nome, String login , String senha) {

    public DadoAtualizadosUsuario(UsuarioEntity usuario){
        this(usuario.getNome(),usuario.getLogin(),usuario.getSenha());
    }

}
