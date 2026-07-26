package br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.address.Address;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import br.com.fiap.atendimento.application.domain.especialista.Especializacao;
import br.com.fiap.atendimento.application.domain.especialista.Servico;

public record EspecialistaDTO(String idEspecialista, Servico tipo, String nome, String descricao, Status condicao, EspecializacaoDTO especializacao, AddressDTO endereco) {
    public static Especialista to (EspecialistaDTO especialistaDTO) {
        return new Especialista.EspecialistaBuilder()
                .withIdEspecialista(especialistaDTO.idEspecialista())
                .withTipo(especialistaDTO.tipo())
                .withNome(especialistaDTO.nome())
                .withDescricao(especialistaDTO.descricao())
                .withCondicao(especialistaDTO.condicao())
                .withEspecializacao(EspecializacaoDTO.to(especialistaDTO.especializacao()))
                .withEndereco(AddressDTO.to(especialistaDTO.endereco()))
                .build();
    }
}
