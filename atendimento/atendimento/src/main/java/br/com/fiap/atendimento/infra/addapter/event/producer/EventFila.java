package br.com.fiap.atendimento.infra.addapter.event.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventFila {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public EventFila(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(String topic, String valor) {
        kafkaTemplate.send(topic, valor);
    }
}
