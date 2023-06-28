package com.formacionbdi.springboot.app.usuarios.persistence;

import com.formacionbdi.springboot.app.usuarios.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
