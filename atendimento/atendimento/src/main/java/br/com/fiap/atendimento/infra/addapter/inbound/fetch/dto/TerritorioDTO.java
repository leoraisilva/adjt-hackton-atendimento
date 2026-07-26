package br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto;

import br.com.fiap.atendimento.application.domain.address.Address;
import br.com.fiap.atendimento.application.domain.redeservico.territorio.Territorio;

public record TerritorioDTO (String idTerritorio, String nome, AddressDTO endereco) {
    public static Territorio to (TerritorioDTO territorioDTO) {
        return new Territorio.TerritorioBuilder()
                .withIdTerritorio(territorioDTO.idTerritorio())
                .withNome(territorioDTO.nome())
                .withEndereco(AddressDTO.to(territorioDTO.endereco()))
                .build();
    }
}
