package com.tech_challenge.agendamento_service.repository;

import com.tech_challenge.agendamento_service.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
