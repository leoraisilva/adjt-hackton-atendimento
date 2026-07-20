package br.com.fiap.atendimento.application.usecase.inbound.atualizar;

import br.com.fiap.atendimento.application.usecase.inbound.AtendimentoPort;

public class Atualizar {
    private final AtendimentoPort atendimentoPort;

    public Atualizar(AtendimentoPort atendimentoPort) {
        this.atendimentoPort = atendimentoPort;
    }

    public AtualizarOutput atualizar (AtualizarInput input) {
        return atendimentoPort.atualizar(input);
    }
}
