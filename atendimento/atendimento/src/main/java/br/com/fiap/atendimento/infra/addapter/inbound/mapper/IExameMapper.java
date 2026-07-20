package br.com.fiap.atendimento.infra.addapter.inbound.mapper;

import br.com.fiap.atendimento.application.domain.atendimento.Exame;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.ExameEntity;

public interface IExameMapper {
    Exame toDomain(ExameEntity entity, Especialista especialista);
    ExameEntity toEntity(Exame domain);
}
