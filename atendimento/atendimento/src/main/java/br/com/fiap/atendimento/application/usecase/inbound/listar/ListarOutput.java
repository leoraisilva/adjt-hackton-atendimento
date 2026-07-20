package br.com.fiap.atendimento.application.usecase.inbound.listar;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;
import br.com.fiap.atendimento.application.domain.atendimento.Consulta;
import br.com.fiap.atendimento.application.domain.atendimento.Fluxo;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;

public record ListarOutput (
        String idAtendimento,
        Usuario usuario,
        Unidade unidade,
        Fluxo fluxoAtendimento,
        Consulta consulta
) {
    public static Atendimento to (ListarOutput output) {
        return new Atendimento.AtendimentoBuilder()
                .withIdAtendimento(output.idAtendimento())
                .withUsuario(output.usuario())
                .withUnidade(output.unidade())
                .withConsulta(output.consulta())
                .withFluxo(output.fluxoAtendimento())
                .build();
    }

    public static ListarOutput from (Atendimento domain) {
        return new ListarOutput(
                domain.getIdAtendimento(),
                domain.getUsuario(),
                domain.getUnidade(),
                domain.getFluxoAtendimento(),
                domain.getConsulta()
        );
    }
}
