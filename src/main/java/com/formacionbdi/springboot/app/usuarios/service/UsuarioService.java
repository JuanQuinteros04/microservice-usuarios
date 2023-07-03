package com.formacionbdi.springboot.app.usuarios.service;


import com.formacionbdi.springboot.app.commons.usuarios.model.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario findByUsername(String username);
    Usuario save(Usuario usuario);
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(Long id);


}
