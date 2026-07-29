package br.com.fiap.atendimento.infra.addapter.event.consumer;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;
import br.com.fiap.atendimento.application.domain.atendimento.Fluxo;
import br.com.fiap.atendimento.application.usecase.outbound.AtendimentoRepository;
import br.com.fiap.atendimento.infra.addapter.inbound.dto.AtendimentoDTO;
import org.springframework.kafka.annotation.KafkaListener;

public class ConsumerFila {
    private final AtendimentoRepository atendimentoRepository;

    public ConsumerFila(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    @KafkaListener(topics = "gerar")
    public void consumeGerar(AtendimentoDTO atendimento) {
        atualizar(AtendimentoDTO.toFila(atendimento, Fluxo.MARCAR.name()));
    }

    @KafkaListener(topics = "marcar")
    public void consumeMarcar(AtendimentoDTO atendimento) {
        atualizar(AtendimentoDTO.toFila(atendimento, Fluxo.EXAME.name()));
    }

    @KafkaListener(topics = "exame")
    public void consume(AtendimentoDTO atendimento) {
        atualizar(AtendimentoDTO.toFila(atendimento, Fluxo.RETORNO.name()));
    }

    public void atualizar(Atendimento atendimento) {
        atendimentoRepository.atualizar(atendimento);
    }
}
