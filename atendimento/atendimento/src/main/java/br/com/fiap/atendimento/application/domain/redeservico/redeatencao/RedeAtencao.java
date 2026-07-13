package br.com.fiap.atendimento.application.domain.redeservico.redeatencao;

public class RedeAtencao {
    private final String idRede;
    private final String responsavel;
    private final TipoServico tipo;
    private final String descricao;
    private final String uf;
    private final String estado;

    public RedeAtencao(RedeAtencaoBuilder redeAtencaoBuilder) {
        this.idRede = redeAtencaoBuilder.idRede;
        this.responsavel = redeAtencaoBuilder.responsavel;
        this.tipo = redeAtencaoBuilder.tipo;
        this.descricao = redeAtencaoBuilder.descricao;
        this.estado = redeAtencaoBuilder.estado;
        this.uf = redeAtencaoBuilder.uf;
    }

    public String getIdRede() {
        return idRede;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public TipoServico getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUf() {
        return uf;
    }

    public String getEstado() {
        return estado;
    }

    public static class RedeAtencaoBuilder {
        private String idRede;
        private String responsavel;
        private TipoServico tipo;
        private String descricao;
        private String uf;
        private String estado;

        public RedeAtencaoBuilder withIdRede (String idRede) {
            this.idRede = idRede;
            return this;
        }

        public RedeAtencaoBuilder withResponsavel (String responsavel) {
            this.responsavel = responsavel;
            return this;
        }

        public RedeAtencaoBuilder withTipo (TipoServico tipo) {
            this.tipo = tipo;
            return this;
        }

        public RedeAtencaoBuilder withDescricao (String descricao) {
            this.descricao = descricao;
            return this;
        }

        public RedeAtencaoBuilder withUf (String uf) {
            this.uf = uf;
            return this;
        }

        public RedeAtencaoBuilder withEstado (String estado) {
            this.estado = estado;
            return this;
        }

        public RedeAtencao build () {
            return new RedeAtencao(this);
        }
    }
}
