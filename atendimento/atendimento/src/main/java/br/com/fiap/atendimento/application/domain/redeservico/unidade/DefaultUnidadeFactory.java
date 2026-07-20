package br.com.fiap.atendimento.application.domain.redeservico.unidade;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.redeservico.regiaosaude.RegiaoSaude;

public class DefaultUnidadeFactory implements UnidadeFactory{
    @Override
    public Unidade newUnidade(String idUnidade, String nome, int numero, String complemento, String logradouro, String bairro, Status status, RegiaoSaude regiaoSaude) {
        return new Unidade.UnidadeBuilder()
                .withIdUnidade(idUnidade)
                .withNome(nome)
                .withComplemento(complemento)
                .withLogradouro(logradouro)
                .withBairro(bairro)
                .withStatus(status)
                .withRegiaoSaude(regiaoSaude)
                .build();
    }
}
