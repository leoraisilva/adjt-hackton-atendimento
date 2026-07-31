package br.com.fiap.atendimento.infra.addapter.event.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventFila {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public EventFila(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(String topic, Object valor) {
        kafkaTemplate.send(topic, valor);
    }
}
