package com.mvpyouedu.YouEdu_api.repository;

import com.mvpyouedu.YouEdu_api.domain.usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByLogin(String login);

    void deleteByLogin(String login);
}
