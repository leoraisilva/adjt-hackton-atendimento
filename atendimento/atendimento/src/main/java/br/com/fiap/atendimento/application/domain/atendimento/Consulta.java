package br.com.fiap.atendimento.application.domain.atendimento;

import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;

import java.util.List;

public class Consulta {
    private final String idConsulta;
    private final Especialista responsavel;
    private final String descricao;
    private final List<Exame> exames;

    public Consulta(ConsultaBuilder builder) {
        this.idConsulta = builder.idConsulta;
        this.responsavel = builder.responsavel;
        this.descricao = builder.descricao;
        this.exames = builder.exames;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public Especialista getResponsavel() {
        return responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public static class ConsultaBuilder {
        private String idConsulta;
        private Especialista responsavel;
        private String descricao;
        private List<Exame> exames;

        public ConsultaBuilder withIdConsulta(String idConsulta) {
            this.idConsulta = idConsulta;
            return this;
        }

        public ConsultaBuilder withResponsavel(Especialista responsavel) {
            this.responsavel = responsavel;
            return this;
        }

        public ConsultaBuilder withDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public ConsultaBuilder withExames(List<Exame> exames) {
            this.exames = exames;
            return this;
        }

        public Consulta build() {
            return new Consulta(this);
        }
    }
}
