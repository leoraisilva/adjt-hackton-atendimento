package br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto;

import br.com.fiap.atendimento.application.domain.redeservico.macrorregiao.Macrorregiao;
import br.com.fiap.atendimento.application.domain.redeservico.regiaosaude.Regiao;
import br.com.fiap.atendimento.application.domain.redeservico.regiaosaude.RegiaoSaude;

public record RegiaoSaudeDTO(String idRegiaoSaude, Regiao regiao, MacrorregiaoDTO macrorregiao) {

    public static RegiaoSaude to (RegiaoSaudeDTO regiaoSaudeDTO) {
        if (regiaoSaudeDTO == null) {
            return null;
        }
        return new RegiaoSaude.RegiaoSaudeBuilder()
                .withIdRegiaoSaude(regiaoSaudeDTO.idRegiaoSaude())
                .withRegiao(regiaoSaudeDTO.regiao())
                .withMacrorregiao(MacrorregiaoDTO.to(regiaoSaudeDTO.macrorregiao()))
                .build();
    }
    public static RegiaoSaudeDTO from (RegiaoSaude regiaoSaude) {
        if (regiaoSaude == null) {
            return null;
        }
        return new RegiaoSaudeDTO(
                regiaoSaude.getIdRegiaoSaude(),
                regiaoSaude.getRegiao(),
                MacrorregiaoDTO.from(regiaoSaude.getMacrorregiao())
        );
    }

}
