package com.formacionbdi.springboot.app.usuarios.controller;

import com.formacionbdi.springboot.app.usuarios.model.User;
import com.formacionbdi.springboot.app.usuarios.model.dtos.UserRegister;
import com.formacionbdi.springboot.app.usuarios.model.dtos.UserResponse;
import com.formacionbdi.springboot.app.usuarios.service.UserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UsuarioController {

    @Autowired
    private UserService userService;

//    Logger logger = LoggerFactory.getLogger(UsuarioController .class);


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponse>> getUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> create(@RequestBody UserRegister userRegister){
        UserResponse user1 = userService.createUser(userRegister);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user1.getId())
                .toUri();

        return ResponseEntity.created(location).body(user1);

    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> changeState(@RequestBody User user,
                                            @PathVariable("id") Long id){

        return ResponseEntity.ok(userService.changeState(user, id));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){

        userService.deleteUser(id);
        return ResponseEntity.status(204).build();
    }

}
