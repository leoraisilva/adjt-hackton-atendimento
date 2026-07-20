package br.com.fiap.atendimento.application.domain.redeservico.territorio;

import br.com.fiap.atendimento.application.domain.address.Address;

public class DefaultTerritorioFactory implements TerritorioFactory{
    @Override
    public Territorio newTerritorio(String idTerritorio, String nome, Address endereco) {
        return new Territorio.TerritorioBuilder()
                .withIdTerritorio(idTerritorio)
                .withNome(nome)
                .withEndereco(endereco)
                .build();
    }
}
