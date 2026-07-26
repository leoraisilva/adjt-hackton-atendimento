package br.com.fiap.atendimento.application.domain.redeservico.macrorregiao;

import br.com.fiap.atendimento.application.domain.redeservico.redeatencao.RedeAtencao;

public class DefaultMacrorregiaoFactory implements MacrorregiaoFactory{
    @Override
    public Macrorregiao newMacrorregiao(String idMacro, String codigoMunicipio, RedeAtencao redeAtencao, String localidade) {
        return new Macrorregiao.MacrorregiaoBuilder()
                .withIdMacro(idMacro)
                .withCodigoMunicipio(codigoMunicipio)
                .withRedeAtencao(redeAtencao)
                .withLocalidade(localidade)
                .build();
    }
}
