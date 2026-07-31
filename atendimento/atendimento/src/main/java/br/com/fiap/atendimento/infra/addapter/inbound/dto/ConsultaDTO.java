package br.com.fiap.atendimento.infra.addapter.inbound.dto;

import br.com.fiap.atendimento.application.domain.atendimento.Consulta;
import br.com.fiap.atendimento.application.domain.atendimento.Exame;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;

import java.util.List;
import java.util.Optional;

public record ConsultaDTO (String idConsulta, String responsavel, String descricao, List<ExameDTO> exames) {
    public static Consulta to (ConsultaDTO consultaDTO) {
        return new Consulta.ConsultaBuilder()
                .withIdConsulta(consultaDTO.idConsulta())
                .withResponsavel(new Especialista.EspecialistaBuilder().withIdEspecialista(consultaDTO.responsavel()).build())
                .withDescricao(consultaDTO.descricao())
                .withExames(
                        Optional.ofNullable(consultaDTO.exames)
                                .orElse(List.of())
                                .stream()
                                .map(ExameDTO::to)
                                .toList()
                )
                .build();
    }

    public static ConsultaDTO from (Consulta consulta) {
        return new ConsultaDTO(
                consulta.getIdConsulta(),
                consulta.getResponsavel().getIdEspecialista(),
                consulta.getDescricao(),
                consulta.getExames().stream().map(ExameDTO::from).toList()
        );
    }
}
