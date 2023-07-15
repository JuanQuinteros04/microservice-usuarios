package com.formacionbdi.springboot.app.usuarios.model.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegister {

    @NotBlank(message = "username must not be null")
    private String username;

    @NotBlank(message = "name must not be null")
    private String name;

    private String lastName;

    @Email(message = "must be an valid email")
    private String email;

    private String password;
}
