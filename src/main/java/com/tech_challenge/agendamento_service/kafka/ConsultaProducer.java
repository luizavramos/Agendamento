package com.tech_challenge.agendamento_service.kafka;

import com.tech_challenge.agendamento_service.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConsultaProducer {

    private static final String TOPIC = "consultas";

    @Autowired
    private KafkaTemplate<String, Consulta> kafkaTemplate;

    public void enviarEventoConsulta(Consulta consulta) {
        kafkaTemplate.send(TOPIC, consulta);
    }
}