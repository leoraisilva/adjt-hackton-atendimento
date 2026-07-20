package br.com.fiap.atendimento.application.domain.especialista;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.address.Address;

public interface EspecialistaFactory {
    Especialista newEspecialista (String idEspecialista, Servico tipo, String nome, String descricao, Status condicao, Especializacao especializacao, Address endereco);
}
