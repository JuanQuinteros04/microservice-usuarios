package com.formacionbdi.springboot.app.usuarios.model.dtos;

import com.formacionbdi.springboot.app.usuarios.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponse extends UserDTO{
    private Long id;
    private List<Role> roles;
}
