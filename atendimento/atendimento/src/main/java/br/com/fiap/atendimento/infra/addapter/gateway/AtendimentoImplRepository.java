package br.com.fiap.atendimento.infra.addapter.gateway;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;
import br.com.fiap.atendimento.application.domain.atendimento.Exame;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import br.com.fiap.atendimento.application.usecase.outbound.AtendimentoRepository;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.IAtendimentoMapper;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.IConsultaMapper;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.IExameMapper;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.AtendimentoEntity;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.ConsultaEntity;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.ExameEntity;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository.AtendimentoJpaRepository;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository.ConsultaJpaRepository;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository.ExameJpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AtendimentoImplRepository implements AtendimentoRepository {
    private final IAtendimentoMapper atendimentoMapper;
    private final IConsultaMapper consultaMapper;
    private final IExameMapper exameMapper;
    private final AtendimentoJpaRepository atendimentoJpaRepository;
    private final ConsultaJpaRepository consultaJpaRepository;
    private final ExameJpaRepository exameJpaRepository;

    public AtendimentoImplRepository(IAtendimentoMapper atendimentoMapper, IConsultaMapper consultaMapper, IExameMapper exameMapper, AtendimentoJpaRepository atendimentoJpaRepository, ConsultaJpaRepository consultaJpaRepository, ExameJpaRepository exameJpaRepository) {
        this.atendimentoMapper = atendimentoMapper;
        this.consultaMapper = consultaMapper;
        this.exameMapper = exameMapper;
        this.atendimentoJpaRepository = atendimentoJpaRepository;
        this.consultaJpaRepository = consultaJpaRepository;
        this.exameJpaRepository = exameJpaRepository;
    }


    @Override
    public Atendimento gerar(Atendimento input) {
        var usuario = input.getUsuario();
        var responsavel = input.getConsulta().getResponsavel();
        var unidade = input.getUnidade();
        var especialista = input.getConsulta().getExames().stream()
                .map(Exame::getEspecialista)
                .toList();
        var atendimentoEntity = new AtendimentoEntity(
                UUID.randomUUID().toString(),
                input.getUsuario().getIdUsuario(),
                input.getUnidade().getIdUnidade(),
                input.getFluxoAtendimento().name(),
                new ConsultaEntity(
                        input.getConsulta().getIdConsulta(),
                        input.getConsulta().getResponsavel().getIdEspecialista(),
                        input.getConsulta().getDescricao(),
                        input.getConsulta().getExames().stream()
                                .map(c -> new ExameEntity(
                                        c.getIdExame(),
                                        c.getArea(),
                                        c.getEspecialista().getIdEspecialista()
                                    )
                                )
                                .toList()
                )
        );
        return atendimentoMapper.toDomain(atendimentoJpaRepository.save(atendimentoEntity), usuario, unidade, responsavel, especialista);
    }

    @Override
    public Atendimento atualizar(Atendimento input) {
        var atendimentoEntity = atendimentoJpaRepository.findById(input.getIdAtendimento()).orElseGet(AtendimentoEntity::new);
        atendimentoEntity.setIdUsuario(input.getIdAtendimento());
        atendimentoEntity.setIdUnidade(input.getUsuario().getIdUsuario());
        atendimentoEntity.setFluxoAtendimento(input.getFluxoAtendimento().name());

        var consultaEntity = consultaJpaRepository.findById(input.getConsulta().getIdConsulta()).orElseGet(ConsultaEntity::new);
        consultaEntity.setIdConsulta(input.getConsulta().getIdConsulta());
        consultaEntity.setResponsavel(input.getConsulta().getResponsavel().getIdEspecialista());
        consultaEntity.setDescricao(input.getConsulta().getDescricao());

        List<ExameEntity> exames = new ArrayList<>();
        input.getConsulta().getExames()
                        .forEach(c -> {
                            var exame = exameJpaRepository.findById(c.getIdExame()).orElseGet(ExameEntity::new);
                            exame.setIdExame(c.getIdExame());
                            exame.setArea(c.getArea());
                            exame.setEspecialista(c.getEspecialista().getIdEspecialista());

                            exames.add(exame);
                        });
        consultaEntity.setExames(exames);
        atendimentoEntity.setConsulta(consultaEntity);

        var especialista = input.getConsulta().getExames().stream()
                .map(Exame::getEspecialista)
                .toList();

        return atendimentoMapper.toDomain(atendimentoJpaRepository.save(atendimentoEntity), input.getUsuario(), input.getUnidade(), input.getConsulta().getResponsavel(), especialista);
    }

    @Override
    public Atendimento buscar(String idAtendimento) {
        return null;
    }

    @Override
    public Atendimento cancelar(String idAtendimento) {
        return null;
    }

    @Override
    public List<Atendimento> listar() {
        return null;
    }
}
