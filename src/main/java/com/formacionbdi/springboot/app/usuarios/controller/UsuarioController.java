package com.formacionbdi.springboot.app.usuarios.controller;

import com.formacionbdi.springboot.app.commons.usuarios.model.entity.Usuario;
import com.formacionbdi.springboot.app.usuarios.service.UsuarioServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    Logger logger = LoggerFactory.getLogger(UsuarioController .class);


    @GetMapping(value = "/listar")
    public List<Usuario> listar(){
        return usuarioService.findAll();
    }

    @GetMapping("/ver/{id}")
    public Usuario detalle(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return usuario;
    }

    @GetMapping("/username/{username}")
    public Usuario userForName(@PathVariable String username){
        return usuarioService.findByUsername(username);
    }

    @PostMapping("/crear")
    public Usuario crear(@RequestBody Usuario usuario){
        Usuario usuarioDb = usuarioService.createUsuario(usuario);
        return usuarioService.save(usuarioDb);

    }

    @PutMapping("/modificar/{id}")
    public Usuario editar(@RequestBody Usuario usuario, @PathVariable Long id){
        Usuario usuarioDb = usuarioService.findById(id);
        usuarioDb.setNombre(usuario.getNombre());
        usuarioDb.setApellido(usuario.getApellido());
        usuarioDb.setEmail(usuario.getEmail());
        usuarioDb.setUsername(usuario.getUsername());
        usuarioDb.setPassword(usuario.getPassword());
        usuarioDb.setRoles(usuario.getRoles());
        usuarioDb.setEnabled(usuario.getEnabled());
        usuarioService.save(usuarioDb);
        return usuarioDb;
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
    }

}
