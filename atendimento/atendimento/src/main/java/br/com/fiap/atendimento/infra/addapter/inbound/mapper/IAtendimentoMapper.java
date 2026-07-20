package br.com.fiap.atendimento.infra.addapter.inbound.mapper;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;
import br.com.fiap.atendimento.application.domain.atendimento.AtendimentoFactory;
import br.com.fiap.atendimento.application.domain.atendimento.ConsultaFactory;
import br.com.fiap.atendimento.application.domain.atendimento.ExameFactory;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.AtendimentoEntity;

import java.util.List;

public interface IAtendimentoMapper {
    Atendimento toDomain(AtendimentoEntity entity, Usuario usuario, Unidade unidade, Especialista responsavel, List<Especialista> especialistas);
    AtendimentoEntity toEntity(Atendimento domain);
}
