package br.com.fiap.atendimento.application.usecase.inbound.marcar;

import br.com.fiap.atendimento.application.usecase.inbound.AtendimentoPort;

public class Marcar {
    private final AtendimentoPort atendimentoPort;

    public Marcar(AtendimentoPort atendimentoPort) {
        this.atendimentoPort = atendimentoPort;
    }

    public MarcarOutput marcar (MarcarInput input) {
        return atendimentoPort.marcar(input);
    }
}
