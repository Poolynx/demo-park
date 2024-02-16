package com.wesleyRabelo.demoparkapi.repository;

import com.wesleyRabelo.demoparkapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
