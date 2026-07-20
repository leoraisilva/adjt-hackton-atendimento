package br.com.fiap.atendimento.application.domain.redeservico.regiaosaude;

import br.com.fiap.atendimento.application.domain.redeservico.macrorregiao.Macrorregiao;

public class DefaultRegiaoSaudeFactory implements RegiaoSaudeFactory{
    @Override
    public RegiaoSaude newRegiaoSaude(String idRegiaoSaude, Regiao regiao, Macrorregiao macrorregiao) {
        return new RegiaoSaude.RegiaoSaudeBuilder()
                .withIdRegiaoSaude(idRegiaoSaude)
                .withRegiao(regiao)
                .withMacrorregiao(macrorregiao)
                .build();
    }
}
