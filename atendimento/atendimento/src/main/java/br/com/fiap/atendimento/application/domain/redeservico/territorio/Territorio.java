package br.com.fiap.atendimento.application.domain.redeservico.territorio;

import br.com.fiap.atendimento.application.domain.address.Address;

public class Territorio {
    private final String idTerritorio;
    private final String nome;
    private final Address endereco;

    public Territorio(TerritorioBuilder builder) {
        this.idTerritorio = builder.idTerritorio;
        this.nome = builder.nome;
        this.endereco = builder.endereco;
    }

    public String getIdTerritorio() {
        return idTerritorio;
    }

    public String getNome() {
        return nome;
    }

    public Address getEndereco() {
        return endereco;
    }

    public static class TerritorioBuilder {
        private String idTerritorio;
        private String nome;
        private Address endereco;

        public TerritorioBuilder withIdTerritorio (String idTerritorio) {
            this.idTerritorio = idTerritorio;
            return this;
        }

        public TerritorioBuilder withNome (String nome) {
            this.nome = nome;
            return this;
        }

        public TerritorioBuilder withEndereco (Address endereco) {
            this.endereco = endereco;
            return this;
        }

        public Territorio build () {
            return new Territorio(this);
        }
    }
}
