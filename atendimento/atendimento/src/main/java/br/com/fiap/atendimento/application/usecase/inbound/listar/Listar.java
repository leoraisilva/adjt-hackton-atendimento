package br.com.fiap.atendimento.application.usecase.inbound.listar;

import br.com.fiap.atendimento.application.usecase.inbound.AtendimentoPort;

import java.util.List;

public class Listar {
    private final AtendimentoPort atendimentoPort;

    public Listar(AtendimentoPort atendimentoPort) {
        this.atendimentoPort = atendimentoPort;
    }

    public List<ListarOutput> listar () {
        return atendimentoPort.listar();
    }
}
