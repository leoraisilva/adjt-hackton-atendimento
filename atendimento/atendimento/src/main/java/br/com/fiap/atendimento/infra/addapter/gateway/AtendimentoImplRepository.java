package br.com.fiap.atendimento.infra.addapter.gateway;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;
import br.com.fiap.atendimento.application.domain.atendimento.Exame;
import br.com.fiap.atendimento.application.domain.atendimento.Fluxo;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.usecase.outbound.AtendimentoRepository;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.EspecialistaFetch;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.RedeAtencaoFetch;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.UsuarioFetch;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto.EspecialistaDTO;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto.UnidadeDTO;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto.UsuarioDTO;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.IAtendimentoMapper;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.IConsultaMapper;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.IExameMapper;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.AtendimentoEntity;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.ConsultaEntity;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.ExameEntity;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository.AtendimentoJpaRepository;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository.ConsultaJpaRepository;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository.ExameJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AtendimentoImplRepository implements AtendimentoRepository {
    private final IAtendimentoMapper atendimentoMapper;
    private final AtendimentoJpaRepository atendimentoJpaRepository;
    private final ConsultaJpaRepository consultaJpaRepository;
    private final ExameJpaRepository exameJpaRepository;
    private final UsuarioFetch usuarioFetch;
    private final EspecialistaFetch especialistaFetch;
    private final RedeAtencaoFetch redeAtencaoFetch;

    public AtendimentoImplRepository(IAtendimentoMapper atendimentoMapper, AtendimentoJpaRepository atendimentoJpaRepository, ConsultaJpaRepository consultaJpaRepository, ExameJpaRepository exameJpaRepository, UsuarioFetch usuarioFetch, EspecialistaFetch especialistaFetch, RedeAtencaoFetch redeAtencaoFetch) {
        this.atendimentoMapper = atendimentoMapper;
        this.atendimentoJpaRepository = atendimentoJpaRepository;
        this.consultaJpaRepository = consultaJpaRepository;
        this.exameJpaRepository = exameJpaRepository;
        this.usuarioFetch = usuarioFetch;
        this.especialistaFetch = especialistaFetch;
        this.redeAtencaoFetch = redeAtencaoFetch;
    }

    @Override
    @Transactional
    public Atendimento gerar(Atendimento input) {

        var usuario = UsuarioDTO.to(usuarioFetch.getUsurio(input.getUsuario().getIdUsuario()));
        var unidade = UnidadeDTO.to(redeAtencaoFetch.buscarUnidade(input.getUnidade().getIdUnidade()).unidade());
        System.out.println(unidade.getIdUnidade());


        ConsultaEntity consultaEntity = null;
        Especialista responsavel = null;
        List<Especialista> especialistas = List.of();

        if (input.getConsulta() != null) {
            var consulta = input.getConsulta();
            responsavel = EspecialistaDTO.to(especialistaFetch.buscar(consulta.getResponsavel().getIdEspecialista()));
            var exames = Optional.ofNullable(consulta.getExames())
                    .orElse(List.of());
            especialistas = exames.stream()
                    .map(exame -> EspecialistaDTO.to(especialistaFetch.buscar(exame.getEspecialista().getIdEspecialista())))
                    .toList();

            var exameEntity = exames.stream()
                    .map(exame -> new ExameEntity(
                            UUID.randomUUID().toString(),
                            exame.getArea(),
                            exame.getEspecialista().getIdEspecialista()
                    ))
                    .toList();

            consultaEntity = new ConsultaEntity(
                    UUID.randomUUID().toString(),
                    consulta.getResponsavel().getIdEspecialista(),
                    consulta.getDescricao(),
                    exameEntity
            );
        }

        var atendimentoEntity = new AtendimentoEntity(
                UUID.randomUUID().toString(),
                input.getUsuario().getIdUsuario(),
                input.getUnidade().getIdUnidade(),
                input.getFluxoAtendimento().name(),
                consultaEntity
        );

        return atendimentoMapper.toDomain(atendimentoJpaRepository.save(atendimentoEntity), usuario, unidade, responsavel, especialistas);
    }

    @Override
    @Transactional
    public Atendimento atualizar(Atendimento input) {
        var atendimentoEntity = atendimentoJpaRepository.findById(input.getIdAtendimento()).orElseThrow(() -> new RuntimeException("Atendimento não encontrado!!"));
        atendimentoEntity.setIdUsuario(input.getUsuario().getIdUsuario());
        atendimentoEntity.setIdUnidade(input.getUnidade().getIdUnidade());
        atendimentoEntity.setFluxoAtendimento(input.getFluxoAtendimento().name());

        List<ExameEntity> exames = new ArrayList<>();
        input.getConsulta().getExames()
                .forEach(c -> {
                    ExameEntity exame;

                    if (c.getIdExame() == null) {
                        exame = new ExameEntity(
                                UUID.randomUUID().toString(),
                                c.getArea(),
                                c.getEspecialista().getIdEspecialista()
                        );
                    } else {
                        exame = exameJpaRepository.findById(c.getIdExame())
                                .orElse(new ExameEntity());

                        exame.setIdExame(c.getIdExame());
                        exame.setArea(c.getArea());
                        exame.setEspecialista(c.getEspecialista().getIdEspecialista());
                    }

                    exames.add(exame);
                });

        ConsultaEntity consultaEntity;

        if (input.getConsulta().getIdConsulta() == null) {

            consultaEntity = new ConsultaEntity(
                    UUID.randomUUID().toString(),
                    input.getConsulta().getResponsavel().getIdEspecialista(),
                    input.getConsulta().getDescricao(),
                    exames
            );

        } else {

            consultaEntity = consultaJpaRepository
                    .findById(input.getConsulta().getIdConsulta())
                    .orElse(new ConsultaEntity());

            consultaEntity.setIdConsulta(input.getConsulta().getIdConsulta());
            consultaEntity.setResponsavel(input.getConsulta().getResponsavel().getIdEspecialista());
            consultaEntity.setDescricao(input.getConsulta().getDescricao());
            consultaEntity.setExames(exames);
        }

        atendimentoEntity.setConsulta(consultaEntity);

        var usuario = UsuarioDTO.to(usuarioFetch.getUsurio(atendimentoEntity.getIdUsuario()));
        var unidade = UnidadeDTO.to(redeAtencaoFetch.buscarUnidade(atendimentoEntity.getIdUnidade()).unidade());
        var especialista = EspecialistaDTO.to(especialistaFetch.buscar(atendimentoEntity.getConsulta().getResponsavel()));

        var especialistas = input.getConsulta().getExames().stream()
                .map(c -> EspecialistaDTO.to(especialistaFetch.buscar(c.getEspecialista().getIdEspecialista())))
                .toList();

        return atendimentoMapper.toDomain(atendimentoJpaRepository.save(atendimentoEntity), usuario, unidade, especialista, especialistas);
    }

    @Override
    public Atendimento buscar(String idAtendimento) {
        var atendimento = atendimentoJpaRepository.findById(idAtendimento).orElseThrow(() -> new RuntimeException("Erro ao encontrar Atendimento!!"));
        var usuario = UsuarioDTO.to(usuarioFetch.getUsurio(atendimento.getIdUsuario()));
        var unidade = UnidadeDTO.to(redeAtencaoFetch.buscarUnidade(atendimento.getIdUnidade()).unidade());
        var responsavel = EspecialistaDTO.to(especialistaFetch.buscar(atendimento.getConsulta().getResponsavel()));
        List<Especialista> especialistas = atendimento.getConsulta().getExames().stream()
                .map(consultaMapper -> EspecialistaDTO.to(especialistaFetch.buscar(consultaMapper.getEspecialista())))
                .toList();

        return atendimentoMapper.toDomain(atendimento, usuario, unidade, responsavel, especialistas);
    }

    @Override
    @Transactional
    public Atendimento cancelar(String idAtendimento) {
        var atendimento = atendimentoJpaRepository.findById(idAtendimento).orElseThrow(() -> new RuntimeException("Erro ao encontrar Atendimento!!"));
        atendimento.setFluxoAtendimento(Fluxo.CANCELAR.name());
        atendimento = atendimentoJpaRepository.save(atendimento);
        var usuario = UsuarioDTO.to(usuarioFetch.getUsurio(atendimento.getIdUsuario()));
        var unidade = UnidadeDTO.to(redeAtencaoFetch.buscarUnidade(atendimento.getIdUnidade()).unidade());
        var responsavel = EspecialistaDTO.to(especialistaFetch.buscar(atendimento.getConsulta().getResponsavel()));
        List<Especialista> especialistas = atendimento.getConsulta().getExames().stream()
                .map(c -> EspecialistaDTO.to(especialistaFetch.buscar(c.getEspecialista())))
                .toList();

        return atendimentoMapper.toDomain(atendimento, usuario, unidade, responsavel, especialistas);
    }

    @Override
    public List<Atendimento> listar() {
        var atendimentosEntities = atendimentoJpaRepository.findAll();
        List<Atendimento> resultado = new ArrayList<>(atendimentosEntities.size());

        for (var entity : atendimentosEntities) {

            var usuario = UsuarioDTO.to(usuarioFetch.getUsurio(entity.getIdUsuario()));
            var unidade = UnidadeDTO.to(redeAtencaoFetch.buscarUnidade(entity.getIdUnidade()).unidade());
            var responsavel = EspecialistaDTO.to(especialistaFetch.buscar(entity.getConsulta().getResponsavel()));

            var especialistas = entity.getConsulta().getExames().stream()
                    .map(e -> EspecialistaDTO.to(especialistaFetch.buscar(e.getEspecialista())))
                    .toList();

            resultado.add(atendimentoMapper.toDomain(entity, usuario, unidade, responsavel, especialistas));
        }

        return resultado;
    }
}
