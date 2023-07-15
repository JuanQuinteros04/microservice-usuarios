package com.formacionbdi.springboot.app.usuarios.controller;

import com.formacionbdi.springboot.app.commons.usuarios.model.entity.Usuario;
import com.formacionbdi.springboot.app.usuarios.service.UsuarioServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    Logger logger = LoggerFactory.getLogger(UsuarioController .class);


    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> detalle(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping("/{username}")
    public ResponseEntity<Usuario> userForName(@PathVariable String username){
        return ResponseEntity.ok(usuarioService.findByUsername(username));
    }

    @PostMapping
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
