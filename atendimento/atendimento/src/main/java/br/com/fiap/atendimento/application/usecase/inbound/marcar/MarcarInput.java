package br.com.fiap.atendimento.application.usecase.inbound.marcar;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;

import java.util.List;

public record MarcarInput (Atendimento atendimento, List<String> exames) {
    public static Atendimento from (MarcarInput input) {
        return new Atendimento.AtendimentoBuilder()
                .withIdAtendimento(input.atendimento().getIdAtendimento())
                .withUsuario(input.atendimento().getUsuario())
                .withUnidade(input.atendimento().getUnidade())
                .withConsulta(input.atendimento().getConsulta())
                .withFluxo(input.atendimento().getFluxoAtendimento())
                .build();
    }

    public static MarcarInput to (Atendimento atendimento, List<String> exames) {
        return new MarcarInput(atendimento, exames);
    }
}
