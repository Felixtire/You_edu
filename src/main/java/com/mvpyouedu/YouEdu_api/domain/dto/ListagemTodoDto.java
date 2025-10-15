package com.mvpyouedu.YouEdu_api.domain.dto;

import com.mvpyouedu.YouEdu_api.domain.usuario.UsuarioEntity;

public record ListagemTodoDto(String nome, String login) {

    public ListagemTodoDto(UsuarioEntity usuario) {
        this(usuario.getNome(), usuario.getLogin());
    }
}
