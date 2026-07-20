package br.com.fiap.atendimento.application.domain.redeservico.unidade;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.redeservico.regiaosaude.RegiaoSaude;

public interface UnidadeFactory {
    Unidade newUnidade (String idUnidade, String nome, int numero, String complemento, String logradouro, String bairro, Status status, RegiaoSaude regiaoSaude);
}
