package br.com.fiap.atendimento.application.domain.redeservico.macrorregiao;

import br.com.fiap.atendimento.application.domain.redeservico.redeatencao.RedeAtencao;

public class Macrorregiao {
    private final String idMacro;
    private final String codigoMunicipio;
    private final RedeAtencao redeAtencao;
    private final String localidade;

    public Macrorregiao(MacrorregiaoBuilder builder) {
        this.idMacro = builder.idMacro;
        this.codigoMunicipio = builder.codigoMunicipio;
        this.redeAtencao = builder.redeAtencao;
        this.localidade = builder.localidade;
    }

    public String getIdMacro() {
        return idMacro;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public RedeAtencao getRedeAtencao() {
        return redeAtencao;
    }

    public String getLocalidade() {
        return localidade;
    }

    public static class MacrorregiaoBuilder {
        private String idMacro;
        private String codigoMunicipio;
        private RedeAtencao redeAtencao;
        private String localidade;

        public MacrorregiaoBuilder withIdMacro (String idMacro) {
            this.idMacro = idMacro;
            return this;
        }

        public MacrorregiaoBuilder withCodigoMunicipio (String codigoMunicipio) {
            this.codigoMunicipio = codigoMunicipio;
            return this;
        }

        public MacrorregiaoBuilder withRedeAtencao (RedeAtencao redeAtencao) {
            this.redeAtencao = redeAtencao;
            return this;
        }

        public MacrorregiaoBuilder withLocalidade (String localidade) {
            this.localidade = localidade;
            return this;
        }

        public Macrorregiao build () {
            return new Macrorregiao(this);
        }
    }
}
