package br.com.fiap.atendimento.infra.addapter.event.producer;

import br.com.fiap.atendimento.infra.addapter.inbound.dto.AtendimentoDTO;
import br.com.fiap.atendimento.infra.addapter.inbound.dto.MarcarDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventFila {
    private final KafkaTemplate<String, MarcarDTO> kafkaTemplate;

    public EventFila(KafkaTemplate<String, MarcarDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(String topic, MarcarDTO dto) {
        kafkaTemplate.send(topic, dto);
    }
}
