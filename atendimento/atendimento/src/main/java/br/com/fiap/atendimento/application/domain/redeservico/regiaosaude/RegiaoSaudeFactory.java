package br.com.fiap.atendimento.application.domain.redeservico.regiaosaude;

import br.com.fiap.atendimento.application.domain.redeservico.macrorregiao.Macrorregiao;

public interface RegiaoSaudeFactory {
    RegiaoSaude newRegiaoSaude (String idRegiaoSaude, Regiao regiao, Macrorregiao macrorregiao);
}
