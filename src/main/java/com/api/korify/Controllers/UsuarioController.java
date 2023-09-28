package com.api.korify.Controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.korify.Entities.UsuarioEntity;
import com.api.korify.Entities.DTOs.UsuarioDto;
import com.api.korify.Services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UsuarioController {
    
    final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @GetMapping("/{email}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "email") String email){
        Optional<UsuarioEntity> usuario = service.findByEmail(email);
        if(usuario.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body(usuario.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado com este Email: " + email);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Valid UsuarioDto dto, BindingResult br){
        if(br.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(br.getFieldError().getDefaultMessage());
        }
        if(service.verifyEmailExist(dto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já cadastrado!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(new UsuarioEntity(dto)));
    }
}
