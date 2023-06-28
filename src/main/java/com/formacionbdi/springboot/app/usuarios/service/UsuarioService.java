package com.formacionbdi.springboot.app.usuarios.service;

import com.formacionbdi.springboot.app.usuarios.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(Long id);


}