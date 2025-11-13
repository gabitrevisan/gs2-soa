package com.fiap.ergomind.api.repository;

import com.fiap.ergomind.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}