package br.com.fiap.atendimento.application.domain.redeservico.territorio;

import br.com.fiap.atendimento.application.domain.address.Address;

public interface TerritorioFactory {
    Territorio newTerritorio (String idTerritorio, String nome, Address endereco);
}
