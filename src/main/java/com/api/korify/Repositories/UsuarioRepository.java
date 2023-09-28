package com.api.korify.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.korify.Entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
    public Optional<UsuarioEntity> findByEmail(String email);
}
