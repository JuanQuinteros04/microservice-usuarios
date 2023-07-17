package com.formacionbdi.springboot.app.usuarios.service;

import com.formacionbdi.springboot.app.usuarios.exception.NotFoundException;
import com.formacionbdi.springboot.app.usuarios.model.Role;
import com.formacionbdi.springboot.app.usuarios.model.User;
import com.formacionbdi.springboot.app.usuarios.model.dtos.UserRegister;
import com.formacionbdi.springboot.app.usuarios.model.dtos.UserResponse;
import com.formacionbdi.springboot.app.usuarios.model.mappers.UserMapper;
import com.formacionbdi.springboot.app.usuarios.persistence.RoleRepository;
import com.formacionbdi.springboot.app.usuarios.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream().map(user -> userMapper.userToUserResponse(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(Long id) {
        return userMapper.userToUserResponse(userRepository.findById(id)
                .orElseThrow(NotFoundException::new));
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findUserByUsername(username).orElseThrow(NotFoundException::new);
    }

    @Override
    public UserResponse createUser(UserRegister userRegister) {

        User user = userMapper.userRegisterToUser(userRegister);
        user.setPassword(passwordEncoder.encode(userRegister.getPassword()));
        user.setIsEnabled(true);

        Optional<Role> role = roleRepository.findById(1L);
        role.ifPresent(value -> user.setRoles(List.of(value)));
        userRepository.save(user);

        return userMapper.userToUserResponse(user);
    }

    @Override
    public User changeState(User user, Long id) {
        User user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found"));
        user1.setIntents(user.getIntents());
        user1.setIsEnabled(user.getIsEnabled());

        userRepository.save(user1);

        return user1;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found"));
        userRepository.delete(user);
    }
}
