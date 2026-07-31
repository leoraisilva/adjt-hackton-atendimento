package br.com.fiap.atendimento.infra.addapter.inbound.dto;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;
import br.com.fiap.atendimento.application.domain.atendimento.Consulta;
import br.com.fiap.atendimento.application.domain.atendimento.Fluxo;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;

public record AtendimentoDTO(String idAtendimento, String usuario, String unidade, String fluxoAtendimento, ConsultaDTO consulta) {
    public static Atendimento to(AtendimentoDTO atendimentoDTO){
        return new Atendimento.AtendimentoBuilder()
                .withConsulta(ConsultaDTO.to(atendimentoDTO.consulta))
                .withFluxo(Fluxo.valueOf(atendimentoDTO.fluxoAtendimento()))
                .withUnidade(new Unidade.UnidadeBuilder().withIdUnidade(atendimentoDTO.unidade()).build())
                .withUsuario(new Usuario.UsuarioBuilder().withIdUsuario(atendimentoDTO.usuario()).build())
                .withIdAtendimento(atendimentoDTO.idAtendimento())
                .build();
    }

    public static AtendimentoDTO from(Atendimento atendimento){
        return new AtendimentoDTO(
                atendimento.getIdAtendimento(),
                atendimento.getUsuario().getIdUsuario(),
                atendimento.getUnidade().getIdUnidade(),
                atendimento.getFluxoAtendimento().name(),
                ConsultaDTO.from(atendimento.getConsulta())
        );
    }
}
