package com.tech_challenge.agendamento_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConsultaDTO {
    private Long id;
    private LocalDateTime dataHora;
    private String observacoes;
    private String status;
    private LocalDateTime criadoEm;
}
