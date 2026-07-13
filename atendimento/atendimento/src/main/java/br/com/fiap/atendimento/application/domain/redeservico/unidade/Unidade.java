package br.com.fiap.atendimento.application.domain.redeservico.unidade;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.redeservico.regiaosaude.RegiaoSaude;

public class Unidade {
    private final String idUnidade;
    private final String nome;
    private final String logradouro;
    private final String complemento;
    private final int numero;
    private final String bairro;
    private final Status status;
    private final RegiaoSaude regiaoSaude;

    public Unidade(UnidadeBuilder builder) {
        this.idUnidade = builder.idUnidade;
        this.nome = builder.nome;
        this.logradouro = builder.logradouro;
        this.complemento = builder.complemento;
        this.numero = builder.numero;
        this.bairro = builder.bairro;
        this.status = builder.status;
        this.regiaoSaude = builder.regiaoSaude;
    }

    public String getIdUnidade() {
        return idUnidade;
    }

    public String getNome() {
        return nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public Status getStatus() {
        return status;
    }

    public RegiaoSaude getRegiaoSaude() {
        return regiaoSaude;
    }

    public static class UnidadeBuilder {
        private String idUnidade;
        private String nome;
        private int numero;
        private String complemento;
        private String logradouro;
        private String bairro;
        private Status status;
        private RegiaoSaude regiaoSaude;

        public UnidadeBuilder withIdUnidade(String idUnidade) {
            this.idUnidade = idUnidade;
            return this;
        }

        public UnidadeBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public UnidadeBuilder withLogradouro(String logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public UnidadeBuilder withComplemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public UnidadeBuilder withNumero(int numero) {
            this.numero = numero;
            return this;
        }

        public UnidadeBuilder withBairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public UnidadeBuilder withStatus (Status status) {
            this.status = status;
            return this;
        }

        public UnidadeBuilder withRegiaoSaude(RegiaoSaude regiaoSaude) {
            this.regiaoSaude = regiaoSaude;
            return this;
        }

        public Unidade build () {
            return new Unidade(this);
        }
    }
}

