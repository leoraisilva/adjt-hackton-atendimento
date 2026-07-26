package br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.redeservico.regiaosaude.RegiaoSaude;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;

public record UnidadeDTO (String idUnidade, String nome, int numero, String complemento, String logradouro, String bairro, Status status, RegiaoSaudeDTO regiaoSaude) {
    public static Unidade to (UnidadeDTO unidadeDTO) {
        return new Unidade.UnidadeBuilder()
                .withIdUnidade(unidadeDTO.idUnidade())
                .withNome(unidadeDTO.nome())
                .withComplemento(unidadeDTO.complemento())
                .withLogradouro(unidadeDTO.logradouro())
                .withBairro(unidadeDTO.bairro())
                .withStatus(unidadeDTO.status())
                .withRegiaoSaude(RegiaoSaudeDTO.to(unidadeDTO.regiaoSaude()))
                .build();
    }
}
