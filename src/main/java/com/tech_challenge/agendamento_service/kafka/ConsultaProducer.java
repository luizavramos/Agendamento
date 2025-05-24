package com.tech_challenge.agendamento_service.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech_challenge.agendamento_service.model.Consulta;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    private static final String TOPICO = "consulta.eventos";

    public void enviarEventoConsultaCriada(Consulta consulta) {
        try {
            String payload = objectMapper.writeValueAsString(consulta);
            kafkaTemplate.send(TOPICO, payload);
            System.out.println("Consulta enviada para Kafka: " + payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao serializar consulta para Kafka", e);
        }
    }
}