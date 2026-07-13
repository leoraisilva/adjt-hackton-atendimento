package br.com.fiap.atendimento.application.usecase.inbound.gerar;

import br.com.fiap.atendimento.application.domain.atendimento.Consulta;
import br.com.fiap.atendimento.application.domain.atendimento.Fluxo;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;

public record GerarOutput(
        String idAtendimento,
        Usuario usuario,
        Unidade unidade,
        Fluxo fluxoAtendimento,
        Consulta consulta
) {
}
