package com.api.korify.Entities;

import java.io.Serializable;

import com.api.korify.Entities.DTOs.UsuarioDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;

    public UsuarioEntity(UsuarioDto usuarioDto){
        this.email = usuarioDto.getEmail();
        this.senha = usuarioDto.getSenha();
    }

    public UsuarioEntity(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

        
}
