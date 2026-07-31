package br.com.fiap.atendimento.infra.addapter.event.consumer;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;
import br.com.fiap.atendimento.application.usecase.outbound.AtendimentoRepository;
import br.com.fiap.atendimento.infra.addapter.inbound.dto.AtendimentoDTO;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.Mapper;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.AtendimentoEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsumerFila {
    private final AtendimentoRepository service;
    private final Mapper mapper;

    public ConsumerFila(@Qualifier("atendimentoRepository") AtendimentoRepository service, Mapper mapper) {
        this.mapper = mapper;
        this.service = service;
    }

    @KafkaListener(topics = "GERAR", groupId = "grupo-gerar")
    public void gerar(Atendimento atendimento) {
        definir(atendimento);
    }

    @KafkaListener(topics = "EXAME", groupId = "grupo-exame")
    public void exame(Atendimento atendimento, List<String> especializacao) {
        passar(atendimento, especializacao);
    }

    private void definir(Atendimento atendimento) {
        System.out.println("Recebido GERAR: " + atendimento);
        service.definir(atendimento);
    }

    private void passar(Atendimento atendimento, List<String> especializacao) {
        service.passar(atendimento, especializacao);
    }

}
