package br.com.fiap.atendimento.application.usecase.inbound.gerar;

import br.com.fiap.atendimento.application.usecase.inbound.AtendimentoPort;

public class Gerar {
    private final AtendimentoPort atendimentoPort;

    public Gerar(AtendimentoPort atendimentoPort) {
        this.atendimentoPort = atendimentoPort;
    }

    public GerarOutput gerar (GerarInput input) {
        return atendimentoPort.gerar(input);
    }
}
