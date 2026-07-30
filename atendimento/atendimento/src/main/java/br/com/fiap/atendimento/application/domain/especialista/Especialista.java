package br.com.fiap.atendimento.application.domain.especialista;

import br.com.fiap.atendimento.application.domain.address.Address;
import br.com.fiap.atendimento.application.domain.Status;

import java.time.LocalDateTime;
import java.util.List;

public class Especialista {
    private final String idEspecialista;
    private final Servico tipo;
    private final String nome;
    private final String descricao;
    private final Status condicao;
    private final Especializacao especializacao;
    private final Address endereco;
    private final LocalDateTime inicioAtendimento;
    private final LocalDateTime fimAtendimento;
    private final List<LocalDateTime> listaAtendimento;
    private final long disponibilidade;

    public Especialista(EspecialistaBuilder builder) {
        this.idEspecialista = builder.idEspecialista;
        this.tipo = builder.tipo;
        this.nome = builder.nome;
        this.descricao = builder.descricao;
        this.condicao = builder.condicao;
        this.especializacao = builder.especializacao;
        this.endereco = builder.endereco;
        this.inicioAtendimento = builder.inicioAtendimento;
        this.fimAtendimento = builder.fimAtendimento;
        this.listaAtendimento = builder.listaAtendimento;
        this.disponibilidade = builder.disponibilidade;
    }

    public String getIdEspecialista() {
        return idEspecialista;
    }

    public Servico getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getCondicao() {
        return condicao;
    }

    public Especializacao getEspecializacao() {
        return especializacao;
    }

    public Address getEndereco() {
        return endereco;
    }

    public LocalDateTime getInicioAtendimento() {
        return inicioAtendimento;
    }

    public LocalDateTime getFimAtendimento() {
        return fimAtendimento;
    }

    public List<LocalDateTime> getListaAtendimento() {
        return listaAtendimento;
    }

    public long getDisponibilidade() {
        return disponibilidade;
    }

    public static class EspecialistaBuilder {
        private String idEspecialista;
        private Servico tipo;
        private String nome;
        private String descricao;
        private Status condicao;
        private Especializacao especializacao;
        private Address endereco;
        private LocalDateTime inicioAtendimento;
        private LocalDateTime fimAtendimento;
        private List<LocalDateTime> listaAtendimento;
        private long disponibilidade;

        public EspecialistaBuilder withIdEspecialista(String idEspecialista) {
            this.idEspecialista = idEspecialista;
            return this;
        }

        public EspecialistaBuilder withTipo(Servico tipo) {
            this.tipo = tipo;
            return this;
        }

        public EspecialistaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public EspecialistaBuilder withDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public EspecialistaBuilder withCondicao(Status condicao) {
            this.condicao = condicao;
            return this;
        }

        public EspecialistaBuilder withEspecializacao(Especializacao especializacao) {
            this.especializacao = especializacao;
            return this;
        }

        public EspecialistaBuilder withEndereco(Address endereco) {
            this.endereco = endereco;
            return this;
        }

        public EspecialistaBuilder withInicioAtendimento(LocalDateTime inicioAtendimento) {
            this.inicioAtendimento = inicioAtendimento;
            return this;
        }

        public EspecialistaBuilder withFimAtendimento(LocalDateTime fimAtendimento) {
            this.fimAtendimento = fimAtendimento;
            return this;
        }

        public EspecialistaBuilder withListaAtendimento(List<LocalDateTime> listaAtendimento) {
            this.listaAtendimento = listaAtendimento;
            return this;
        }

        public EspecialistaBuilder withDisponibilidade(long disponibilidade) {
            this.disponibilidade = disponibilidade;
            return this;
        }

        public Especialista build() {
            return new Especialista(this);
        }
    }
}