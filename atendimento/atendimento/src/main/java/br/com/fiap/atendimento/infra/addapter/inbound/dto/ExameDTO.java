package br.com.fiap.atendimento.infra.addapter.inbound.dto;

import br.com.fiap.atendimento.application.domain.especialista.Especialista;

public record ExameDTO (String idExame, String area, String especialista) {
}
