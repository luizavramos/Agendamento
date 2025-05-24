package com.tech_challenge.agendamento_service.graphql.resolver;

import com.tech_challenge.agendamento_service.dto.ConsultaInput;
import com.tech_challenge.agendamento_service.model.Consulta;
import com.tech_challenge.agendamento_service.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class ConsultaResolver {

    private final ConsultaService service;
    public ConsultaResolver(ConsultaService service) {
        this.service = service;
    }

    @QueryMapping
    public List<Consulta> consultasPorPaciente(@Argument String pacienteId) {
        return service.buscarPorPaciente(pacienteId);
    }

    @MutationMapping
    public Consulta criarConsulta(@Argument ConsultaInput input) {
        return service.criarConsulta(input);
    }
}