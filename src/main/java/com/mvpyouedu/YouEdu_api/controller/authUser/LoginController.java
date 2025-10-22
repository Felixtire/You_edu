package com.mvpyouedu.YouEdu_api.controller.authUser;

import com.mvpyouedu.YouEdu_api.domain.dto.cadastro.DadoParaAlterarSenha;
import com.mvpyouedu.YouEdu_api.domain.dto.login.DadoParaRecuperarSenha;
import com.mvpyouedu.YouEdu_api.domain.dto.login.DadosLogin;
import com.mvpyouedu.YouEdu_api.infra.security.TokenService;
import com.mvpyouedu.YouEdu_api.domain.dto.security.TokenAuthenticationJwt;
import com.mvpyouedu.YouEdu_api.repository.UsuarioRepository;
import com.mvpyouedu.YouEdu_api.service.user.UsuarioLogadoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
  private UsuarioLogadoService service;


    @PostMapping
    @Transactional
    public ResponseEntity logar(@RequestBody @Valid DadosLogin dados) {

        var usuario = usuarioRepository.findByLogin(dados.login())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var tokenJwt = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new TokenAuthenticationJwt(tokenJwt));
    }
    @PostMapping("/recuperar-senha")
    public ResponseEntity recuperarSenha(@RequestBody DadoParaRecuperarSenha dados){

        var token = service.recuperarSenha(dados.login());

        return ResponseEntity.ok().body(token);

    }

    @PutMapping("/redefinir-senha/{id}")
    @Transactional
    public ResponseEntity redefinirSenha( @PathVariable Long id, @RequestBody @Valid DadoParaAlterarSenha dado){
        service.alterarSenha(id,dado);
        return ResponseEntity.ok().body("Senha alterada com sucesso");
    }

}
