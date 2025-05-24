package com.tech_challenge.agendamento_service.repository;

import com.tech_challenge.agendamento_service.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, String> {
    List<Consulta> findByPacienteId(String pacienteId);
}

