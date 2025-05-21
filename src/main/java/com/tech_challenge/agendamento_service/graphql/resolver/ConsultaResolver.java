package com.tech_challenge.agendamento_service.graphql.resolver;

import com.tech_challenge.agendamento_service.model.Consulta;
import com.tech_challenge.agendamento_service.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ConsultaResolver {

    @Autowired
    private ConsultaService consultaService;

    @MutationMapping
    public Consulta criarConsulta(Long pacienteId, Long medicoId, String dataHora, String observacoes) {
        return consultaService.criarConsulta(pacienteId, medicoId, dataHora, observacoes);
    }

    @MutationMapping
    public Consulta editarConsulta(Long id, String dataHora, String observacoes, String status) {
        return consultaService.editarConsulta(id, dataHora, observacoes, status);
    }

    @QueryMapping
    public List<Consulta> consultasPorPaciente(Long pacienteId) {
        return consultaService.consultasPorPaciente(pacienteId);
    }

    @QueryMapping
    public List<Consulta> consultasFuturasPorPaciente(Long pacienteId) {
        return consultaService.consultasFuturasPorPaciente(pacienteId);
    }
}