package br.com.fiap.atendimento.infra.addapter.event.consumer;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;
import br.com.fiap.atendimento.application.domain.atendimento.Fluxo;
import br.com.fiap.atendimento.application.usecase.outbound.AtendimentoRepository;
import br.com.fiap.atendimento.infra.addapter.gateway.AtendimentoImplRepository;
import br.com.fiap.atendimento.infra.addapter.inbound.dto.AtendimentoDTO;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

public class ConsumerFila {
    private final AtendimentoRepository atendimentoRepository;
    private final AtendimentoImplRepository service;

    public ConsumerFila(AtendimentoRepository atendimentoRepository, AtendimentoImplRepository service) {
        this.atendimentoRepository = atendimentoRepository;
        this.service = service;
    }

    @KafkaListener(topics = "GERAR")
    public void gerar(AtendimentoDTO atendimento) {
        definir(AtendimentoDTO.to(atendimento));
    }

    @KafkaListener(topics = "EXAME")
    public void exame(AtendimentoDTO atendimento, List<String> especializacao) {
        passar(AtendimentoDTO.to(atendimento), especializacao);
    }

    private void definir(Atendimento atendimento) {
        service.definir(atendimento);
    }

    private void passar(Atendimento atendimento, List<String> especializacao) {
        service.passar(atendimento, especializacao);
    }

}
