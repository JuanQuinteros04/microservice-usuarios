package com.formacionbdi.springboot.app.usuarios.persistence;

import com.formacionbdi.springboot.app.usuarios.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
