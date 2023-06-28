package com.formacionbdi.springboot.app.usuarios.controller;

import com.formacionbdi.springboot.app.usuarios.model.entity.Usuario;
import com.formacionbdi.springboot.app.usuarios.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/listar")
    public List<Usuario> listar(){
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario detalle(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return usuario;
    }

    @PutMapping("/crear")
    public Usuario crear(@RequestBody Usuario usuario){
        return usuarioService.createUsuario(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
    }

}
