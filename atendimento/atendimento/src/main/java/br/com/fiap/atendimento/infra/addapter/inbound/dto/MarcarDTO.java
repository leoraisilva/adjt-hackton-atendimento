package br.com.fiap.atendimento.infra.addapter.inbound.dto;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;

import java.util.List;

public record MarcarDTO (AtendimentoDTO atendimentoDTO, List<String> exames) {
    public static MarcarDTO from(Atendimento atendimento, List<String> exames) {
        return new MarcarDTO(
                AtendimentoDTO.from(atendimento),
                exames
        );
    }

}
