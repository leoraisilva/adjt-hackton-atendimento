package br.com.fiap.atendimento.application.usecase.inbound.atualizar;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;
import br.com.fiap.atendimento.application.domain.atendimento.Consulta;
import br.com.fiap.atendimento.application.domain.atendimento.Fluxo;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;

public record AtualizarInput (
        String idAtendimento,
        Usuario usuario,
        Unidade unidade,
        Fluxo fluxoAtendimento,
        Consulta consulta)
{
    public static AtualizarInput from (Atendimento domain) {
        return new AtualizarInput(
                domain.getIdAtendimento(),
                domain.getUsuario(),
                domain.getUnidade(),
                domain.getFluxoAtendimento(),
                domain.getConsulta()
        );
    }

    public static Atendimento to (AtualizarInput input) {
        return new Atendimento.AtendimentoBuilder()
                .withIdAtendimento(input.idAtendimento())
                .withUsuario(input.usuario())
                .withUnidade(input.unidade())
                .withConsulta(input.consulta())
                .withFluxo(input.fluxoAtendimento())
                .build();
    }
}
