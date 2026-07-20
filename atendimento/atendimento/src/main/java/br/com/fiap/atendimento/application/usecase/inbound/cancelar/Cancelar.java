package br.com.fiap.atendimento.application.usecase.inbound.cancelar;

import br.com.fiap.atendimento.application.usecase.inbound.AtendimentoPort;
import br.com.fiap.atendimento.application.usecase.inbound.buscar.BuscarOutput;

public class Cancelar {
    private final AtendimentoPort atendimentoPort;

    public Cancelar(AtendimentoPort atendimentoPort) {
        this.atendimentoPort = atendimentoPort;
    }

    public CancelarOutput cancelar (String idAtendimento) {
        return atendimentoPort.cancelar(idAtendimento);
    }
}
