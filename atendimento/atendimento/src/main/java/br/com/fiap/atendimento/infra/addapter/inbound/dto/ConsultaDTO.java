package br.com.fiap.atendimento.infra.addapter.inbound.dto;

import br.com.fiap.atendimento.application.domain.atendimento.Exame;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;

import java.util.List;

public record ConsultaDTO (String idConsulta, String responsavel, String descricao, List<ExameDTO> exames) {
}
