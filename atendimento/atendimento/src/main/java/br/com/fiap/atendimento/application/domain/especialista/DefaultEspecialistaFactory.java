package br.com.fiap.atendimento.application.domain.especialista;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.address.Address;

public class DefaultEspecialistaFactory implements EspecialistaFactory {
    @Override
    public Especialista newEspecialista(String idEspecialista, Servico tipo, String nome, String descricao, Status condicao, Especializacao especializacao, Address endereco) {
        return new Especialista.EspecialistaBuilder()
                .withIdEspecialista(idEspecialista)
                .withTipo(tipo)
                .withNome(nome)
                .withDescricao(descricao)
                .withCondicao(condicao)
                .withEspecializacao(especializacao)
                .withEndereco(endereco)
                .build();
    }
}
