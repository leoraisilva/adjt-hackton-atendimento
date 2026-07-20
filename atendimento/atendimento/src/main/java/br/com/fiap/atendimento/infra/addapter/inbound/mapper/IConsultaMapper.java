package br.com.fiap.atendimento.infra.addapter.inbound.mapper;

import br.com.fiap.atendimento.application.domain.atendimento.Consulta;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.AtendimentoEntity;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.ConsultaEntity;

import java.util.List;

public interface IConsultaMapper {
    Consulta toDomain(ConsultaEntity entity, Especialista responsavel, List<Especialista> especialistas);
    ConsultaEntity toEntity(Consulta domain);
}
