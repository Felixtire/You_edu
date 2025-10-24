package com.mvpyouedu.YouEdu_api.service.user;

import com.mvpyouedu.YouEdu_api.domain.dto.cadastro.DadosCadastroUsuario;
import com.mvpyouedu.YouEdu_api.domain.enuns.TipoUsuario;
import com.mvpyouedu.YouEdu_api.domain.usuario.UsuarioEntity;
import com.mvpyouedu.YouEdu_api.repository.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CadastroServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private EncoderService encode;

    @Mock
    private DadosCadastroUsuario dadosCadastroUsuario;

    @InjectMocks
    private CadastroService service;

    @Test
    @DisplayName("Deve cadastrar o usuário com sucesso")
    void deveCadastrarUsuarioComSucesso() {
        // Arrange - configurar mocks
        when(dadosCadastroUsuario.nome()).thenReturn("Wellington");
        when(dadosCadastroUsuario.email()).thenReturn("Warli@gmail.com");
        when(dadosCadastroUsuario.senha()).thenReturn("vasco");
        when(dadosCadastroUsuario.tipo()).thenReturn(TipoUsuario.ALUNO);

        // Configura o EncoderService para "codificar" a senha
        when(encode.encoder("vasco")).thenReturn("HASHED_vasco");

        // Simula o comportamento do repository
        when(usuarioRepository.save(any(UsuarioEntity.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Act - chama o método real
        UsuarioEntity save = service.cadastrar(dadosCadastroUsuario);

        // Assert - verifica os dados retornados
        assertEquals("Wellington", save.getNome());
        assertEquals("Warli@gmail.com", save.getLogin());
        assertEquals("HASHED_vasco", save.getSenha());
        assertEquals(TipoUsuario.ALUNO, save.getTipo());

        // Verifica se o repository foi chamado corretamente
        ArgumentCaptor<UsuarioEntity> captor = ArgumentCaptor.forClass(UsuarioEntity.class);
        verify(usuarioRepository, times(1)).save(captor.capture());
        UsuarioEntity persisted = captor.getValue();
        assertEquals("Wellington", persisted.getNome());
        assertEquals("Warli@gmail.com", persisted.getLogin());
        assertEquals("HASHED_vasco", persisted.getSenha());
        assertEquals(TipoUsuario.ALUNO, persisted.getTipo());

        // Não precisa verificar o método service.cadastrar(), porque ele é real
    }
}
