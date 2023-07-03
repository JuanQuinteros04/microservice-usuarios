package com.formacionbdi.springboot.app.usuarios.service;

import com.formacionbdi.springboot.app.commons.usuarios.model.entity.Usuario;
import com.formacionbdi.springboot.app.usuarios.persistence.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    @Override
    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        usuarioRepository.delete(usuario);
    }
}
