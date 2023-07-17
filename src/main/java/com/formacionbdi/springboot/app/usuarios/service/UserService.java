package com.formacionbdi.springboot.app.usuarios.service;

import com.formacionbdi.springboot.app.usuarios.model.User;
import com.formacionbdi.springboot.app.usuarios.model.dtos.UserRegister;
import com.formacionbdi.springboot.app.usuarios.model.dtos.UserResponse;

import java.util.List;

public interface UserService {

    List<UserResponse> findAll();
    UserResponse findById(Long id);
    User findByUsername(String username);
    UserResponse createUser(UserRegister userRegister);

    User changeState(User user, Long id);

    void deleteUser(Long id);


}
