package com.tech_challenge.agendamento_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsultaListener {

    @KafkaListener(topics = "consulta.criada", groupId = "agendamento-service")
    public void consumir(String mensagem) {
        System.out.println("[Kafka] Evento recebido: " + mensagem);
        // Aqui você poderia acionar lógica de envio de lembrete, logs, etc
    }
}
