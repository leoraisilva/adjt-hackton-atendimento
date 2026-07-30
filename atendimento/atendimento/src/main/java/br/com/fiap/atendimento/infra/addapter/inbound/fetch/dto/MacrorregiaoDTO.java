package br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto;

import br.com.fiap.atendimento.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.fiap.atendimento.application.domain.redeservico.redeatencao.RedeAtencao;

public record MacrorregiaoDTO(String idMacro, String codigoMunicipio, RedeAtencaoDTO redeAtencao, String localidade) {
    public static Macrorregiao to (MacrorregiaoDTO macrorregiaoDTO) {
        return new Macrorregiao.MacrorregiaoBuilder()
                .withIdMacro(macrorregiaoDTO.idMacro())
                .withCodigoMunicipio(macrorregiaoDTO.codigoMunicipio())
                .withRedeAtencao(RedeAtencaoDTO.to(macrorregiaoDTO.redeAtencao()))
                .withLocalidade(macrorregiaoDTO.localidade())
                .build();
    }

    public static MacrorregiaoDTO from (Macrorregiao macrorregiao) {
        return new MacrorregiaoDTO(
                macrorregiao.getIdMacro(),
                macrorregiao.getCodigoMunicipio(),
                RedeAtencaoDTO.from(macrorregiao.getRedeAtencao()),
                macrorregiao.getLocalidade()
        );
    }
}
