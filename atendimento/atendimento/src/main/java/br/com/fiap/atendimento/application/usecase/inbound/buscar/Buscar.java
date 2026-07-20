package br.com.fiap.atendimento.application.usecase.inbound.buscar;

import br.com.fiap.atendimento.application.usecase.inbound.AtendimentoPort;

public class Buscar {
    private final AtendimentoPort atendimentoPort;

    public Buscar(AtendimentoPort atendimentoPort) {
        this.atendimentoPort = atendimentoPort;
    }

    public BuscarOutput buscar (String idAtendimento) {
        return atendimentoPort.buscar(idAtendimento);
    }
}
