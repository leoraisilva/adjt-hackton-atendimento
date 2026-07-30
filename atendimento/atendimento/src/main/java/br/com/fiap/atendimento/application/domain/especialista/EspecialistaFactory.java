package br.com.fiap.atendimento.application.domain.especialista;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.address.Address;

import java.time.LocalDateTime;
import java.util.List;

public interface EspecialistaFactory {
    Especialista novoEspecialista(String idEspecialista, Servico tipo, String nome, String descricao, Status condicao, Especializacao especializacao, Address endereco, LocalDateTime inicioAtendimento, LocalDateTime fimAtendimento, List<LocalDateTime> listaAtendimento, long disponibilidade);
}
