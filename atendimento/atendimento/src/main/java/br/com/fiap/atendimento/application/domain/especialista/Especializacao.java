package br.com.fiap.atendimento.application.domain.especialista;

public class Especializacao {
    private final String idEspecializacao;
    private final Tipo tipo;
    private final String area;

    public Especializacao(EspecializacaoBuilder builder) {
        this.idEspecializacao = builder.idEspecializacao;
        this.tipo = builder.tipo;
        this.area = builder.area;
    }

    public String getIdEspecializacao() {
        return idEspecializacao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getArea() {
        return area;
    }

    public static class EspecializacaoBuilder {
        private String idEspecializacao;
        private Tipo tipo;
        private String area;

        public EspecializacaoBuilder withIdEspecializacao(String idEspecializacao){
            this.idEspecializacao = idEspecializacao;
            return this;
        }

        public EspecializacaoBuilder withTipo(Tipo tipo){
            this.tipo = tipo;
            return this;
        }

        public EspecializacaoBuilder withArea(String area){
            this.area = area;
            return this;
        }

        public Especializacao build(){
            return new Especializacao(this);
        }
    }
}

