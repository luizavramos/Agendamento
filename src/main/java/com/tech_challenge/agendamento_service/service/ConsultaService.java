package com.tech_challenge.agendamento_service.service;

import com.tech_challenge.agendamento_service.dto.ConsultaInput;
import com.tech_challenge.agendamento_service.kafka.ConsultaProducer;
import com.tech_challenge.agendamento_service.model.Consulta;
import com.tech_challenge.agendamento_service.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository repository;
    private final ConsultaProducer kafkaProducer;

    public Consulta criarConsulta(ConsultaInput input) {
        Consulta consulta = Consulta.builder()
                .pacienteId(input.pacienteId())
                .medicoId(input.medicoId())
                .dataHora(input.dataHora())
                .observacoes(input.observacoes())
                .build();

        Consulta salva = repository.save(consulta);

        kafkaProducer.enviarEventoConsultaCriada(salva);
        return salva;
    }

    public List<Consulta> buscarPorPaciente(String pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

}