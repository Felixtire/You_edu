package com.mvpyouedu.YouEdu_api.service.user;

import com.mvpyouedu.YouEdu_api.domain.dto.cadastro.DadoParaAlterarSenha;
import com.mvpyouedu.YouEdu_api.domain.usuario.UsuarioEntity;
import com.mvpyouedu.YouEdu_api.infra.security.TokenService;
import com.mvpyouedu.YouEdu_api.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioLogadoService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenService service;
    @Autowired
    private EncoderService encode;

    public String recuperarSenha(String login) {
        var usuario = repository.findByLogin(login)
                .orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado"));

        var idUsuario = usuario.getId();


        var link = "Link para redefinir a senha:\n" + "http://localhost:8080/login/redefinir-senha/"+idUsuario + "\n" + "Esse link é válido por 2 horas.";
        return link;

    }

    public UsuarioEntity alterarSenha(Long id,DadoParaAlterarSenha dado) {

        var usuario = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado"));

        if (dado.senha() !=null && !dado.senha().isBlank()){
           usuario.setSenha(encode.encoder(usuario.getSenha()));
        }

        return repository.save(usuario);

    }
}
