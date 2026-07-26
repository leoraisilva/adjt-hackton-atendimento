package br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto;

import br.com.fiap.atendimento.application.domain.especialista.Especializacao;
import br.com.fiap.atendimento.application.domain.especialista.Tipo;

public record EspecializacaoDTO (String idEspecializacao, Tipo tipo, String area) {
    public static Especializacao to (EspecializacaoDTO especializacaoDTO) {
        return new Especializacao.EspecializacaoBuilder()
                .withIdEspecializacao(especializacaoDTO.idEspecializacao())
                .withArea(especializacaoDTO.area())
                .withTipo(especializacaoDTO.tipo())
                .build();
    }
}
