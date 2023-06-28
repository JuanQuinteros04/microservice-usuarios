package com.formacionbdi.springboot.app.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuario extends JpaRepository<Usuario, Long> {

    public Usuario findByUsername(String username);

}
