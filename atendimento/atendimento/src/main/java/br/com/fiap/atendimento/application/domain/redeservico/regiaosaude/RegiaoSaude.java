package br.com.fiap.atendimento.application.domain.redeservico.regiaosaude;

import br.com.fiap.atendimento.application.domain.redeservico.macrorregiao.Macrorregiao;

public class RegiaoSaude {
    private final String idRegiaoSaude;
    private final Regiao regiao;
    private final Macrorregiao macrorregiao;

    public RegiaoSaude(RegiaoSaudeBuilder builder) {
        this.idRegiaoSaude = builder.idRegiaoSaude;
        this.regiao = builder.regiao;
        this.macrorregiao = builder.macrorregiao;
    }

    public String getIdRegiaoSaude() {
        return idRegiaoSaude;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public Macrorregiao getMacrorregiao() {
        return macrorregiao;
    }

    public static class RegiaoSaudeBuilder {
        private String idRegiaoSaude;
        private Regiao regiao;
        private Macrorregiao macrorregiao;

        public RegiaoSaudeBuilder withIdRegiaoSaude (String idRegiaoSaude) {
            this.idRegiaoSaude = idRegiaoSaude;
            return this;
        }

        public RegiaoSaudeBuilder withMacrorregiao (Macrorregiao macrorregiao) {
            this.macrorregiao = macrorregiao;
            return this;
        }

        public RegiaoSaudeBuilder withRegiao (Regiao regiao) {
            this.regiao = regiao;
            return this;
        }

        public RegiaoSaude build () {
            return new RegiaoSaude(this);
        }
    }
}

