package br.com.fiap.atendimento.application.domain.atendimento;

import br.com.fiap.atendimento.application.domain.especialista.Especialista;

public class Exame {
    private final String idExame;
    private final String area;
    private final Especialista especialista;

    public Exame(ExameBuilder builder) {
        this.idExame = builder.idExame;
        this.area = builder.area;
        this.especialista = builder.especialista;
    }

    public String getIdExame() {
        return idExame;
    }

    public String getArea() {
        return area;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public static class ExameBuilder {
        private String idExame;
        private String area;
        private Especialista especialista;

        public ExameBuilder withIdExame(String idExame) {
            this.idExame = idExame;
            return this;
        }

        public ExameBuilder withArea(String area) {
            this.area = area;
            return this;
        }

        public ExameBuilder withEspecialista(Especialista especialista) {
            this.especialista = especialista;
            return this;
        }

        public Exame build() {
            return new Exame(this);
        }
    }
}
