package br.com.fiap.atendimento.infra.addapter.inbound.dto;

import br.com.fiap.atendimento.application.domain.atendimento.Consulta;
import br.com.fiap.atendimento.application.domain.atendimento.Fluxo;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;

public record AtendimentoDTO(String idAtendimento, String usuario, String unidade, Fluxo fluxoAtendimento, ConsultaDTO consulta) {
}
