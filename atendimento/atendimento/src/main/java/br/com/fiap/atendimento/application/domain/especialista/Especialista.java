package br.com.fiap.atendimento.application.domain.especialista;

import br.com.fiap.atendimento.application.domain.Address;
import br.com.fiap.atendimento.application.domain.Status;

public class Especialista {
    private final String idEspecialista;
    private final Servico tipo;
    private final String nome;
    private final String descricao;
    private final Status condicao;
    private final Especializacao especializacao;
    private final Address endereco;

    public Especialista(EspecialistaBuilder builder) {
        this.idEspecialista = builder.idEspecialista;
        this.tipo = builder.tipo;
        this.nome = builder.nome;
        this.descricao = builder.descricao;
        this.condicao = builder.condicao;
        this.especializacao = builder.especializacao;
        this.endereco = builder.endereco;
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

    public static class EspecialistaBuilder {
        private String idEspecialista;
        private Servico tipo;
        private String nome;
        private String descricao;
        private Status condicao;
        private Especializacao especializacao;
        private Address endereco;

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

        public Especialista build() {
            return new Especialista(this);
        }
    }
}
