package com.tech_challenge.agendamento_service.dto;

import java.time.LocalDateTime;
public record ConsultaInput(
        String pacienteId,
        String medicoId,
        LocalDateTime dataHora,
        String observacoes
) {}

