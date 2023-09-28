package com.api.korify.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.korify.Entities.UsuarioEntity;
import com.api.korify.Repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public UsuarioEntity create(UsuarioEntity usuario){
        return repository.save(usuario);
    }

    public List<UsuarioEntity> findAll(){
        return repository.findAll();
    }

    public Optional<UsuarioEntity> findByEmail(String email){
        return repository.findByEmail(email);
    }

    public boolean verifyEmailExist(String email){
        return findByEmail(email).isPresent();
    }
}