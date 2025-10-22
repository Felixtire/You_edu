package com.mvpyouedu.YouEdu_api.controller.usuario;


import com.mvpyouedu.YouEdu_api.domain.dto.login.DadoAtualizadosUsuario;
import com.mvpyouedu.YouEdu_api.domain.dto.cadastro.DadosAtualizarUsuario;
import com.mvpyouedu.YouEdu_api.domain.dto.cadastro.DadosSaidaCadastroUsuario;
import com.mvpyouedu.YouEdu_api.domain.dto.cadastro.DadosCadastroUsuario;
import com.mvpyouedu.YouEdu_api.service.user.CadastroService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastrar")
public class CadastroController {

    @Autowired
    private CadastroService service;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder){

        var usuario = service.cadastrar(dados);

        var uri= uriComponentsBuilder.path("cadastrar/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosSaidaCadastroUsuario(usuario));

    }

    @GetMapping("/listar")
    public ResponseEntity listar(){ //Fazer paginação depois

        var listaUsers = service.listarUsuario();

        return ResponseEntity.ok().body(listaUsers);
    }


    @PutMapping("/atualizar")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarUsuario dados){

        var usuarioAtualizado = service.atualizarCadastro(dados);

        return ResponseEntity.ok().body(new DadoAtualizadosUsuario(usuarioAtualizado));

    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity deletarConta(@PathVariable Long id){
        service.deletarCadastro(id);

        return ResponseEntity.noContent().build();
    }





}
