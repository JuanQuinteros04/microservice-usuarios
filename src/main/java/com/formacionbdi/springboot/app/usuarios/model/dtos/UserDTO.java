package com.formacionbdi.springboot.app.usuarios.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private String username;
    private String password;
    private String name;
    private String lastName;
    private String email;

}
