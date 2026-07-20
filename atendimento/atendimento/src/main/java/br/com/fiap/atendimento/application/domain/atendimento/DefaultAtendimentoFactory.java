package br.com.fiap.atendimento.application.domain.atendimento;

import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;

public class DefaultAtendimentoFactory implements AtendimentoFactory{
    @Override
    public Atendimento newAtendimento(String idAtendimento, Usuario usuario, Unidade unidade, Fluxo fluxoAtendimento, Consulta consulta) {
        return new Atendimento.AtendimentoBuilder()
                .withIdAtendimento(idAtendimento)
                .withUsuario(usuario)
                .withUnidade(unidade)
                .withFluxo(fluxoAtendimento)
                .withConsulta(consulta)
                .build();
    }
}
