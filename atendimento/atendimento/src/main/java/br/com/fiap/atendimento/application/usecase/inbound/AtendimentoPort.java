package br.com.fiap.atendimento.application.usecase.inbound;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;

public interface AtendimentoPort {
    GerarOutput gerar(GerarInput input);
}
