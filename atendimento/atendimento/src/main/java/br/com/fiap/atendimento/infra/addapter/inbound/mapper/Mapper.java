package br.com.fiap.atendimento.infra.addapter.inbound.mapper;

import br.com.fiap.atendimento.application.domain.atendimento.*;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.AtendimentoEntity;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.ConsultaEntity;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.ExameEntity;

import java.util.ArrayList;
import java.util.List;

public class Mapper implements IAtendimentoMapper, IConsultaMapper, IExameMapper{
    private final AtendimentoFactory atendimentoFactory;
    private final ConsultaFactory consultaFactory;
    private final ExameFactory exameFactory;

    public Mapper(AtendimentoFactory atendimentoFactory, ConsultaFactory consultaFactory, ExameFactory exameFactory) {
        this.atendimentoFactory = atendimentoFactory;
        this.consultaFactory = consultaFactory;
        this.exameFactory = exameFactory;
    }

    @Override
    public Atendimento toDomain(AtendimentoEntity entity, Usuario usuario, Unidade unidade, Especialista responsavel, List<Especialista> especialistas) {
        return atendimentoFactory.newAtendimento(
                entity.getIdAtendimento(),
                usuario,
                unidade,
                Fluxo.valueOf(entity.getFluxoAtendimento()),
                toDomain(entity.getConsulta(), responsavel,especialistas)
        );
    }

    @Override
    public AtendimentoEntity toEntity(Atendimento domain) {
        return new AtendimentoEntity(
                domain.getIdAtendimento(),
                domain.getUsuario().getIdUsuario(),
                domain.getUnidade().getIdUnidade(),
                domain.getFluxoAtendimento().name(),
                toEntity(domain.getConsulta())
        );
    }

    @Override
    public Consulta toDomain(ConsultaEntity entity, Especialista responsavel, List<Especialista> especialistas) {
        var exame = entity.getExames().stream()
                .map(c -> exameFactory.newExame(
                        c.getIdExame(),
                        c.getArea(),
                        especialistas.stream()
                                .filter(a -> a.getIdEspecialista().equals(c.getEspecialista()))
                                .findFirst()
                                .orElse(null)
                        )
                )
                .toList();
        return consultaFactory.newConsulta(
                entity.getIdConsulta(),
                responsavel,
                entity.getDescricao(),
                exame
        );
    }

    @Override
    public ConsultaEntity toEntity(Consulta domain) {
        return new ConsultaEntity(
                domain.getIdConsulta(),
                domain.getResponsavel().getIdEspecialista(),
                domain.getDescricao(),
                domain.getExames().stream()
                        .map(this::toEntity)
                        .toList()
        );
    }

    @Override
    public Exame toDomain(ExameEntity entity, Especialista especialista) {
        return exameFactory.newExame(
                entity.getIdExame(),
                entity.getArea(),
                especialista
        );
    }

    @Override
    public ExameEntity toEntity(Exame domain) {
        return new ExameEntity(
                domain.getIdExame(),
                domain.getArea(),
                domain.getEspecialista().getIdEspecialista()
        );
    }
}
