package com.api.korify.Entities.DTOs;

import org.springframework.stereotype.Component;

import com.api.korify.Entities.UsuarioEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Component
public class UsuarioDto {

    private Integer id;

    @Email(regexp = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$", message = "Endereço de email precisa ser válido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    @Min(value = 7, message = "Senha deve ser maior ou igual a 7!")
    @NotNull(message = "A senha é obrigatória")
    private String senha;

    public UsuarioDto(UsuarioEntity entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.senha = entity.getSenha();
    }

    public UsuarioDto(){}

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
