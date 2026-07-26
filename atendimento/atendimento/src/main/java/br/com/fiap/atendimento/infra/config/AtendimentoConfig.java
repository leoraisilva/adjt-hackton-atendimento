package br.com.fiap.atendimento.infra.config;

import br.com.fiap.atendimento.application.domain.atendimento.*;
import br.com.fiap.atendimento.application.service.AtendimentoService;
import br.com.fiap.atendimento.application.usecase.inbound.AtendimentoPort;
import br.com.fiap.atendimento.application.usecase.inbound.atualizar.Atualizar;
import br.com.fiap.atendimento.application.usecase.inbound.buscar.Buscar;
import br.com.fiap.atendimento.application.usecase.inbound.cancelar.Cancelar;
import br.com.fiap.atendimento.application.usecase.inbound.gerar.Gerar;
import br.com.fiap.atendimento.application.usecase.inbound.listar.Listar;
import br.com.fiap.atendimento.application.usecase.outbound.AtendimentoRepository;
import br.com.fiap.atendimento.infra.addapter.gateway.AtendimentoImplRepository;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.EspecialistaFetch;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.RedeAtencaoFetch;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.UsuarioFetch;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.IAtendimentoMapper;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.IConsultaMapper;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.IExameMapper;
import br.com.fiap.atendimento.infra.addapter.inbound.mapper.Mapper;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository.AtendimentoJpaRepository;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository.ConsultaJpaRepository;
import br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository.ExameJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtendimentoConfig {
    @Bean
    Listar listar(AtendimentoPort atendimentoPort) {
        return new Listar(atendimentoPort);
    }

    @Bean
    Cancelar cancelar(AtendimentoPort atendimentoPort) {
        return new Cancelar(atendimentoPort);
    }

    @Bean
    Buscar buscar(AtendimentoPort atendimentoPort) {
        return new Buscar(atendimentoPort);
    }

    @Bean
    Gerar gerar(AtendimentoPort atendimentoPort) {
        return new Gerar(atendimentoPort);
    }

    @Bean
    Atualizar atualizar(AtendimentoPort atendimentoPort) {
        return new Atualizar(atendimentoPort);
    }

    @Bean
    AtendimentoPort atendimentoPort(AtendimentoRepository atendimentoRepository) {
        return new AtendimentoService(atendimentoRepository);
    }

    @Bean
    AtendimentoRepository atendimentoRepository(IAtendimentoMapper atendimentoMapper, AtendimentoJpaRepository atendimentoJpaRepository, ConsultaJpaRepository consultaJpaRepository, ExameJpaRepository exameJpaRepository, UsuarioFetch usuarioFetch, EspecialistaFetch especialistaFetch, RedeAtencaoFetch redeAtencaoFetch) {
        return new AtendimentoImplRepository(atendimentoMapper, atendimentoJpaRepository, consultaJpaRepository, exameJpaRepository, usuarioFetch, especialistaFetch, redeAtencaoFetch);
    }

    @Bean
    IAtendimentoMapper atendimentoMapper (AtendimentoFactory atendimentoFactory, ConsultaFactory consultaFactory, ExameFactory exameFactory) {
        return new Mapper(atendimentoFactory, consultaFactory, exameFactory);
    }

    @Bean
    IConsultaMapper consultaMapper (AtendimentoFactory atendimentoFactory, ConsultaFactory consultaFactory, ExameFactory exameFactory) {
        return new Mapper(atendimentoFactory, consultaFactory, exameFactory);
    }

    @Bean
    IExameMapper exameMapper (AtendimentoFactory atendimentoFactory, ConsultaFactory consultaFactory, ExameFactory exameFactory) {
        return new Mapper(atendimentoFactory, consultaFactory, exameFactory);
    }

    @Bean
    AtendimentoFactory atendimentoFactory() {
        return new DefaultAtendimentoFactory();
    }

    @Bean
    ConsultaFactory consultaFactory() {
        return new DefaultConsultaFactory();
    }

    @Bean
    ExameFactory exameFactory() {
        return new DefaultExameFactory();
    }

}
