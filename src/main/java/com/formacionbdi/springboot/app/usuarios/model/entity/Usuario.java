package com.formacionbdi.springboot.app.usuarios.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 60)
    private String password;

    private Boolean enabled;
    private String nombre;
    private String apellido;

    @Column(unique = true, length = 100)
    private String email;
}
