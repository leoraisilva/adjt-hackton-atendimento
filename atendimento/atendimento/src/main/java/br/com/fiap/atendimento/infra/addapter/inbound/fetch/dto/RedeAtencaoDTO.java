package br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto;

import br.com.fiap.atendimento.application.domain.redeservico.redeatencao.RedeAtencao;
import br.com.fiap.atendimento.application.domain.redeservico.redeatencao.TipoServico;

public record RedeAtencaoDTO (String idRede, String responsavel, TipoServico tipo, String descricao, String uf, String estado) {
    public static RedeAtencao to (RedeAtencaoDTO redeAtencaoDTO) {
        return new RedeAtencao.RedeAtencaoBuilder()
                .withIdRede(redeAtencaoDTO.idRede())
                .withResponsavel(redeAtencaoDTO.responsavel())
                .withTipo(redeAtencaoDTO.tipo())
                .withDescricao(redeAtencaoDTO.descricao())
                .withUf(redeAtencaoDTO.uf())
                .withEstado(redeAtencaoDTO.estado())
                .build();
    }

    public static RedeAtencaoDTO from (RedeAtencao redeAtencao) {
        return new RedeAtencaoDTO(
                redeAtencao.getIdRede(),
                redeAtencao.getResponsavel(),
                redeAtencao.getTipo(),
                redeAtencao.getDescricao(),
                redeAtencao.getUf(),
                redeAtencao.getEstado()
        );
    }
}
