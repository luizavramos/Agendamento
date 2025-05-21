package com.tech_challenge.agendamento_service.service;

import com.tech_challenge.agendamento_service.model.Consulta;
import com.tech_challenge.agendamento_service.model.Usuario;
import com.tech_challenge.agendamento_service.repository.ConsultaRepository;
import com.tech_challenge.agendamento_service.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Consulta criarConsulta(Long pacienteId, Long medicoId, String dataHoraStr, String observacoes) {
        Usuario paciente = usuarioRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        Usuario medico = usuarioRepository.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));

        Consulta consulta = Consulta.builder()
                .paciente(paciente)
                .medico(medico)
                .dataHora(LocalDateTime.parse(dataHoraStr))
                .observacoes(observacoes)
                .status("AGENDADA")
                .criadoEm(LocalDateTime.now())
                .build();

        return consultaRepository.save(consulta);
    }

    public Consulta editarConsulta(Long id, String dataHoraStr, String observacoes, String status) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        if (dataHoraStr != null) {
            consulta.setDataHora(LocalDateTime.parse(dataHoraStr));
        }
        if (observacoes != null) {
            consulta.setObservacoes(observacoes);
        }
        if (status != null) {
            consulta.setStatus(status);
        }

        return consultaRepository.save(consulta);
    }

    public List<Consulta> consultasPorPaciente(Long pacienteId) {
        return consultaRepository.findByPacienteId(pacienteId);
    }

    public List<Consulta> consultasFuturasPorPaciente(Long pacienteId) {
        LocalDateTime agora = LocalDateTime.now();
        return consultaRepository.findByPacienteIdAndDataHoraAfter(pacienteId, agora);
    }
}