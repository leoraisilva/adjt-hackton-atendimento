package br.com.fiap.atendimento.application.domain.redeservico.macrorregiao;

import br.com.fiap.atendimento.application.domain.redeservico.redeatencao.RedeAtencao;

public interface MacrorregiaoFactory {
    Macrorregiao newMacrorregiao (String idMacro, String codigoMunicipio, RedeAtencao redeAtencao, String localidade);
}
