package br.com.fiap.atendimento.infra.addapter.inbound.dto;

import br.com.fiap.atendimento.application.domain.atendimento.Exame;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;

public record ExameDTO (String idExame, String area, String especialista) {
    public static Exame to (ExameDTO exameDTO) {
        return new Exame.ExameBuilder()
                .withIdExame(exameDTO.idExame())
                .withArea(exameDTO.area())
                .withEspecialista(new Especialista.EspecialistaBuilder().withIdEspecialista(exameDTO.especialista()).build())
                .build();
    }

    public static ExameDTO from (Exame exame) {
        return new ExameDTO(
                exame.getIdExame(),
                exame.getArea(),
                exame.getEspecialista().getIdEspecialista()
        );
    }
}
