package br.com.fiap.atendimento.application.domain.atendimento;

import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;

import java.util.List;

public class Atendimento {
    private final String idAtendimento;
    private final Usuario usuario;
    private final Unidade unidade;
    private final Fluxo fluxoAtendimento;
    private final Consulta consulta;

    public Atendimento(AtendimentoBuilder builder) {
        this.idAtendimento = builder.idAtendimento;
        this.usuario = builder.usuario;
        this.unidade = builder.unidade;
        this.fluxoAtendimento = builder.fluxoAtendimento;
        this.consulta = builder.consulta;
    }

    public String getIdAtendimento() {
        return idAtendimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public Fluxo getFluxoAtendimento() {
        return fluxoAtendimento;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public static class AtendimentoBuilder {
        private String idAtendimento;
        private Usuario usuario;
        private Unidade unidade;
        private Fluxo fluxoAtendimento;
        private Consulta consulta;

        public AtendimentoBuilder withIdAtendimento(String idAtendimento) {
            this.idAtendimento = idAtendimento;
            return this;
        }

        public AtendimentoBuilder withUsuario(Usuario usuario) {
            this.usuario = usuario;
            return this;
        }

        public AtendimentoBuilder withUnidade(Unidade unidade) {
            this.unidade = unidade;
            return this;
        }

        public AtendimentoBuilder withFluxo(Fluxo fluxoAtendimento) {
            this.fluxoAtendimento = fluxoAtendimento;
            return this;
        }

        public AtendimentoBuilder withConsulta(Consulta consulta) {
            this.consulta = consulta;
            return this;
        }

        public Atendimento build() {
            return new Atendimento(this);
        }
    }
}
