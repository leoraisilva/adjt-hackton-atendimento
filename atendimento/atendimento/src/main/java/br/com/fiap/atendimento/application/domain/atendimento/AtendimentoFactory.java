package br.com.fiap.atendimento.application.domain.atendimento;

import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;

public interface AtendimentoFactory {
    Atendimento newAtendimento (String idAtendimento, Usuario usuario, Unidade unidade, Fluxo fluxoAtendimento, Consulta consulta);
}
